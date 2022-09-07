package com.amanda.week9.repository;

import com.amanda.week9.model.Comments;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments,Integer> {

    List<Comments> findByCommentContaining(String keyword);

}
