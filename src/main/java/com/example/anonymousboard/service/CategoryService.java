package com.example.anonymousboard.service;

import com.example.anonymousboard.domain.Category;
import com.example.anonymousboard.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategory() {
        return repository.findAll();
    }
}
