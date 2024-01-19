package com.imgofday.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String feedback;
    private int score;
    private LocalDateTime dateTime;

    public Comment() {
    }

    public Comment(int id, String author, String feedback, int score, LocalDateTime dateTime) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.score = score;
        this.dateTime = dateTime;
    }
}
