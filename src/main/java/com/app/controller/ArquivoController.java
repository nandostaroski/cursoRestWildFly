package com.app.controller;

import com.app.entity.Arquivo;
import com.app.repository.ArquivoRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Fernando on 03/06/2018.
 */
@RestController
public class ArquivoController {
    @Autowired
    ArquivoRepository repository;

    private final GridFsTemplate gridFsTemplate;

    @Autowired
    public ArquivoController(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    @RequestMapping(value = "/arquivo", method = RequestMethod.POST)
    public String save(@RequestParam("file") MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();

        Arquivo arquivo = new Arquivo();

        arquivo.setDescricao(file.getOriginalFilename());
        arquivo.setTamanho(file.getSize());

        repository.save(arquivo);

        metaData.put("idArquivo", arquivo.getId());

        gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData).save();

        return "OK";
    }

    public List<Arquivo> list() {
        List<Arquivo> arquivos = repository.findAll();

        return arquivos.stream().filter(p -> p.getTamanho() < 16127).collect(Collectors.toList());
    }

    @RequestMapping(value = "/arquivo/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> get(@PathVariable("id") String id) {
        try {
            Arquivo arquivo = repository.findOne(id);
            Optional<GridFSDBFile> optionalCreated = loadById(arquivo.getId());
            if (optionalCreated.isPresent()) {
                GridFSDBFile created = optionalCreated.get();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                created.writeTo(os);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, created.getContentType());
                return new HttpEntity<byte[]>(os.toByteArray(), headers);
            } else {
                return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            return new ResponseEntity<byte[]>(HttpStatus.IM_USED);
        }
    }

    private Optional<GridFSDBFile> loadById(String id) {
        GridFSDBFile file = gridFsTemplate.findOne(getMetaDataQuery(id));
        return Optional.ofNullable(file);
    }

    private Query getMetaDataQuery(String id) {
        return Query.query(GridFsCriteria.whereMetaData("idArquivo").is(id));
    }


}
