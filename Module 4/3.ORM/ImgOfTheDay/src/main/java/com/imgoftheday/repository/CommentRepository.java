package com.imgoftheday.repository;

import com.imgoftheday.entity.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository

public class CommentRepository implements IRepository <Comment> {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

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
        String query = "SELECT c FROM Comment AS c WHERE c.id = :id";
        TypedQuery <Comment> typedQuery = entityManager.createQuery(query, Comment.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = null;
            if (comment.getId() == 0) {
                origin = new Comment();
            } else {
                origin = getById(comment.getId());
            }
            origin.setAuthor(comment.getAuthor());
            origin.setFeedback(comment.getFeedback());
            origin.setDateTime(comment.getDateTime());
            origin.setScore(comment.getScore());
            session.save(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = getById(id);
            session.remove(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
