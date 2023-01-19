package com.poc.service.business;

import com.poc.model.domain.Post;

public interface PostCUDSM {
    public Post addPost(Post post);
    public Post editPost(Post post);
    public void deletePostById(Long id);
}
