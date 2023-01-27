package ada.prova.rest.controller;

import ada.prova.domain.entity.Jogador;
import ada.prova.domain.repository.Jogadores;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private Jogadores jogadores;

    public JogadorController(Jogadores jogadores) {
        this.jogadores = jogadores;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Jogador save(@RequestBody Jogador jogador){
        return jogadores.save(jogador);
    }

    @GetMapping("{jogador}")
    public Jogador getJogadorByUsuario(@PathVariable String jogador) {
        return jogadores
                .findById(jogador)
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND,
                                "Jogador não encontrado"));
    }

    @PutMapping("{jogador}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable String jogador,
                       @RequestBody Jogador jogadorAtualizado){
        jogadores
                .findById(jogador)
                .map(j -> {
                    jogadorAtualizado.setJogador(j.getJogador());
                    jogadores.save(jogadorAtualizado);
                    return j;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Jogador não encontrado") );
    }

    @DeleteMapping("{jogador}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String jogador) {
        jogadores
                .findById(jogador)
                .map(j -> {
                    jogadores.delete(j);
                    return j;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Jogador não encontrado"));
    }

    @GetMapping()
    public List<Jogador> find(Jogador filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        return jogadores.findAll(example);
    }
}