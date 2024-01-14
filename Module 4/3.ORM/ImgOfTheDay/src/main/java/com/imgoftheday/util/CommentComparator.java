package com.imgoftheday.util;

import com.imgoftheday.entity.Comment;

import java.util.Comparator;

public class CommentComparator implements Comparator <Comment> {
    @Override
    public int compare(Comment o1, Comment o2) {
        int compareValue = o1.getDateTime().compareTo(o2.getDateTime());
        return - compareValue;
    }
}
