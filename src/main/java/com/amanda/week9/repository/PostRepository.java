package com.amanda.week9.repository;

import com.amanda.week9.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByTitleContaining(String keyword);

}
