package uptc.frw.vueltaCiclismo.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;

public interface AuditTransactionRepository extends MongoRepository <AuditTransaction,String>{

}
