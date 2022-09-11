package com.springbootjava.springbootjava.repository;

import com.springbootjava.springbootjava.entity.BlogPost;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AutoConfiguration
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    List<BlogPost> findAll();

    BlogPost findById(long id);
    BlogPost save(BlogPost blog);
}
