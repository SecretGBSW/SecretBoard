package com.example.anonymousboard.board.service;

import com.example.anonymousboard.board.dto.CommentDeleteDto;
import com.example.anonymousboard.board.dto.ContentDeleteDto;
import com.example.anonymousboard.category.domain.Category;
import com.example.anonymousboard.board.domain.Comment;
import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.board.dto.CommentAddDto;
import com.example.anonymousboard.board.dto.CommentUpdateDto;
import com.example.anonymousboard.category.repository.CategoryRepository;
import com.example.anonymousboard.board.repository.CommentRepository;
import com.example.anonymousboard.board.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Comment> getComments(int category, int contentId) {
        Category checkCategory = categoryRepository.findById(category).orElse(null);

        if(checkCategory == null) {
            throw new IllegalArgumentException("카테고리가 없습니다.");
        }

        return commentRepository.findAllById(contentId);
    }

    public Comment addComment(int category, int contentId, CommentAddDto dto) {
        Category checkCategory = categoryRepository.findById(category).orElse(null);

        if(checkCategory == null) {
            throw new IllegalArgumentException("카테고리가 없습니다.");
        }

        Content checkContent = contentRepository.findById(contentId).orElse(null);

        if(checkContent == null) {
            throw new IllegalArgumentException("게시글이 없습니다.");
        }

        Comment addComment = new Comment(
                passwordEncoder.encode(dto.getPw()),
                dto.getWriter(),
                dto.getTitle(),
                dto.getContent()
        );

        return commentRepository.save(addComment);
    }

    public Comment update(int category, int contentId, int commentId, CommentUpdateDto dto) {
        Category checkCategory = categoryRepository.findById(category).orElse(null);

        if(checkCategory == null) {
            throw new IllegalArgumentException("카테고리가 없습니다.");
        }

        Content checkContent = contentRepository.findById(contentId).orElse(null);

        if(checkContent == null) {
            throw new IllegalArgumentException("게시글이 없습니다.");
        }

        Comment checkComment = commentRepository.findById(commentId).orElse(null);

        if(checkComment == null) {
            throw new IllegalArgumentException("댓글이 없습니다.");
        }

        if(!checkComment.getPw().equals(dto.getPw())) {
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }

        checkComment = new Comment(
                dto.getPw(),
                checkComment.getWriter(),
                checkComment.getTitle(),
                checkComment.getContent()
        );

        return commentRepository.save(checkComment);
    }

    public String delete(int category, int contentId, int commentId, CommentDeleteDto dto) {
        Category checkCategory = categoryRepository.findById(category).orElse(null);

        if(checkCategory == null) {
            throw new IllegalArgumentException("카테고리가 없습니다.");
        }

        Content checkContent = contentRepository.findById(contentId).orElse(null);

        if(checkContent == null) {
            throw new IllegalArgumentException("게시글이 없습니다.");
        }

        if(!checkContent.getPw().equals(dto.getPw())) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }

        commentRepository.deleteById(commentId);

        return "게시글이 삭제되었습니다.";
    }
}
