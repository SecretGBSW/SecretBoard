package com.example.anonymousboard.service;

import com.example.anonymousboard.domain.Category;
import com.example.anonymousboard.domain.Content;
import com.example.anonymousboard.dto.ContentAddDto;
import com.example.anonymousboard.dto.ContentGetDto;
import com.example.anonymousboard.repository.CategoryRepository;
import com.example.anonymousboard.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
                dto.getUser(),
                dto.getPw()
        );

        return contentRepository.save(content);
    }

    public Content update(int category, int contentId) {

        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        Content content = contentRepository.findById(contentId).orElse(null);

        if(content == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }

        Content updateContent = new Content(

        )
    }

    public String delete(int category, int contentId) {
        return "삭제되었습니다.";
    }
}
