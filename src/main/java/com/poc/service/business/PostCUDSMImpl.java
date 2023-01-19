package com.poc.service.business;

import com.poc.model.domain.Post;
import com.poc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostCUDSMImpl implements PostCUDSM {

    private final PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        try {
            log.info("----- addPost");
            return postRepository.save(post);
        } catch (Exception e) {
            log.error("Error addPost : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Post editPost(Post post) {
        try {
            log.info("----- editPost");
            return postRepository.save(post);
        } catch (Exception e) {
            log.error("Error editPost : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deletePostById(Long id) {
        try {
            log.info("----- deletePostById : {}", id);
            postRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deletePostById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
