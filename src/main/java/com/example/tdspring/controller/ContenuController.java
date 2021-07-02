package com.example.tdspring.controller;

import java.util.List;
import javax.validation.Valid;

import com.example.tdspring.entities.Contenu;
import com.example.tdspring.repository.ContenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContenuController {

    @Autowired
    ContenuRepository contenuRepository;

    @GetMapping("contenu/{id}")
    private Page<Contenu> getContenuByArticleId(@Valid @RequestBody Integer articleId, Pageable pageable) {
        return contenuRepository.findByArticleId(articleId, pageable);
    }

    @GetMapping("contenu")
    private List<Contenu> getAllContenu() {
        return contenuRepository.findAll();
    }

    @PostMapping("contenu")
    public Contenu addContenu(@Valid @RequestBody Contenu contenu) {
        return contenuRepository.save(contenu);
    }
}
