package ada.prova.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "jogador")
    private Jogador jogador;

    private boolean ativa = true;

    @Column(name = "motivo_encerramento", length = 50)
    private String motivo_encerramento;

    private int erros;

    private BigDecimal pontuacao;

    public Partida() {
    }

    public Partida(Jogador jogador) {
        this.jogador = jogador;
        this.ativa = true;
        this.pontuacao = BigDecimal.valueOf(0.0);
    }

    public int getId() {
        return id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getMotivo_encerramento() {
        return motivo_encerramento;
    }

    public void setMotivo_encerramento(String motivo_encerramento) {
        this.motivo_encerramento = motivo_encerramento;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public BigDecimal getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(BigDecimal pontuacao) {
        this.pontuacao = pontuacao;
    }
}