package com.spotify.som.Service;

import java.util.List;

import com.spotify.som.shared.MusicaDto;

public interface MusicaService {
    
    List<MusicaDto> obterTodasMusicas();
    MusicaDto obterPorId(String id);
    MusicaDto obterPorTitulo(String titulo);
    List<MusicaDto> obterPorAnoLancamento(Integer ano);

    MusicaDto cadastrarNovaMusica(MusicaDto novaMusica);

    MusicaDto alterarMusica(String id, MusicaDto musciaAlterar);
    
    void deletarPorId(String id);

}
