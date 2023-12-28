package com.example.anonymousboard.board.service;

import com.example.anonymousboard.board.dto.ContentDeleteDto;
import com.example.anonymousboard.category.domain.Category;
import com.example.anonymousboard.board.domain.Content;
import com.example.anonymousboard.board.dto.ContentAddDto;
import com.example.anonymousboard.board.dto.ContentGetDto;
import com.example.anonymousboard.board.dto.ContentUpdateDto;
import com.example.anonymousboard.category.repository.CategoryRepository;
import com.example.anonymousboard.board.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<ContentGetDto> getContents(int category) {
        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        return contentRepository.findByCategoryId(category);
    }

    public Content getContent(int category, int contentId) {
        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        Content content = contentRepository.findById(contentId).orElse(null);

        if(content == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }

        return content;
    }

    public Content add(int category, ContentAddDto dto) {
        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        Content content = new Content(
                dto.getTitle(),
                dto.getContent(),
                passwordEncoder.encode(dto.getWriter()),
                dto.getPw()
        );

        return contentRepository.save(content);
    }

    public Content update(int category, int contentId, ContentUpdateDto dto) {

        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        Content content = contentRepository.findById(contentId).orElse(null);

        if(content == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }

        if(passwordEncoder.matches(dto.getPw(), content.getPw())) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }

        content = new Content(
                dto.getTitle(),
                dto.getContent(),
                dto.getWriter(),
                content.getPw()
        );

        return contentRepository.save(content);
    }

    public String delete(int category, int contentId, ContentDeleteDto dto) {

        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("삭제할 카테고리가 존재하지 않습니다.");
        }

        Content content = contentRepository.findById(contentId).orElse(null);

        if(content == null) {
            throw new IllegalArgumentException("삭제할 게시글이 존재하지 않습니다.");
        }

        if(passwordEncoder.matches(dto.getPw(), content.getPw())) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다.");
        }

        contentRepository.deleteById(contentId);

        return "삭제되었습니다.";
    }
}
