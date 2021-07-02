package com.example.tdspring.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.example.tdspring.entities.AppUser;
import com.example.tdspring.entities.Article;
import com.example.tdspring.exception.ResourceNotFoundException;
import com.example.tdspring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("articles/{id}")
    private Optional<Article> getArticlesById(@Valid @RequestBody Integer id) {
        return articleRepository.findById(id);
    }

    @GetMapping("articles")
    private List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @PostMapping("articles")
    public Article addArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

    @DeleteMapping("articles/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value="id") Integer id)
    {
        articleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
