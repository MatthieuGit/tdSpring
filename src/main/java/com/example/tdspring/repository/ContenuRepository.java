package com.example.tdspring.repository;

import com.example.tdspring.entities.Contenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuRepository extends JpaRepository<Contenu, Integer> {
    Page<Contenu> findByArticleId(Integer id, Pageable pageable);
}
