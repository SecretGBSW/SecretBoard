package com.example.anonymousboard.board.domain;

import com.example.anonymousboard.category.domain.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String writer;

    @JsonIgnore
    private String pw;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "contents")
    private List<Comment> comments;

    public Content(String title, String content, String writer, String pw, Category category) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.pw = pw;
        this.category = category;
    }
}
