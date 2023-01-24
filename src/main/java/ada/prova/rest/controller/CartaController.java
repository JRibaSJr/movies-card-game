package ada.prova.rest.controller;

import ada.prova.domain.entity.Carta;
import ada.prova.domain.repository.Cartas;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    private Cartas cartas;

    public CartaController(Cartas cartas){
        this.cartas = cartas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carta save(@RequestBody Carta carta){
        return cartas.save(carta);
    }

    @GetMapping("{carta}")
    public Carta getCartaByImdb_id(@PathVariable String carta){
        return cartas
                .findById(carta)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Carta não encontrada"));
    }

    @PutMapping("{carta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String carta,
                       @RequestBody Carta cartaAtualizada){
        cartas.findById(carta)
                .map(c -> {
                    cartaAtualizada.setImdb_id(c.getImdb_id());
                    cartas.save(cartaAtualizada);
                    return c;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carta não encontrada"));
    }

    @DeleteMapping("{carta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String carta){
        cartas.findById(carta)
                .map(c ->{
                    cartas.delete(c);
                    return c;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carta não encontrada"));
    }

    @GetMapping
    public List<Carta> find(Carta filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        return cartas.findAll(example);
    }
}