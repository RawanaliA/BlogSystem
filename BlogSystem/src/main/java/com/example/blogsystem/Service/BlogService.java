package com.example.blogsystem.Service;

import com.example.blogsystem.ApiExeption.ApiExeption;
import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.MyUser;
import com.example.blogsystem.Repository.BlogRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public List<Blog> getBlog(Integer id) {
//
        return blogRepository.findAll();
    }
    public void addBlog(Integer userid,Blog blog) {

        blog.setId(userid);
        blogRepository.save(blog);
    }
    public void updateBlog(Integer userid,Blog blog,Integer blogId) {
        Blog  oldBlog = blogRepository.findBlogsById(blogId);
        if (oldBlog == null) {

            throw new ApiExeption("Blog Not found");
        }
        if (oldBlog.getUser().getId() != userid) {
            throw new ApiExeption("Erorre,Unauthorize");
        }
        oldBlog.setBody(blog.getBody());
        oldBlog.setTitle(blog.getTitle());
        blogRepository.save(oldBlog);
    }
    public void deleteBlog(Integer userid,Integer todoId) {
        Blog  blog = blogRepository.findBlogsById(todoId);
        if (blog.getId() == null) {

            throw new ApiExeption("Blog Not found");
        }
        blogRepository.delete(blog);

    }
    public void assighnUserToBlog(Integer userId,Integer blogid){
        MyUser myUser=userRepository.findMyUserById(userId);
        Blog blog =blogRepository.findBlogsById(blogid);
        if(myUser==null||blog==null){
            throw new ApiExeption("User Or Blog are Null");
        }
        blog.setUser(myUser);
        blogRepository.save(blog);
    }
    public Blog getBlogByTitle(String title){
        return blogRepository.getBlogByTitle(title);
    }
}
