package ada.prova.domain.repository;

import ada.prova.domain.entity.Jogador;
import ada.prova.domain.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Partidas extends JpaRepository<Partida, Integer> {
    List<Partida> findByJogador(Jogador jogador);
    @Query(value = " Select p from Partida p left join fetch p.rodadas where p.id = :id ")
    Optional<Partida> findByIdFetchRodadas(@Param("id") Integer id);
}
