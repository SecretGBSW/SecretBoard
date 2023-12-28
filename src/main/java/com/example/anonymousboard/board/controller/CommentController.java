package com.example.anonymousboard.board.controller;

import com.example.anonymousboard.board.domain.Comment;
import com.example.anonymousboard.board.dto.CommentAddDto;
import com.example.anonymousboard.board.dto.CommentDeleteDto;
import com.example.anonymousboard.board.dto.CommentUpdateDto;
import com.example.anonymousboard.board.dto.ContentDeleteDto;
import com.example.anonymousboard.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{category}/contents/{contentId}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments(
            @PathVariable int category,
            @PathVariable int contentId
    ) {
        return commentService.getComments(category, contentId);
    }
    @PostMapping
    public Comment addComment(
            @PathVariable int category,
            @PathVariable int contentId,
            @RequestBody CommentAddDto dto
    ) {
        return commentService.addComment(category, contentId, dto);
    }

    @PutMapping("/{commentId}")
    public Comment update(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentUpdateDto dto
    ) {
        return commentService.update(category, contentId, commentId, dto);
    }

    @DeleteMapping("/{commentId}")
    public String delete(
            @PathVariable int category,
            @PathVariable int contentId,
            @PathVariable int commentId,
            @RequestBody CommentDeleteDto dto
            ) {
        return commentService.delete(category, contentId, commentId, dto);
    }
}
