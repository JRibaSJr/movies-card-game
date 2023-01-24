package ada.prova.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "imdb_id")
    private Carta resposta;

    private boolean acertou;

    @ManyToMany
    @JoinColumn(name = "imdb_id")
    private List<Carta> cartas;

    @ManyToOne
    @JoinColumn(name = "Partida_id")
    private Partida partida;

    public Rodada() {
    }

    public Rodada(List<Carta> cartas, Partida partida) {
        this.cartas = cartas;
        this.partida = partida;
    }

    public Integer getId() {
        return id;
    }

    public Carta getResposta() {
        return resposta;
    }

    public void setResposta(Carta resposta) {
        this.resposta = resposta;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rodada)) return false;
        Rodada rodada = (Rodada) o;
        return getCartas().equals(rodada.getCartas()) && getPartida().equals(rodada.getPartida());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartas(), getPartida());
    }
}
