package ada.prova.rest.DTO;

import ada.prova.domain.enuns.MotivoEncerr;

import java.math.BigDecimal;
import java.util.List;

public class InfoPartidaDTO {

    private Integer id;
    private JogadorDTO jogador;
    private int erros;
    private String motivoEncerramento;
    private BigDecimal pontuacao;
    private List<RodadaDTO> rodadas;

    public InfoPartidaDTO() {
    }

    public InfoPartidaDTO(Integer id, JogadorDTO jogador, boolean ativa, int erros, String motivoEncerramento, BigDecimal pontuacao, List<RodadaDTO> rodadas) {
        this.id = id;
        this.jogador = jogador;
        this.erros = erros;
        this.motivoEncerramento = motivoEncerramento;
        this.pontuacao = pontuacao;
        this.rodadas = rodadas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JogadorDTO getJogador() {
        return jogador;
    }

    public void setJogador(JogadorDTO jogador) {
        this.jogador = jogador;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public String getMotivoEncerramento() {
        return motivoEncerramento;
    }

    public void setMotivoEncerramento(String motivoEncerramento) {
        this.motivoEncerramento = motivoEncerramento;
    }

    public BigDecimal getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(BigDecimal pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<RodadaDTO> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<RodadaDTO> rodadas) {
        this.rodadas = rodadas;
    }
}
