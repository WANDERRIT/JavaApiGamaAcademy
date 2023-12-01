package com.jogos.jogosAPI.controllers.dto;

public record RankingInput(Long jogadorId, Long jogoId, int pontuacao, String dataPontuacao) {
}
