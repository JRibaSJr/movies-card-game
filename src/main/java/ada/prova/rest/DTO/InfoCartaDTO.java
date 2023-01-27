package ada.prova.rest.DTO;

import java.math.BigDecimal;

public class InfoCartaDTO {
    private String imdbId;
    private String titulo;

    private BigDecimal score;

    public InfoCartaDTO() {
    }

    public InfoCartaDTO(String imdbId, String titulo, BigDecimal score) {
        this.imdbId = imdbId;
        this.titulo = titulo;
        this.score = score;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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
}
