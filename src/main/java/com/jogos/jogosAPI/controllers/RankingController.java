package com.jogos.jogosAPI.controllers;


import com.jogos.jogosAPI.controllers.dto.RankingOutPutJogos;
import com.jogos.jogosAPI.controllers.dto.RankingOutput;
import com.jogos.jogosAPI.entities.Ranking;
import com.jogos.jogosAPI.services.JogadorService;
import com.jogos.jogosAPI.services.JogoService;
import com.jogos.jogosAPI.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/api"})
@RequiredArgsConstructor
public class RankingController {
    public final RankingService rankingService;

    public final JogadorService jogadorService;

    public final JogoService jogoService;

    @GetMapping(path = {"/ranking/jogador/{id}"})
    public ResponseEntity<List<RankingOutput>> allRakings(){
        List<Ranking> rankingList = rankingService.findAllRanking();
        List<RankingOutput> rankingOutputs = rankingList
                .stream()
                .map(RankingOutput::fromRanking)
                .collect(Collectors.toList());
        return new ResponseEntity<>(rankingOutputs, HttpStatus.OK);
    }

    @GetMapping(path = {"/ranking/jogo/{id}"})
    public ResponseEntity<List<RankingOutPutJogos>> alljogoRanking(){
        List<Ranking> rankingList = rankingService.findAllRanking();
        List<RankingOutPutJogos> rankingOutPutJogos = rankingList
                .stream()
                .map(RankingOutPutJogos::fromRanking)
                .collect(Collectors.toList());
        return new ResponseEntity<>(rankingOutPutJogos, HttpStatus.OK);
    }


    @PostMapping(path = {"/rankings"})
    public ResponseEntity<Ranking> createRanking(@RequestBody Ranking ranking){
        Ranking novoRanking = rankingService.createRanking(ranking);
        return ResponseEntity.ok(novoRanking);
    }


    @DeleteMapping(path = {"rankings/{id}"})
    public ResponseEntity<?> deleteRanking(@PathVariable Long id){
        return rankingService.findRankingById(id)
                .map(rankings ->{
                    rankingService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
