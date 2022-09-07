package com.amanda.week9.response;

import com.amanda.week9.model.Comments;
import com.amanda.week9.model.Like;
import com.amanda.week9.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class CommentResponse {
    private String message;
    private LocalDateTime dateTime;
    private Comments comment;
    private Post post;

}
