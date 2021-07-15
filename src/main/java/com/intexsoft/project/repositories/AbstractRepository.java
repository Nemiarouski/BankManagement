package com.intexsoft.project.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository <T> {
    private List<T> entities = new ArrayList<>();

    protected abstract String filepath();

    public void createBank() {
        //create new entity;
    }

    public void add(T t) {
        entities.add(t);
    }

    public void delete(T t) {
        entities.remove(t);
    }

    public List<T> getT() {
        return entities;
    }

    public void save() throws IOException {
        File file = new File(filepath());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, entities);
    }

    public void download() throws IOException {
        File file = new File(filepath());
        if (file.exists() && file.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            entities = objectMapper.readValue(file, new TypeReference<>(){});
            //second variant clients = List.of(objectMapper.readValue(FILE, Client[].class));
        }
    }
}