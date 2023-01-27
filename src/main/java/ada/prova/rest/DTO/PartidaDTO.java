package ada.prova.rest.DTO;

import ada.prova.validation.NotEmptyList;

import java.util.List;

public class PartidaDTO {
    private String jogador;

    @NotEmptyList(message = "Uma partida precisa de duas cartas.")
    private List<CartaDTO> cartas;

    private String resposta;

    public PartidaDTO() {
    }

    public PartidaDTO(String jogador, List<CartaDTO> cartas, String resposta) {
        this.jogador = jogador;
        this.cartas = cartas;
        this.resposta = resposta;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public List<CartaDTO> getCartas() {
        return cartas;
    }

    public void setCartas(List<CartaDTO> cartas) {
        this.cartas = cartas;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
