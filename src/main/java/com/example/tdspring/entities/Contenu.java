package com.example.tdspring.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Contenu {

    @Id
    private int id;

    @Size(max = 250)
    private String titre;

    @Size(max = 250)
    private String texte;

    @Size(max = 250)
    private String auteur;

    private String url;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idfile",nullable = false)
    private Article article;

    public Contenu() {
    }

    public Contenu(String titre, String texte, String auteur, String url, Article article) {
        this.titre = titre;
        this.texte = texte;
        this.auteur = auteur;
        this.url = url;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
