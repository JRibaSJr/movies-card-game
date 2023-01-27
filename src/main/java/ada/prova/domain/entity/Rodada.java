package ada.prova.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "partida")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "resposta")
    private Carta resposta;

    private boolean acertou;

    @ManyToMany
    @JoinColumn(name = "imdb_id")
    private List<Carta> cartas;

    public Rodada() {
    }

    public Rodada(Partida partida) {
        this.partida = partida;
    }

    public Rodada(List<Carta> cartas, Partida partida) {
        this.partida = partida;
        this.cartas = cartas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rodada)) return false;
        Rodada rodada = (Rodada) o;
        return getCartas().equals(rodada.getCartas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartas());
    }
}
