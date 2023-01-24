package ada.prova.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Carta {
    @Id
    private String imdb_id;

    @Column(name = "titulo", length = 50)
    private String titulo;

    private BigDecimal pontuacao;

    public Carta() {
    }

    public Carta(String imdb_id, BigDecimal pontuacao) {
        this.imdb_id = imdb_id;
        this.pontuacao = pontuacao;
    }

    public Carta(String imdb_id, String titulo, BigDecimal pontuacao) {
        this.imdb_id = imdb_id;
        this.titulo = titulo;
        this.pontuacao = pontuacao;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(BigDecimal pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "imdb_id='" + imdb_id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", pontuacao=" + pontuacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carta)) return false;
        Carta carta = (Carta) o;
        return getImdb_id().equals(carta.getImdb_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImdb_id());
    }
}