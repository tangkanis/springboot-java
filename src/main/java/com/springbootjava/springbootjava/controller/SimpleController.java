package com.springbootjava.springbootjava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootjava.springbootjava.entity.BlogPost;
import com.springbootjava.springbootjava.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private static Logger log = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    BlogPostService blogPostService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${key}")
    private String key;

    @GetMapping(value = "/hello")
    public String hello() {
        System.out.println("Hello World");
        log.info("key: " + key);
        return "hello world";
    }

    @GetMapping(value = "/getBlogPostList")
    public List<BlogPost> getBlogPostList() {
        return blogPostService.getBlogPostList();
    }

    @PostMapping(value = "/addBlogPost")
    public BlogPost addBlogPost (@RequestBody BlogPost blogPostRequest) throws IOException {
        log.info("key: " + key);
//        BlogPost b = objectMapper.readValue(blogPostRequest, BlogPost.class);
        return blogPostService.addBlogPost(blogPostRequest);
    }
}
