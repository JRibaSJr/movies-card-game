package ada.prova.rest.DTO;

public class CartaDTO {
    private String imdbId;

    public CartaDTO() {
    }

    public CartaDTO(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
