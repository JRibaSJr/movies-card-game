package ada.prova.domain.repository;

import ada.prova.domain.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Partidas extends JpaRepository<Partida, Integer> {
}
