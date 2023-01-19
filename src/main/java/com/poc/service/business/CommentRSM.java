package com.poc.service.business;

import com.poc.model.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRSM {
    Comment getCommentById(Long id);
    Page<Comment> getByPostId(Long postId, Pageable pageable);
    Comment getByIdAndPostId(Long id, Long postId);
}
