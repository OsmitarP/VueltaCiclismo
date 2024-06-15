package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
