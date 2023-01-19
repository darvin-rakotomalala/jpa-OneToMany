package com.poc.service.application;

import com.poc.model.dto.CommentDTO;

public interface CommentCUDSA {
    CommentDTO createComment(CommentDTO comment);
    CommentDTO updateComment(CommentDTO comment);
    void deleteComment(Long postId, Long commentId);
}
