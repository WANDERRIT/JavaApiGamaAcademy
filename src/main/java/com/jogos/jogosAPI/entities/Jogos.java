package com.jogos.jogosAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "jogos")
@Entity
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogo;

    @Column(nullable = false, length = 100)
    private String nomeJogo;

    @Column(nullable = false, length = 50)
    private String nomeAutor;


    @Column(nullable = false, length = 50)
    private String websiteJogo;



    @OneToMany(mappedBy = "jogos", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("jogos")
    private Set<Ranking> rankings;


    @Deprecated
    public Jogos(){}

    public Jogos(long idJogo, String nomeJogo, String nomeAutor, String websiteJogo, Set<Ranking> rankings) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.nomeAutor = nomeAutor;
        this.websiteJogo = websiteJogo;
        this.rankings = rankings;
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getWebsiteJogo() {
        return websiteJogo;
    }

    public void setWebsiteJogo(String websiteJogo) {
        this.websiteJogo = websiteJogo;
    }


    public Set<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(Set<Ranking> rankings) {
        this.rankings = rankings;
    }

    @Override
    public String toString() {
        return "Jogos{" +
                "idJogo=" + idJogo +
                ", nomeJogo='" + nomeJogo + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", websiteJogo='" + websiteJogo + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
