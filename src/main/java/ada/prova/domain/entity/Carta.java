package ada.prova.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Carta {
    @Id
    private String imdb_id;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "score", length = 20, precision = 20, scale = 2)
    private BigDecimal score;

    public Carta() {
    }

    public Carta(String imdb_id, BigDecimal score) {
        this.imdb_id = imdb_id;
        this.score = score;
    }

    public Carta(String imdb_id, String titulo, BigDecimal score) {
        this.imdb_id = imdb_id;
        this.titulo = titulo;
        this.score = score;
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

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "imdb_id='" + imdb_id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", score=" + score +
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