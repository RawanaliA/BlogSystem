package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
  Blog findBlogsById(Integer id);
//  Blog getBlogsByUserId(Integer id);

    Blog getBlogByTitle(String title);

    List<Blog> findBlogsByUserId(Integer id);

}
