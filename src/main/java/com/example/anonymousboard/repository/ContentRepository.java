package com.example.anonymousboard.repository;

import com.example.anonymousboard.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findAllCategoryId(int category);
}