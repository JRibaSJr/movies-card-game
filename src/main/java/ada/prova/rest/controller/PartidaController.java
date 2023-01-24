package ada.prova.rest.controller;

import ada.prova.domain.entity.Partida;
import ada.prova.domain.repository.Partidas;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    private Partidas partidas;

    public PartidaController(Partidas partidas) {
        this.partidas = partidas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Partida save(@RequestBody Partida partida){
        return partidas.save(partida);
    }
}
