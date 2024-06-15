package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;

public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
}
