package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Comment;
import com.poc.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentRSMImpl implements CommentRSM {

    private final CommentRepository commentRepository;
    private final PostRSM postRSM;

    @Override
    public Comment getCommentById(Long id) {
        try {
            log.info("----- getCommentById : {}", id);
            Optional<Comment> commentFound = commentRepository.findById(id);
            if (commentFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_COMMENT_NOT_FOUND.getErrorMessage());
            }
            return commentFound.get();
        } catch (Exception e) {
            log.error("Error getCommentById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    @Override
    public Page<Comment> getByPostId(Long postId, Pageable pageable) {
        try {
            log.info("----- getByPostId : {}", postId);
            if (postId == null) {
                return commentRepository.findAll(pageable);
            } else {
                return commentRepository.findByPostId(postId, pageable);
            }
        } catch (Exception e) {
            log.error("Error getByPostId : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    @Override
    public Comment getByIdAndPostId(Long id, Long postId) {
        try {
            log.info("----- getByIdAndPostId : {} {}", id, postId);
            Optional<Comment> commentFound = commentRepository.findByIdAndPostId(id, postId);
            if (commentFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_COMMENT_NOT_FOUND.getErrorMessage());
            }
            return commentFound.get();
        } catch (Exception e) {
            log.error("Error getByIdAndPostId : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
