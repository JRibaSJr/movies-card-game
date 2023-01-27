package ada.prova.rest.DTO;

import java.math.BigDecimal;

public class JogadorDTO {
    private String jogador;
    private BigDecimal record;

    public JogadorDTO() {
    }

    public JogadorDTO(String jogador, BigDecimal record) {
        this.jogador = jogador;
        this.record = record;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public BigDecimal getRecord() {
        return record;
    }

    public void setRecord(BigDecimal record) {
        this.record = record;
    }
}
