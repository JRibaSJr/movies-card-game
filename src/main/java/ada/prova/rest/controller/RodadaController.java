package ada.prova.rest.controller;

import ada.prova.domain.entity.Jogador;
import ada.prova.domain.entity.Rodada;
import ada.prova.domain.repository.Rodadas;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rodada")
public class RodadaController {

    private Rodadas rodadas;

    public RodadaController(Rodadas rodadas) {
        this.rodadas = rodadas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rodada save(@RequestBody Rodada rodada){
        return rodadas.save(rodada);
    }

    @GetMapping("{rodada}")
    public Rodada getRodadaById(@PathVariable int rodada) {
        return rodadas
                .findById(rodada)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Rodada não encontrado"));
    }

    @GetMapping()
    public List<Rodada> find(Rodada filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        return rodadas.findAll(example);
    }
}
