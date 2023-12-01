package com.jogos.jogosAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "jogadores")
@Entity

public class Jogadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogador;

    @Column(nullable = false, length = 50)
    private String nomeJogador;

    @Column(nullable = false, length = 50)
    private String nicknameJogador;

    @Column(nullable = false, length = 50)
    private String emailJogador;


    @OneToMany(mappedBy = "jogadores", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("jogadores")
    private Set<Ranking> rankings;



    @Deprecated
    public Jogadores(){}

    public Jogadores(long idJogador, String nomeJogador, String nicknameJogador, String emailJogador, Set<Ranking> rankings) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.nicknameJogador = nicknameJogador;
        this.emailJogador = emailJogador;
        this.rankings = rankings;
    }

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNicknameJogador() {
        return nicknameJogador;
    }

    public void setNicknameJogador(String nicknameJogador) {
        this.nicknameJogador = nicknameJogador;
    }

    public String getEmailJogador() {
        return emailJogador;
    }

    public void setEmailJogador(String emailJogador) {
        this.emailJogador = emailJogador;
    }


    public Set<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(Set<Ranking> rankings) {
        this.rankings = rankings;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "idJogador=" + idJogador +
                ", nomeJogador='" + nomeJogador + '\'' +
                ", nicknameJogador='" + nicknameJogador + '\'' +
                ", emailJogador='" + emailJogador + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
