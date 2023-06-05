package com.example.blogsystem.Service;

import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.MyUser;
import com.example.blogsystem.Repository.BlogRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class AuthMyUserService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    public List<MyUser> getAllUsers(){
        List<MyUser> allUsers=  userRepository.findAll();
        return allUsers;
    }
    public void register(MyUser myUser){
        String hash=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hash);
        userRepository.save(myUser);
    }
    public  List<Blog> getBlogByUser(Integer id){
       return blogRepository.getBlogsByUserId(id);
    }



}
