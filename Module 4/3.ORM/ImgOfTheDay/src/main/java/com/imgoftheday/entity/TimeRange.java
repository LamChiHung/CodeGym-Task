package com.imgoftheday.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class TimeRange {
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeRange() {
    }

    public TimeRange(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
