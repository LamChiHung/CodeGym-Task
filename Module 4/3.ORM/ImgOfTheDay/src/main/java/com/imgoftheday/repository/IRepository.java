package com.imgoftheday.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepository <T> {
    List <T> getAll();

    List <T> getByDateTime(LocalDateTime from, LocalDateTime to);

    List <T> getByAuthor(String author);

    T getById(int id);

    void save(T t);

    void delete(int id);
}
