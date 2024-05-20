package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.dto.AddArticleRequest;
import com.example.demo.dto.UpdateArticleRequest;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request){
        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(Long id){
        return articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(id + " 게시글을 찾을 수 없습니다."));
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(id + " 게시글을 찾을 수 없습니다."));

        article.update(request.getTitle(), request.getContent(), request.getUsername(), request.getPrice());

        return article;
    }

    public boolean delete(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(id + " 게시글을 찾을 수 없습니다."));
        if (articleRepository.existsById(id)){
            articleRepository.delete(article);
            return true;
        }
        return false;
    }
}
