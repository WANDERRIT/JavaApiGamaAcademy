package com.jogos.jogosAPI.controllers.dto;

import com.jogos.jogosAPI.entities.Jogadores;
import com.jogos.jogosAPI.entities.Jogos;
import com.jogos.jogosAPI.entities.Ranking;

public record RankingOutput(
        Long id,
        int pontuacao,
        String dataPontuacao,
        Jogos jogos,
        Jogadores jogadores
) {

    public static RankingOutput fromRanking(final Ranking ranking){
        return new RankingOutput(
                ranking.getIdRanking(),
                ranking.getPontuacao(),
                ranking.getDataPontuacao(),
                ranking.getJogos(),
                ranking.getJogadores()
        );
    }
}
