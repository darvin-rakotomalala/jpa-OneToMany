package com.poc.service.business;

import com.poc.model.domain.Comment;

public interface CommentCUDSM {
    Comment createComment(Long postId, Comment comment);
    Comment updateComment(Long postId, Long commentId, Comment comment);
    void deleteComment(Long postId, Long commentId);
}
