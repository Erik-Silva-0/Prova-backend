package com.spotify.som.Repository;

import java.util.List;

import com.spotify.som.Model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String>  {
    Musica findByTitulo(String titulo);
    List<Musica> findByAnoLancamento(Integer ano);
}
