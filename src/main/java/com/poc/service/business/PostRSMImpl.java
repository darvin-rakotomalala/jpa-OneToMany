package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Post;
import com.poc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostRSMImpl implements PostRSM {

    private final PostRepository postRepository;

    @Override
    public Post getPostById(Long id) {
        try {
            log.info("----- getPostById : {}", id);
            Optional<Post> postFound = postRepository.findById(id);
            if (postFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_POST_NOT_FOUND.getErrorMessage());
            }
            return postFound.get();
        } catch (Exception e) {
            log.error("Error getPostById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Post> getAllPostsByTitle(String title, Pageable pageable) {
        try {
            log.info("----- getAllPostsByTitle : {}", title);
            if (StringUtils.isBlank(title)) {
                return postRepository.findAll(pageable);
            } else {
                return postRepository.findByTitle(title, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllPostsByTitle : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
