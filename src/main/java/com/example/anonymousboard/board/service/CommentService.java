package com.example.anonymousboard.board.service;

import com.example.anonymousboard.board.dto.*;
import com.example.anonymousboard.category.domain.Category;
import com.example.anonymousboard.board.domain.Comment;
import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.category.repository.CategoryRepository;
import com.example.anonymousboard.board.repository.CommentRepository;
import com.example.anonymousboard.board.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        Content checkContent = contentRepository.findById(contentId).orElse(null);

        if(checkContent == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }

        return commentRepository.findAllByContentId(contentId);
    }

    public String addComment(int category, int contentId, CommentAddDto dto) {
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
          dto.getContent(),
          checkContent
        );

        commentRepository.save(addComment);

        return "댓글이 추가가 완료되었습니다.";
    }

    public String update(int category, int contentId, int commentId, CommentUpdateDto dto) {
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
            throw new IllegalArgumentException("댓글이 존재하지 않습니다.");
        }

        if(!passwordEncoder.matches(dto.getPw(), checkComment.getPw())) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }

        checkComment.setWriter(dto.getWriter());
        checkComment.setTitle(dto.getTitle());
        checkComment.setContents(dto.getContents());

        commentRepository.save(checkComment);
        return "댓글 수정이 완료되었습니다.";
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

        Comment checkComment = commentRepository.findById(commentId).orElse(null);

        if(checkComment == null) {
            throw new IllegalArgumentException("댓글이 없습니다.");
        }

        if(!passwordEncoder.matches(dto.getPw(), checkComment.getPw())) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }

        commentRepository.deleteById(commentId);

        return "댓글이 수정이 완료되었습니다.";
    }
}
