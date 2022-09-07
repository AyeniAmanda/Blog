package com.amanda.week9.response;

import com.amanda.week9.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RegisterResponse {

    private String message;
    private LocalDateTime dateTime;
    private User user;
}
