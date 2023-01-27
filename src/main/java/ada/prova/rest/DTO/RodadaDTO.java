package ada.prova.rest.DTO;

import ada.prova.domain.entity.Carta;

import java.util.List;

public class RodadaDTO {
    private List<InfoCartaDTO> cartas;
    private String resposta;
    private boolean acertou;

    public RodadaDTO() {
    }

    public RodadaDTO(List<InfoCartaDTO> cartas, String resposta, boolean acertou) {
        this.cartas = cartas;
        this.resposta = resposta;
        this.acertou = acertou;
    }

    public List<InfoCartaDTO> getCartas() {
        return cartas;
    }

    public void setCartas(List<InfoCartaDTO> cartas) {
        this.cartas = cartas;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }
}
