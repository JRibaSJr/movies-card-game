package ada.prova.domain.entity;

import ada.prova.domain.enuns.MotivoEncerr;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "jogador")
    private Jogador jogador;

    @Enumerated(EnumType.STRING)
    private MotivoEncerr motivoEncerramento;

    private int erros;

    @Column(name = "pontuacao", length = 20, precision = 20, scale = 2)
    private BigDecimal pontuacao;

    @OneToMany(mappedBy = "partida")
    private List<Rodada> rodadas;

    public Partida() {
    }

    public Partida(Jogador jogador) {
        this.jogador = jogador;
        this.erros = 0;
        this.motivoEncerramento = motivoEncerramento.ATIVA;
        this.pontuacao = BigDecimal.valueOf(0.0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public MotivoEncerr getMotivoEncerramento() {
        return motivoEncerramento;
    }

    public void setMotivoEncerramento(MotivoEncerr motivoEncerramento) {
        this.motivoEncerramento = motivoEncerramento;
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

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<Rodada> rodadas) {
        this.rodadas = rodadas;
    }
}