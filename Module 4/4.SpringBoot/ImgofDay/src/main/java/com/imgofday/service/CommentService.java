package com.imgofday.service;


import com.imgofday.entity.Comment;
import com.imgofday.repository.CommentRepository;
import com.imgofday.util.CommentComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    private CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List <Comment> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List <Comment> getByDateTime(LocalDateTime from, LocalDateTime to) {
//        return this.repository.getByDate(from, to);
        return null;
    }

    @Override
    public List <Comment> getByAuthor(String author) {
        return null;
    }


    @Override
    public Comment getById(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment t) {
        this.repository.save(t);
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List <Comment> sortByDate(List <Comment> comments) {
        comments.sort(new CommentComparator());
        return comments;
    }


}
