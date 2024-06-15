package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.TeamParticipation;
import uptc.frw.vueltaCiclismo.jpa.entity.key.TeamParticipationKey;

public interface TeamPartRepository extends JpaRepository <TeamParticipation, TeamParticipationKey>{
}
