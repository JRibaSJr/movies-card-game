package ada.prova.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Jogador {
    @Id
    @Column(name = "jogador", length = 10)
    private String jogador;

    @JsonIgnore
    @Column(name = "senha", length = 10)
    private String senha;

    @Column(name = "record", length = 20, precision = 20, scale = 2)
    private BigDecimal record;

    @OneToMany(mappedBy = "jogador")
    private List<Partida> partidas;

    public Jogador() {
    }

    public Jogador(String jogador) {
        this.jogador = jogador;
    }
    public Jogador(String jogador, String senha) {
        this.jogador = jogador;
        this.senha = senha;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getRecord() {
        return record;
    }

    public void setRecord(BigDecimal record) {
        this.record = record;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "jogador='" + jogador + '\'' +
                ", record=" + record +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador)) return false;
        Jogador jogador1 = (Jogador) o;
        return getJogador().equals(jogador1.getJogador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJogador());
    }
}