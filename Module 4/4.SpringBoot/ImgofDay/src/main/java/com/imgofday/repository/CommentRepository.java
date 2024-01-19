package com.imgofday.repository;

import com.imgofday.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Integer> {
//    @Query(value = "SELECT c FROM Comment AS  c WHERE Comment.dateTime between :from and :to")
//    List <Comment> getByDate(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

}
