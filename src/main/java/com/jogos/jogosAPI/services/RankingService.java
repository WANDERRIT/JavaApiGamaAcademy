package com.jogos.jogosAPI.services;

import com.jogos.jogosAPI.entities.Ranking;
import com.jogos.jogosAPI.repositories.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final RankingRepository rankingRepository;

    public Ranking createRanking(final Ranking ranking){
        return rankingRepository.save(ranking);
    }

    public List<Ranking> findAllRanking(){
        List<Ranking> rankingList = new ArrayList<>();
        rankingRepository.findAll().forEach(rankingList::add);
        return rankingList;
    }

    public Optional<Ranking> findRankingById(Long id){
        return rankingRepository.findById(id);
    }

    public Ranking updateRainking(final Ranking rankingToUpdate){
        return rankingRepository.save(rankingToUpdate);
    }

    public void delete(Long id){
        rankingRepository.deleteById(id);
    }

    public List<Ranking> findJogadorById(Long jogadorId){
        List<Ranking> rankingList = new ArrayList<>();
        rankingRepository.findJogadoresIdsByJogadorId(jogadorId);
        return rankingList;
    }

    public List<Ranking> findJogoById(Long jogoId){
        List<Ranking> rankingList = new ArrayList<>();
        rankingRepository.findJogosIdsByJogoId(jogoId);
        return rankingList;
    }
}
