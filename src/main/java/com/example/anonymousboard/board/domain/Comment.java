package com.example.anonymousboard.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    private String pw;

    private String writer;
    private String title;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    @JsonIgnore
    private Content content;

    public Comment(String pw, String writer, String title, String contents, Content content) {
        this.pw = pw;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.content = content;
    }
}
