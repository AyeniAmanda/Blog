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
import com.amanda.week9.response.LoginResponse;
import com.amanda.week9.response.RegisterResponse;
import com.amanda.week9.serviceImpl.UserServiceImpl;
import com.amanda.week9.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Calendar.SEPTEMBER;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;





@SpringBootTest
@AutoConfigureMockMvc
public class UserImplTest {

    @MockBean
    UserRepository userRepository;
   @Autowired
   MockMvc mockMvc;

    @MockBean
    PostRepository postRepository;

    @MockBean
    LikeRepository likeRepository;

    @MockBean
    CommentRepository commentRepository;

    @MockBean
    UserService userServiceImpl;

    private User user;

    private Post post;

    private Like like;

    private Comments comment;


    private LocalDateTime dateTime;

    List<Like> likeList = new ArrayList<>();
    List<Post> postList = new ArrayList<>();
    List<Comments> commentList = new ArrayList<>();
    List<User> userList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        dateTime = LocalDateTime.of(2022,SEPTEMBER,7,4,20,40,3000);
        user = new User(1 , "amanda" , "amanda@gmail.com" , "1234" , "Admin" , dateTime , dateTime  , postList , commentList , likeList);
        post = new Post(1 , "title of post" , "small description" , "title-of-post" , "0xEsddfmk.png", dateTime , dateTime , user, likeList , commentList);
        like = new Like(1 , true , dateTime , dateTime , user , post);
        comment = new Comments(1 , "lovely" , dateTime , dateTime , user , post);


    }

    @Test
    void register() throws Exception {
        UserDto userDTO = new UserDto( "amanda" , "amanda@gmail.com" , "Admin" , "1234" );
       //when(userServiceImpl.register(userDTO)).thenReturn(registerResponse());
        any(User.class).thenReturn(registerResponse());


        RegisterResponse registerResponse = new RegisterResponse("successful" , dateTime,user);
        System.out.println(registerResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter obj = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = obj.writeValueAsString(userDTO);

        //var actual =  userServiceImpl.register(userDTO);
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\n" +
                        "    \"name\":\"NONSO\",\n" +
                        "    \"email\":\"NONSO@gmail.com\",\n" +
                        "    \"role\":\"User\",\n" +
                        "    \"password\":\"1234\"\n" +
                        "}").accept(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$",is("successful")));
//        System.out.println("from actual " + actual);
//        actual.setDateTime(dateTime);
//        actual.getUser().setCreatedAt(dateTime);
//        actual.getUser().setUpdatedAt(dateTime);
//        actual.getUser().setId(1);
//        assertEquals(registerResponse.getMessage(),actual.getMessage());
//        assertEquals(registerResponse.getDateTime(),actual.getDateTime());
//        assertEquals(registerResponse.getUser(),actual.getUser());

    }

    private RegisterResponse registerResponse(){
        RegisterResponse registerResponse = new RegisterResponse("successful",dateTime,user);
        System.out.println("from register response " + registerResponse);
        return registerResponse;

    }


//    @Test
//    void Login() {
//        LoginDto loginDto = new LoginDto("amanda@gmail.com" , "1234");
//        when(userRepository.findUserByEmail("amanda@gmail.com")).thenReturn(Optional.ofNullable(user));
//        LoginResponse loginResponse = new LoginResponse("success" , dateTime);
//        var actual =  userServiceImpl.login(loginDto);
//        actual.setDateTime(dateTime);
//        assertEquals(loginResponse , actual);
//    }




//    @Test
//    void findUserById() {
//        when(userRepository.findById(1)).thenReturn(Optional.ofNullable(user));
//        assertEquals(user , userServiceImpl.findUserById(1));
//    }
//
//    @Test
//    void findPostById() {
//        when(postRepository.findById(1)).thenReturn(Optional.ofNullable(post));
//        assertEquals(post , userServiceImpl.findPostById(1));
//    }
//
//    @Test
//    void findUserByEmail() {
//        when(userRepository.findUserByEmail("amanda@gmail.com")).thenReturn(Optional.ofNullable(user));
//        assertEquals(user , userServiceImpl.findUserByEmail("amanda@gmail.com"));
//    }









}
