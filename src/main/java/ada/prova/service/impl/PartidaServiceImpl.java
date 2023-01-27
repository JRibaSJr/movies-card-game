package ada.prova.service.impl;

import ada.prova.domain.entity.Carta;
import ada.prova.domain.entity.Jogador;
import ada.prova.domain.entity.Partida;
import ada.prova.domain.entity.Rodada;
import ada.prova.domain.enuns.MotivoEncerr;
import ada.prova.domain.repository.Cartas;
import ada.prova.domain.repository.Jogadores;
import ada.prova.domain.repository.Partidas;
import ada.prova.domain.repository.Rodadas;
import ada.prova.service.PartidaService;
import ada.prova.exception.JogoException;
import ada.prova.exception.PartidaNaoIniciadaException;
import ada.prova.rest.DTO.CartaDTO;
import ada.prova.rest.DTO.PartidaDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidaServiceImpl implements PartidaService {

    private final Partidas partidasRepository;
    private final Jogadores jogadoresRepository;
    private final Rodadas rodadasRepository;
    private final Cartas cartasRepository;

    public PartidaServiceImpl(Partidas partidas,
                              Jogadores jogadores,
                              Rodadas rodadas,
                              Cartas cartas) {
        this.partidasRepository = partidas;
        this.jogadoresRepository = jogadores;
        this.rodadasRepository = rodadas;
        this.cartasRepository = cartas;
    }

    @Override
    @Transactional
    public Partida salvar(PartidaDTO partidaDTO) {
        Jogador jogador = jogadoresRepository
                .findById(partidaDTO.getJogador())
                .orElseThrow(() -> new JogoException("Jogador "+ partidaDTO.getJogador() +" não encontrado."));

        Partida partida = new Partida(jogador);

        Rodada rodada = new Rodada(converterCartas(partidaDTO.getCartas()), partida);

        Carta carta = cartasRepository
                .findById(partidaDTO.getResposta())
                .orElseThrow(() -> new JogoException("Carta resposta não encontrada: " + partidaDTO.getResposta()));

        rodada.setResposta(carta);

        partidasRepository.save(partida);
        rodadasRepository.save(rodada);

        return partida;
    }

    private List<Carta> converterCartas(List<CartaDTO> cartasDTO){
        if(cartasDTO.isEmpty()){
            throw new JogoException("Para iniciar uma rodada são necessárias duas cartas.");
        }
        return cartasDTO
                .stream()
                .map(dto -> {
                    Carta carta = cartasRepository
                            .findById(dto.getImdbId())
                            .orElseThrow(() -> new JogoException("Carta não encontrada: " + dto.getImdbId()));
                    return carta;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Partida> obterInfoPartida(Integer id) {
        return partidasRepository.findByIdFetchRodadas(id);
    }

    @Override
    @Transactional
    public void atualizaMotivoEncerr(Integer id, MotivoEncerr motivoEncerr) {
        partidasRepository
                .findById(id)
                .map(partida -> {
                    partida.setMotivoEncerramento(motivoEncerr);
                    return partidasRepository.save(partida);
                }).orElseThrow(() -> new PartidaNaoIniciadaException());
    }
}
