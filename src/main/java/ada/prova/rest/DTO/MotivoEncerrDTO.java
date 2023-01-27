package ada.prova.rest.DTO;

public class MotivoEncerrDTO {
    private String novoMotivoEncerr;

    public MotivoEncerrDTO() {
    }

    public MotivoEncerrDTO(String novoMotivoEncerr) {
        this.novoMotivoEncerr = novoMotivoEncerr;
    }

    public String getNovoMotivoEncerr() {
        return novoMotivoEncerr;
    }

    public void setNovoMotivoEncerr(String novoMotivoEncerr) {
        this.novoMotivoEncerr = novoMotivoEncerr;
    }
}
