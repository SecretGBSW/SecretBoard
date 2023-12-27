package com.example.anonymousboard.service;

import com.example.anonymousboard.domain.Category;
import com.example.anonymousboard.domain.Content;
import com.example.anonymousboard.dto.AddContentDto;
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

    public List<Content> getContent(int category) {
        Category findeCategory = categoryRepository.findById(category).orElse(null);

        if(findeCategory == null) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        return contentRepository.findAllCategoryId(category);
    }

    public Content add(int category, AddContentDto dto) {
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
}
