package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.dto.AddArticleRequest;
import com.example.demo.dto.ArticleListViewResponse;
import com.example.demo.dto.UpdateArticleRequest;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/post")
    public ResponseEntity<Article> addArticle (@RequestBody AddArticleRequest request){
        Article savedArticle = articleService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/post")
    public ResponseEntity<List<ArticleListViewResponse>> findAllArticles(){
        List<ArticleListViewResponse> articles = articleService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Article> findArticle(@PathVariable Long id){
        Article article = articleService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(article);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request){
        Article article = articleService.update(id, request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(article);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Map<String,String>> deleteArticle(@PathVariable Long id){
        boolean isDeleted = articleService.delete(id);

        Map<String, String> response = new HashMap<>();

        if (isDeleted){
            response.put("msg", "삭제완료");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("msg", "삭제실패");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
