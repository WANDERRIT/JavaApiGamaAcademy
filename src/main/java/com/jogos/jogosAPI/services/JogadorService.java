package com.jogos.jogosAPI.services;


import com.jogos.jogosAPI.entities.Jogadores;
import com.jogos.jogosAPI.repositories.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;


    public Jogadores createPlayer(final Jogadores jogadores){
        return jogadorRepository.save(jogadores);
    }

    public List<Jogadores> findAll(){
        List<Jogadores> jogadores = new ArrayList<>();
        jogadorRepository.findAll().forEach(jogadores::add);
        return jogadores;
    }

    public Optional<Jogadores> findById(Long id){
        return jogadorRepository.findById(id);
    }

    public Jogadores update(final Jogadores jogadoresToUpdate){
        return jogadorRepository.save(jogadoresToUpdate);
    }

    public void delete(Long id){
        jogadorRepository.deleteById(id);
    }

}
