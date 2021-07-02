package com.example.tdspring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Article {

    @Id
    private int id;

    @Size(max=256)
    private String titre;

    @Size(max=256)
    private String url;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "article")
    private Contenu contenu;

    public Article() {
    }


    public Article(int id, String titre, String url) {
        this.id = id;
        this.titre = titre;
        this.url = url;
    }

    public Article(String titre, String url, Contenu contenu) {
        this.titre = titre;
        this.url = url;
        this.contenu = contenu;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }
}
