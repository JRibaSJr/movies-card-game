package ada.prova.domain.repository;

import ada.prova.domain.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cartas extends JpaRepository<Carta, String> {
}
