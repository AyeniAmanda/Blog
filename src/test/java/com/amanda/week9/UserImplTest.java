package com.amanda.week9;

import com.amanda.week9.dto.*;
import com.amanda.week9.model.Comments;
import com.amanda.week9.model.Like;
import com.amanda.week9.model.Post;
import com.amanda.week9.model.User;
import com.amanda.week9.repository.CommentRepository;
import com.amanda.week9.repository.LikeRepository;
import com.amanda.week9.repository.PostRepository;
import com.amanda.week9.repository.UserRepository;
import com.amanda.week9.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PostRepository postRepository;

    @Mock
    LikeRepository likeRepository;

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    private User user;

    private Post post;

    private Like like;

    private Comments comment;

    private CommentDto commentDto;

    private LikeDto likedto;

    private LoginDto loginDto;

    private PostDto postDto;

    private UserDto userDto;

    private LocalDateTime dateTime;



    @BeforeEach
    void setUp(){

    }








}
