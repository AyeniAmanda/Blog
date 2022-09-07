package com.amanda.week9.response;

import com.amanda.week9.model.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class LikeResponse {
    private String message;
    private LocalDateTime dateTime;
    private Like like;
    private int totalLike;



}
