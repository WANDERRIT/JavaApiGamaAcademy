package com.jogos.jogosAPI.controllers.dto;

import com.jogos.jogosAPI.entities.Jogadores;
import com.jogos.jogosAPI.entities.Jogos;
import com.jogos.jogosAPI.entities.Ranking;

public record RankingOutPutJogos(
        Long id,
        int pontuacao,
        String dataPontuacao,
        Jogos jogos

) {
    public static RankingOutPutJogos fromRanking(final Ranking ranking){
        return new RankingOutPutJogos(
                ranking.getIdRanking(),
                ranking.getPontuacao(),
                ranking.getDataPontuacao(),
                ranking.getJogos()
        );
    }
}
