package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int price;

    @Column
    private String username;

    @Builder
    public Article(String username, String title, String content, int price){
        this.title = title;
        this.content = content;
        this.username = username;
        this.price = price;
    }

    public void update(String title, String content, String username, int price) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.price = price;
    }
}
