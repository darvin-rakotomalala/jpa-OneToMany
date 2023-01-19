package com.poc.service.application;

import com.poc.model.dto.PostDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface PostRSA {
    public PostDTO getPostById(Long id);
    public HelpPage<PostDTO> getAllPostsByTitle(String title, Pageable pageable);
}
