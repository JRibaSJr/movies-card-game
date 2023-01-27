package ada.prova.exception;

public class PartidaNaoIniciadaException extends RuntimeException {
    public PartidaNaoIniciadaException() {
        super(("Partida não inicializada."));
    }
}
