package com.intexsoft.project.services;

import com.intexsoft.project.repositories.AbstractRepository;
import java.io.IOException;
import java.util.List;

public abstract class AbstractService <E, T extends AbstractRepository<E>> {
    private final T t;

    public AbstractService(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void deleteEntity(E e) {
        t.deleteEntity(e);
    }

    public List<E> getEntities() {
        return t.getEntities();
    }

    public void save() {
        try {
            t.saveEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }

    public void download() {
        try {
            t.downloadEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }
}