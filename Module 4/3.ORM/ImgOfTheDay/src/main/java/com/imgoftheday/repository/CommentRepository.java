package com.imgoftheday.repository;

import com.imgoftheday.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements IRepository <Comment> {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List <Comment> getAll() {
        String query = "SELECT c FROM Comment AS c";
        TypedQuery <Comment> typedQuery = entityManager.createQuery(query, Comment.class);
        return typedQuery.getResultList();
    }

    @Override
    public List <Comment> getByDateTime(LocalDateTime from, LocalDateTime to) {
        String query = "SELECT c FROM Comment As c WHERE c.dateTime BETWEEN :from AND :to";
        TypedQuery <Comment> typedQuery = entityManager.createQuery(query, Comment.class);
        typedQuery.setParameter("from", from);
        typedQuery.setParameter("to", to);
        return typedQuery.getResultList();
    }

    @Override
    public List <Comment> getByAuthor(String author) {
        String query = "SELECT c FROM Comment AS c WHERE c.author LIKE :author";
        TypedQuery <Comment> typedQuery = entityManager.createQuery(query, Comment.class);
        String likeAuthor = "%" + author + "%";
        typedQuery.setParameter("author", likeAuthor);
        return typedQuery.getResultList();
    }

    @Override
    public Comment getById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() == 0) {
            entityManager.persist(comment);
        } else {
            entityManager.merge(comment);
        }
    }

    @Override
    public void delete(int id) {
        Comment comment = getById(id);
        entityManager.remove(comment);
    }
}
