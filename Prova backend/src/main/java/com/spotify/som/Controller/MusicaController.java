package com.spotify.som.Controller;

import java.util.List;

import com.spotify.som.Service.MusicaService;
import com.spotify.som.shared.MusicaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> obterTodas(){
        return service.obterTodasMusicas();
    }
    @GetMapping("/{id}")
    public MusicaDto obterPorId(@PathVariable String id){
        return service.obterPorId(id);
    }
    @GetMapping("/titulo/{titulo}")
    public MusicaDto obterPorTitulo(@PathVariable String titulo){
        return service.obterPorTitulo(titulo);
    }
    @GetMapping("/ano/{ano}")
    public List<MusicaDto> obterPorAnoLancamento(@PathVariable Integer ano){
        return service.obterPorAnoLancamento(ano);
    }
    @PostMapping
    public MusicaDto incluirMusica(@RequestBody MusicaDto musica){
        return service.cadastrarNovaMusica(musica);
        
    }
    
    @DeleteMapping("/{id}")
    public void deltarPorId(@PathVariable String id){
        service.deletarPorId(id);
    }
    @PutMapping("/{id}")
    public MusicaDto alterarMusica(@PathVariable String id, @RequestBody MusicaDto musica){
        return service.alterarMusica(id, musica);
    }

}
