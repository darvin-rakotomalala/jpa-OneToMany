package com.poc.controller;

import com.poc.constraint.validation.PostValidator;
import com.poc.model.dto.PostDTO;
import com.poc.service.application.PostCUDSA;
import com.poc.service.application.PostRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "posts")
public class PostController {

    private final PostCUDSA postCUDSA;
    private final PostRSA postRSA;
    private final PostValidator postValidator;

    @InitBinder("postDTO")
    protected void initPostDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(postValidator);
    }

    @Operation(summary = "WS used to save post")
    @PostMapping
    public PostDTO createPost(@RequestBody @Validated PostDTO post) {
        return postCUDSA.addPost(post);
    }

    @Operation(summary = "WS used to update post")
    @PutMapping
    public PostDTO updatePost(@RequestBody @Validated PostDTO post) {
        return postCUDSA.editPost(post);
    }

    @Operation(summary = "WS used to delete post by id")
    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable("id") Long id) {
        postCUDSA.deletePostById(id);
        return "Post with this ID " + id + " deleted successfully !";
    }

    @Operation(summary = "WS used to get post by id")
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable("id") Long id) {
        return postRSA.getPostById(id);
    }

    @Operation(summary = "WS used to get all posts")
    @GetMapping
    public HelpPage<PostDTO> getAllPostsByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return postRSA.getAllPostsByTitle(title, pageable);
    }

}
