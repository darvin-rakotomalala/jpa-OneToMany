package com.poc.service.business;

import com.poc.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRSM {
    public Post getPostById(Long id);
    public Page<Post> getAllPostsByTitle(String title, Pageable pageable);
}
