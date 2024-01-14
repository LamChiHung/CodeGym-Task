package com.imgoftheday.service;

import com.imgoftheday.entity.Comment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ICommentService {
    List <Comment> getAll();

    List <Comment> getByDateTime(LocalDateTime from, LocalDateTime to);

    List <Comment> getByAuthor(String author);

    Comment getById(int id);

    void save(Comment t);

    void delete(int id);

    List <Comment> sortByDate(List <Comment> comments);
}
