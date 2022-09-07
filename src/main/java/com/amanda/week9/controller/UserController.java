package com.amanda.week9.controller;

import com.amanda.week9.dto.*;

import com.amanda.week9.response.*;
import com.amanda.week9.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequestMapping( value = "/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody UserDto userDto) {
        log.info("Successfully Registered {} ", userDto.getEmail());
        return new ResponseEntity<>(userService.register(userDto),CREATED);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CreatePostResponse> create(@RequestBody PostDto postDto) {
        log.info("Successfully Created A post With Title:  {} ", postDto.getTitle());
       return new ResponseEntity<>(userService.createPost(postDto),CREATED);
    }

    @PostMapping(value = "/comment/{user_id}/{post_id}")
    public ResponseEntity<CommentResponse> comment(@PathVariable(value = "user_id") Integer user_id, @PathVariable(value = "post_id") Integer post_id, @RequestBody CommentDto commentDto) {
        log.info("Successfully commented :  {} ", commentDto.getComment());
        return new ResponseEntity<>(userService.comment(user_id,post_id,commentDto),CREATED);
    }

    @PostMapping(value = "/like/{user_id}/{post_id}")
    public ResponseEntity<LikeResponse> like(@PathVariable(value = "user_id") Integer user_id, @PathVariable(value = "post_id") Integer post_id, @RequestBody LikeDto likeDto) {
        log.info("Successfully liked :  {} ", likeDto.isLiked());
        return new ResponseEntity<>(userService.like(user_id,post_id,likeDto),CREATED);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto){
           return new ResponseEntity<>(userService.login(loginDto),ACCEPTED);
    }


    @GetMapping(value = "/searchComment/{keyword}")
        public ResponseEntity<SearchCommentResponse> commentResponse (@PathVariable (value = "keyword") String keyword) {
        return new ResponseEntity<>(userService.searchComment(keyword),OK);

    }

    @GetMapping(value = "/searchPost/{keyword}")
    public ResponseEntity<SearchPostResponse> postResponse(@PathVariable (value = "keyword") String keyword){
        return new ResponseEntity<>(userService.searchPost(keyword),OK);
    }





}
