package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.PostMapper;
import com.poc.model.dto.PostDTO;
import com.poc.service.business.PostCUDSM;
import com.poc.service.business.PostRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostCUDSAImpl implements PostCUDSA {

    private final PostCUDSM postCUDSM;
    private final PostRSM postRSM;
    private final PostMapper postMapper;

    @Override
    public PostDTO addPost(PostDTO post) {
        return postMapper.toDTO(postCUDSM.addPost(postMapper.toDO(post)));
    }

    @Override
    public PostDTO editPost(PostDTO post) {
        if (post.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_POST_ID_EMPTY.getErrorMessage());
        }
        PostDTO postFound = postMapper.toDTO(postRSM.getPostById(post.getId()));
        postFound.setTitle(post.getTitle());
        postFound.setDescription(post.getDescription());
        postFound.setContent(post.getContent());
        return postMapper.toDTO(postCUDSM.editPost(postMapper.toDO(postFound)));
    }

    @Override
    public void deletePostById(Long id) {
        PostDTO postFound = postMapper.toDTO(postRSM.getPostById(id));
        postCUDSM.deletePostById(postFound.getId());
    }

}
