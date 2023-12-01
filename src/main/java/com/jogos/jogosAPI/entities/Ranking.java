package com.jogos.jogosAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;

@Table(name = "rankings")
@Entity
@Builder

public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRanking;
    @Column(nullable = true)
    private int pontuacao;

    @Column(nullable = true)
    private String dataPontuacao;

    @ManyToOne()
    @JsonIgnoreProperties("rankings")

    @JoinColumn(name = "jogador_id", referencedColumnName = "idJogador", nullable = true)
    private Jogadores jogadores;

    @ManyToOne()
    @JsonIgnoreProperties("rankings")
    @JoinColumn(name = "jogo_id", referencedColumnName = "idJogo", nullable = true)
    private Jogos jogos;


    @Deprecated
    public Ranking(){}

    public Ranking(long idRanking, int pontuacao, String dataPontuacao, Jogadores jogadores, Jogos jogos) {
        this.idRanking = idRanking;
        this.pontuacao = pontuacao;
        this.dataPontuacao = dataPontuacao;
        this.jogadores = jogadores;
        this.jogos = jogos;
    }


    public long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(long idRanking) {
        this.idRanking = idRanking;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getDataPontuacao() {
        return dataPontuacao;
    }

    public void setDataPontuacao(String dataPontuacao) {
        this.dataPontuacao = dataPontuacao;
    }


    public Jogadores getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogadores jogadores) {
        this.jogadores = jogadores;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "idRanking=" + idRanking +
                ", pontuacao=" + pontuacao +
                ", dataPontuacao='" + dataPontuacao + '\'' +
                ", jogadores=" + jogadores +
                ", jogos=" + jogos +
                '}';
    }
}
