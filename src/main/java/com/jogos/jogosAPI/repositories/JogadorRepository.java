package com.jogos.jogosAPI.repositories;

import com.jogos.jogosAPI.entities.Jogadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogadores, Long> {
}
