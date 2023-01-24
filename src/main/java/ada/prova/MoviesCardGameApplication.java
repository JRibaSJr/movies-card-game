package ada.prova;

import ada.prova.domain.entity.Carta;
import ada.prova.domain.entity.Jogador;
import ada.prova.domain.entity.Partida;
import ada.prova.domain.entity.Rodada;
import ada.prova.domain.repository.Cartas;
import ada.prova.domain.repository.Jogadores;
import ada.prova.domain.repository.Partidas;
import ada.prova.domain.repository.Rodadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MoviesCardGameApplication {

    @Bean
    public CommandLineRunner init(@Autowired Jogadores jogadores,
                                  @Autowired Cartas cartas,
                                  @Autowired Rodadas rodadas,
                                  @Autowired Partidas partidas) {
        return args -> {
            System.out.println("Salvando jogadores");
            jogadores.save(new Jogador("Player1"));
            jogadores.save(new Jogador("Player2"));

            List<Jogador> todosJogadores = jogadores.findAll();
            todosJogadores.forEach(System.out::println);

            System.out.println("Salvando cartas");
            cartas.save(new Carta("tt3896198", "Guardians of the Galaxy Vol. 1", BigDecimal.valueOf(52215.34)));
            cartas.save(new Carta("tt3896298", "Guardians of the Galaxy Vol. 2", BigDecimal.valueOf(2215.34)));

            List<Carta> todasCartas = cartas.findAll();
            todasCartas.forEach(System.out::println);

            System.out.println("Iniciando uma partida");
            Partida partida = partidas.save(new Partida(jogadores.getById("Player1")));

            System.out.println("Iniciando uma rodada");
            Rodada rodada = rodadas.save(new Rodada(todasCartas, partida));
        };
    }
    public static void main(String[] args){
        SpringApplication.run(MoviesCardGameApplication.class, args);
    }

}