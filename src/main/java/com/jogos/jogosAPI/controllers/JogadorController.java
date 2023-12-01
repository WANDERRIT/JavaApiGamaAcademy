package com.jogos.jogosAPI.controllers;


import com.jogos.jogosAPI.entities.Jogadores;
import com.jogos.jogosAPI.services.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api"})
public class JogadorController {
private JogadorService jogadorService;
public JogadorController(JogadorService jogadorService){
    this.jogadorService = jogadorService;
}

@GetMapping(path = {"/jogadores"})
    public ResponseEntity<List<Jogadores>> findAllPlayers(){
    List<Jogadores> jogadores = jogadorService.findAll();
    return ResponseEntity.ok(jogadores);
}

@GetMapping(path = {"jogadores/{id}"})
    public ResponseEntity<Jogadores> findPlayerById(@PathVariable Long id){
    return jogadorService.findById(id)
            .map(jogador -> ResponseEntity.ok().body(jogador))
            .orElse(ResponseEntity.status(404).build());
}

@PostMapping(path = {"/jogadores"})
    public ResponseEntity<Jogadores> createPlayer(@RequestBody Jogadores jogadores){
    Jogadores newPlayer = jogadorService.createPlayer(jogadores);
    return ResponseEntity.ok(newPlayer);
}

@PutMapping(path = {"jogadores/{id}"})
    public ResponseEntity<Jogadores> updatePlayer(@RequestBody Jogadores playerToUpdate, @PathVariable("id") Long id){
        return jogadorService.findById(id)
                .map(jogador -> {
                    jogador.setNomeJogador(playerToUpdate.getNomeJogador());
                    jogador.setNicknameJogador(playerToUpdate.getNicknameJogador());
                    jogador.setEmailJogador(playerToUpdate.getEmailJogador());
                    jogador.setRankings(playerToUpdate.getRankings());
                    Jogadores playerUpdated = jogadorService.update(jogador);
                    return ResponseEntity.ok().body(playerUpdated);
                }).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
}

@DeleteMapping(path = {"jogadores/{id}"})
    public ResponseEntity<?> deletePlayer(@PathVariable Long id){
    return jogadorService.findById(id)
            .map(jogador -> {
                jogadorService.delete(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
}


}
