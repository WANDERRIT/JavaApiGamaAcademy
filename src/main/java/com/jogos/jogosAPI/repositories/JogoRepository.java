package com.jogos.jogosAPI.repositories;

import com.jogos.jogosAPI.entities.Jogos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends CrudRepository<Jogos, Long> {
}
