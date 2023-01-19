package com.poc.service.application;

import com.poc.model.dto.CommentDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface CommentRSA {
    CommentDTO getCommentById(Long id);
    HelpPage<CommentDTO> getByPostId(Long postId, Pageable pageable);
    CommentDTO getByIdAndPostId(Long id, Long postId);
}
