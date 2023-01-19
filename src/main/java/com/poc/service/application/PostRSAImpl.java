package com.poc.service.application;

import com.poc.mapper.PostMapper;
import com.poc.model.dto.PostDTO;
import com.poc.service.business.PostRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostRSAImpl implements PostRSA {

    private final PostRSM postRSM;
    private final PostMapper postMapper;

    @Override
    public PostDTO getPostById(Long id) {
        return postMapper.toDTO(postRSM.getPostById(id));
    }

    @Override
    public HelpPage<PostDTO> getAllPostsByTitle(String title, Pageable pageable) {
        return postMapper.toDTO(postRSM.getAllPostsByTitle(title, pageable), pageable);
    }

}
