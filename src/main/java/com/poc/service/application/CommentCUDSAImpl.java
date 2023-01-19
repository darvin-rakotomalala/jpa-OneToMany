package com.poc.service.application;

import com.poc.mapper.CommentMapper;
import com.poc.model.dto.CommentDTO;
import com.poc.service.business.CommentCUDSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentCUDSAImpl implements CommentCUDSA {

    private final CommentCUDSM commentCUDSM;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO createComment(CommentDTO comment) {
        return commentMapper.toDTO(commentCUDSM.createComment(comment.getIdPost(), commentMapper.toDO(comment)));
    }

    @Override
    public CommentDTO updateComment(CommentDTO comment) {
        return commentMapper.toDTO(commentCUDSM.updateComment(comment.getIdPost(), comment.getId(), commentMapper.toDO(comment)));
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        commentCUDSM.deleteComment(postId, commentId);
    }

}
