package ada.prova.rest.controller;

import ada.prova.exception.JogoException;
import ada.prova.exception.PartidaNaoIniciadaException;
import ada.prova.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(JogoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleJogoException(JogoException ex){
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(PartidaNaoIniciadaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePartidaNotFoundException(PartidaNaoIniciadaException ex){
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(errors);
    }
}
