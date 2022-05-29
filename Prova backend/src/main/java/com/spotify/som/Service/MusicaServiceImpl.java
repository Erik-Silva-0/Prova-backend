package com.spotify.som.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.spotify.som.Model.Musica;
import com.spotify.som.Repository.MusicaRepository;
import com.spotify.som.shared.MusicaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MusicaServiceImpl implements MusicaService {


    @Autowired
    private MusicaRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MusicaDto> obterTodasMusicas() {
        List<Musica> musica = repository.findAll();

        return musica.stream()
        .map(m ->  mapper.map(m, MusicaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDto obterPorId(String id) {

        Optional<Musica> musica = repository.findById(id);
        
        if (musica.isPresent()) {
            return mapper.map(musica.get(), MusicaDto.class);
        }

        return null;
    }

    @Override
    public MusicaDto obterPorTitulo(@PathVariable String titulo) {
        Musica musica = repository.findByTitulo(titulo);
        return mapper.map(musica, MusicaDto.class);
    }

    @Override
    public List<MusicaDto> obterPorAnoLancamento(Integer ano) {
        List<Musica> musicas = repository.findByAnoLancamento(ano);
        if (!musicas.isEmpty()) {
            return musicas.stream()
            .map(m -> mapper.map(m, MusicaDto.class))
            .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public MusicaDto cadastrarNovaMusica(MusicaDto musica) {
        Musica musicaSalvar = mapper.map(musica, Musica.class);
 

        repository.save(musicaSalvar);

        return mapper.map(musicaSalvar, MusicaDto.class);
    }

    @Override
    public MusicaDto alterarMusica(String id, MusicaDto musica) {

        Optional<Musica> musicabusca = repository.findById(id);

        if (musicabusca.isPresent()) {
            Musica musicaAlterar = mapper.map(musica, Musica.class);
            musicaAlterar.setId(id);
            musicaAlterar = repository.save(musicaAlterar);
            return mapper.map(musicaAlterar, MusicaDto.class);
        }
        return null;
    }

    @Override
    public void deletarPorId(String id) {
        repository.deleteById(id);        
    }
}
