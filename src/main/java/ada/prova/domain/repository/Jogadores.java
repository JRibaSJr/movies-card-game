package ada.prova.domain.repository;

import ada.prova.domain.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Jogadores extends JpaRepository<Jogador, String> {
}
