package com.example.demo.dto;

import com.example.demo.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArticleListViewResponse {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.price = article.getPrice();
        this.username = article.getUsername();
    }

}
