package com.example.demo.dto;

import com.example.demo.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String username;
    private String title;
    private String content;
    private int price;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .username(username)
                .price(price)
                .build();
    }

}
