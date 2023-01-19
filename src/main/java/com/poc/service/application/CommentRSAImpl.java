package com.poc.service.application;

import com.poc.mapper.CommentMapper;
import com.poc.model.dto.CommentDTO;
import com.poc.service.business.CommentRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentRSAImpl implements CommentRSA {

    private final CommentRSM commentRSM;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO getCommentById(Long id) {
        return commentMapper.toDTO(commentRSM.getCommentById(id));
    }

    @Override
    public HelpPage<CommentDTO> getByPostId(Long postId, Pageable pageable) {
        return commentMapper.toDTO(commentRSM.getByPostId(postId, pageable), pageable);
    }

    @Override
    public CommentDTO getByIdAndPostId(Long id, Long postId) {
        return commentMapper.toDTO(commentRSM.getByIdAndPostId(id, postId));
    }

}
