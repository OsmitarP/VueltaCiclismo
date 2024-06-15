package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.CyclistParticipation;
import uptc.frw.vueltaCiclismo.jpa.entity.key.CyclistParticipationKey;

public interface CyclistPartRepository extends JpaRepository<CyclistParticipation, CyclistParticipationKey> {
}
