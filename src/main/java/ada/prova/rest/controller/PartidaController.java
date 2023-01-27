package ada.prova.rest.controller;

import ada.prova.domain.entity.Carta;
import ada.prova.domain.entity.Jogador;
import ada.prova.domain.entity.Partida;
import ada.prova.domain.entity.Rodada;
import ada.prova.domain.enuns.MotivoEncerr;
import ada.prova.service.PartidaService;
import ada.prova.rest.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PartidaDTO partidaDTO){
        Partida partida = partidaService.salvar(partidaDTO);
        return partida.getId();
    }

    @GetMapping("{id}")
    public InfoPartidaDTO getById(@PathVariable Integer id){
        return partidaService
                .obterInfoPartida(id)
                .map(p -> converterPartida(p))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Partida não encontrada"));
    }

    private InfoPartidaDTO converterPartida(Partida partida){
        InfoPartidaDTO dto = new InfoPartidaDTO();
        dto.setId(partida.getId());
        dto.setJogador(converterJogador(partida.getJogador()));
        dto.setErros(partida.getErros());
        dto.setMotivoEncerramento(partida.getMotivoEncerramento().name());
        dto.setPontuacao(partida.getPontuacao());
        dto.setRodadas(converterRodadas(partida.getRodadas()));
        return dto;
    }

    private JogadorDTO converterJogador(Jogador jogador){
        JogadorDTO dto = new JogadorDTO();
        dto.setJogador(jogador.getJogador());
        dto.setRecord(jogador.getRecord());

        return dto;
    }

    private List<RodadaDTO> converterRodadas(List<Rodada> rodadas){
        if(CollectionUtils.isEmpty(rodadas)){
            return Collections.emptyList();
        }
        return rodadas
                .stream()
                .map(rodada -> {
                    RodadaDTO dto = new RodadaDTO();
                    dto.setCartas(converterCartas(rodada.getCartas()));
                    dto.setResposta(rodada.getResposta().getImdb_id());
                    dto.setAcertou(rodada.isAcertou());
                    return dto;
                }).collect(Collectors.toList());
    }

    private List<InfoCartaDTO> converterCartas(List<Carta> cartas){
        if(CollectionUtils.isEmpty(cartas)){
            return Collections.emptyList();
        }
        return cartas
                .stream()
                .map(carta -> {
                    InfoCartaDTO dto = new InfoCartaDTO();
                    dto.setImdbId(carta.getImdb_id());
                    dto.setTitulo(carta.getTitulo());
                    dto.setScore(carta.getScore());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotivoEncerr(@PathVariable Integer id,
                                   @RequestBody MotivoEncerrDTO novoMotivoEncerr){
        String motivo = novoMotivoEncerr.getNovoMotivoEncerr();
        partidaService.atualizaMotivoEncerr(id, MotivoEncerr.valueOf(motivo));
    }
}