package com.imgoftheday.entity;

import java.time.LocalDateTime;

public class TimeRange {
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeRange() {
        this.from = LocalDateTime.of(1990, 1, 1, 0, 0, 0);
        this.to = LocalDateTime.of(2990, 1, 1, 0, 0, 0);
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
