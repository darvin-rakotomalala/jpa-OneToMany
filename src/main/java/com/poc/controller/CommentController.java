package com.poc.controller;

import com.poc.constraint.validation.CommentValidator;
import com.poc.model.dto.CommentDTO;
import com.poc.service.application.CommentCUDSA;
import com.poc.service.application.CommentRSA;
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
@RequestMapping
public class CommentController {

    private final CommentCUDSA commentCUDSA;
    private final CommentRSA commentRSA;
    private final CommentValidator commentValidator;

    @InitBinder("commentDTO")
    protected void initCommentDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(commentValidator);
    }

    @Operation(summary = "WS used to create comment")
    @PostMapping("/comments")
    public CommentDTO createComment(@RequestBody @Validated CommentDTO comment) {
        return commentCUDSA.createComment(comment);
    }

    @Operation(summary = "WS used to update comment")
    @PutMapping("/comments")
    public CommentDTO updateComment(@RequestBody @Validated CommentDTO comment) {
        return commentCUDSA.updateComment(comment);
    }

    @Operation(summary = "WS used to delete comment by postId and commentId")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public String deleteComment(@PathVariable(value = "postId") Long postId,
                                @PathVariable(value = "commentId") Long commentId) {
        commentCUDSA.deleteComment(postId, commentId);
        return "Comment with id " + commentId + " and postId " + postId + " deleted successfully !";
    }

    @Operation(summary = "WS used to get comment by id")
    @GetMapping("/comments/{commentId}")
    public CommentDTO getCommentById(@PathVariable(value = "commentId") Long commentId) {
        return commentRSA.getCommentById(commentId);
    }

    @Operation(summary = "WS used to get all comments by postId")
    @GetMapping("/comments/byPostId")
    public HelpPage<CommentDTO> getByPostId(
            @RequestParam(name = "postId", required = false) Long postId,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return commentRSA.getByPostId(postId, pageable);
    }

    @Operation(summary = "WS used to get comment by commentId and postId")
    @GetMapping("comments/{commentId}/posts/{postId}")
    public CommentDTO getByIdAndPostId(
            @PathVariable(value = "commentId") Long commentId,
            @PathVariable(value = "postId") Long postId) {
        return commentRSA.getByIdAndPostId(commentId, postId);
    }

}
