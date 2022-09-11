package com.springbootjava.springbootjava.service;

import com.springbootjava.springbootjava.entity.BlogPost;
import com.springbootjava.springbootjava.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostRepository.findAll();
    }

    public BlogPost addBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
