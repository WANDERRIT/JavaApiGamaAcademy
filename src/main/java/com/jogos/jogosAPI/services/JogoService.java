package com.jogos.jogosAPI.services;


import com.jogos.jogosAPI.entities.Jogos;
import com.jogos.jogosAPI.repositories.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository jogoRepository;

    public Jogos createGame(final Jogos jogo){
        return jogoRepository.save(jogo);
    }

    public List<Jogos> findAll(){
        List<Jogos> jogos = new ArrayList<>();
        jogoRepository.findAll().forEach(jogos::add);
        return jogos;
    }

    public Optional<Jogos> findById(Long id){
        return jogoRepository.findById(id);
    }

    public Jogos update(final Jogos jogosToUpdate){
        return jogoRepository.save(jogosToUpdate);
    }

    public void delete(Long id){
        jogoRepository.deleteById(id);
    }
}
