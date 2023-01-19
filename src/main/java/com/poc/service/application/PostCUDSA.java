package com.poc.service.application;

import com.poc.model.dto.PostDTO;

public interface PostCUDSA {
    public PostDTO addPost(PostDTO post);
    public PostDTO editPost(PostDTO post);
    public void deletePostById(Long id);
}
