package com.imgoftheday.service;

import com.imgoftheday.entity.Comment;
import com.imgoftheday.repository.IRepository;
import com.imgoftheday.util.CommentComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    private IRepository <Comment> repository;

    @Autowired
    public CommentService(IRepository <Comment> repository) {
        this.repository = repository;
    }

    @Override
    public List <Comment> getAll() {
        return repository.getAll();
    }

    @Override
    public List <Comment> getByDateTime(LocalDateTime from, LocalDateTime to) {
        return repository.getByDateTime(from, to);
    }

    @Override
    public List <Comment> getByAuthor(String author) {
        return repository.getByAuthor(author);
    }

    @Override
    public Comment getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void save(Comment t) {
        repository.save(t);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List <Comment> sortByDate(List <Comment> comments) {
        comments.sort(new CommentComparator());
        return comments;
    }


}
