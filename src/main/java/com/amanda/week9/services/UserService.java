package com.amanda.week9.services;

import com.amanda.week9.dto.*;
import com.amanda.week9.response.*;

public interface UserService  {

    RegisterResponse register (UserDto userDto);

    LoginResponse login(LoginDto  loginDto);

    CreatePostResponse createPost(PostDto postDto);

    CommentResponse comment(int user_id , int post_id , CommentDto commentDto);

    LikeResponse like (int user_id, int post_id, LikeDto likeDto);

    SearchCommentResponse searchComment(String keyword);

    SearchPostResponse searchPost(String keyword);


}
