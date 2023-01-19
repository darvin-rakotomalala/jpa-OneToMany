package com.poc.service.business;

import com.poc.model.domain.Comment;
import com.poc.model.domain.Post;
import com.poc.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentCUDSMImpl implements CommentCUDSM {

    private final CommentRepository commentRepository;
    private final CommentRSM commentRSM;
    private final PostRSM postRSM;

    @Override
    public Comment createComment(Long postId, Comment comment) {
        try {
            log.info("----- createComment : {}", postId);
            Post postFound = postRSM.getPostById(postId);
            Comment newComment = new Comment();
            newComment.setText(comment.getText());
            newComment.setPost(postFound);
            return commentRepository.save(newComment);
        } catch (Exception e) {
            log.error("Error createComment : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Comment updateComment(Long postId, Long commentId, Comment comment) {
        try {
            log.info("----- updateComment : {} {}", postId, commentId);
            Post postFound = postRSM.getPostById(postId);
            Comment commentFound = commentRSM.getCommentById(commentId);
            commentFound.setText(comment.getText());
            commentFound.setPost(postFound);
            return commentRepository.save(commentFound);
        } catch (Exception e) {
            log.error("Error updateComment : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    @Override
    public void deleteComment(Long postId, Long commentId) {
        try {
            log.info("----- deleteComment : {} {}", postId, commentId);
            Comment commentFound = commentRSM.getByIdAndPostId(postId, commentId);
            commentRepository.delete(commentFound);
        } catch (Exception e) {
            log.error("Error deleteComment : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
