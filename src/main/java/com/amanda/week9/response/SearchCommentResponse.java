package com.amanda.week9.response;

import com.amanda.week9.model.Comments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class SearchCommentResponse {
    private String message;
    private LocalDateTime dateTime;
    private List<Comments> commentsList;
}
