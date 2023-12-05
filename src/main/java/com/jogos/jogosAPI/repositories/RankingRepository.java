package com.jogos.jogosAPI.repositories;

import com.jogos.jogosAPI.entities.Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long> {


    @Query("SELECT r.jogadores.idJogador FROM Ranking r WHERE r.jogadores.idJogador = :id")
    List<Long> findJogadoresIdsByJogadorId(@Param("id") Long id);

    @Query("SELECT r.jogos.idJogo FROM Ranking r WHERE r.jogos.idJogo = :id")
    List<Long> findJogosIdsByJogoId(@Param("id") Long id);

    @Query("SELECT r FROM Ranking r WHERE r.jogos.idJogo = :id ORDER BY r.pontuacao DESC")
    List<Ranking> findRankingsByJogoPontuacao(@Param("id") Long id);



}
