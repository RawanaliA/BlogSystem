package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.MyUser;
import com.example.blogsystem.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService ;
    @GetMapping("/get")
    public ResponseEntity getBlog(@AuthenticationPrincipal MyUser myUser){

        List<Blog> blogList=blogService.getBlog(myUser.getId());
        return ResponseEntity.status(200).body(blogList);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog ){
        blogService.addBlog(myUser.getId(),blog);
        return ResponseEntity.status(200).body("blog Added");
    }
    @PutMapping("/update/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog,@PathVariable Integer blogId){
        blogService.updateBlog(myUser.getId(),blog,blogId);
        return ResponseEntity.status(200).body("blog Update it");
    }
    @PostMapping("/assign/{userId}/{blogId}")
    public ResponseEntity addBlog(@PathVariable Integer userId, Integer blogId){
        blogService.assighnUserToBlog(userId, blogId);
        return ResponseEntity.status(200).body("blog Assigened");
    }
    @GetMapping("/getTitle/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body("blog found It");
    }


    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity deleteTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId ){
        blogService.deleteBlog(myUser.getId(),blogId);
        return ResponseEntity.status(200).body("Blog deleteed ");
    }

}
