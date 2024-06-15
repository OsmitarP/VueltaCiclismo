package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.StagePodium;
import uptc.frw.vueltaCiclismo.jpa.entity.key.StagePodiumKey;

public interface StagePodiumRepository extends JpaRepository<StagePodium, StagePodiumKey> {
}
