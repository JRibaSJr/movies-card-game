package ada.prova.service;

import ada.prova.domain.entity.Partida;
import ada.prova.domain.enuns.MotivoEncerr;
import ada.prova.rest.DTO.PartidaDTO;

import java.util.Optional;

public interface PartidaService {
    Partida salvar(PartidaDTO partidaDTO);

    Optional<Partida> obterInfoPartida(Integer id);

    void atualizaMotivoEncerr(Integer id, MotivoEncerr motivoEncerr);
}
