package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.MyUser;
import com.example.blogsystem.Service.AuthMyUserService;
import com.example.blogsystem.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private  final AuthMyUserService authMyUserService;

    @GetMapping("/get")
    private ResponseEntity allusers(){
        List<MyUser> allUsers=  authMyUserService.getAllUsers();

        return ResponseEntity.status(200).body(allUsers);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        authMyUserService.register(myUser);
        return ResponseEntity.status(200).body("User Register");
    }
    @PostMapping("/getuserBy/{id}")
    public ResponseEntity getBlogByUser(@PathVariable Integer id){
        authMyUserService.getBlogByUser(id);
        return ResponseEntity.status(200).body("User founded");
    }

}
