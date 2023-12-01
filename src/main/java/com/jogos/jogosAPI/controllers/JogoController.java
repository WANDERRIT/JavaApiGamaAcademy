package com.jogos.jogosAPI.controllers;


import com.jogos.jogosAPI.entities.Jogos;
import com.jogos.jogosAPI.services.JogoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api"})
public class JogoController {

    private JogoService jogoService;
    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @GetMapping(path = {"/jogos"})
    public ResponseEntity<List<Jogos>> findAllGames(){
        List<Jogos> jogos = jogoService.findAll();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping(path = {"/jogos/{id}"})
    public  ResponseEntity<Jogos> findGamesById(@PathVariable Long id){
        return jogoService.findById(id)
                .map(jogos -> ResponseEntity.ok().body(jogos))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PostMapping(path = {"/jogos"})
    public ResponseEntity<Jogos> createGame(@RequestBody Jogos jogos){
        Jogos newGame = jogoService.createGame(jogos);
        return ResponseEntity.ok(newGame);
    }

    @PutMapping(path = {"/jogos/{id}"})
    public ResponseEntity<Jogos> updateGames(@PathVariable("id") Long id, @RequestBody Jogos gameToUpdate){
        return jogoService.findById(id)
                .map(jogos -> {
                    jogos.setNomeJogo(gameToUpdate.getNomeJogo());
                    jogos.setNomeAutor(gameToUpdate.getNomeAutor());
                    jogos.setWebsiteJogo(gameToUpdate.getWebsiteJogo());
                    jogos.setRankings(gameToUpdate.getRankings());
                    Jogos gameUpdated = jogoService.createGame(jogos);
                    return ResponseEntity.ok().body(gameUpdated);
                }).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @DeleteMapping(path = {"jogos/{id}"})
    public ResponseEntity<?> deleteGame(@PathVariable Long id){
        return jogoService.findById(id)
                .map(jogos -> {
                    jogoService.delete(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
