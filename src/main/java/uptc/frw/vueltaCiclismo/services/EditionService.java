package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.EditionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private AuditTransactionRepository auditTransactionRepository;

    //create edition
    public Edition createEditions(Edition edition) {

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Edition");
        Map<String, Object> data = new HashMap<>();
        data.put("id",edition.getId());
        data.put("year",edition.getYear());
        data.put("beginDate",edition.getBeginDate());
        data.put("endDate",edition.getEndDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        return editionRepository.save(edition);
    }

    //show All editions
    public List<Edition> getAlleditions() {
        return editionRepository.findAll();
    }

    //show edition by Id
    public Edition getEditionById(long id) {
        Edition edition= editionRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Get");
        auditTransaction.setTable("Edition");
        Map<String, Object> data = new HashMap<>();
        data.put("id",edition.getId());
        data.put("year",edition.getYear());
        data.put("beginDate",edition.getBeginDate());
        data.put("endDate",edition.getEndDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return editionRepository.findById(id).orElse(null);
    }

    //delete
    public void deleteEditionById(long id)
    {
        Edition edition = editionRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Delete");
        auditTransaction.setTable("Edition");
        Map<String, Object> data = new HashMap<>();
        data.put("id",edition.getId());
        data.put("year",edition.getYear());
        data.put("beginDate",edition.getBeginDate());
        data.put("endDate",edition.getEndDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        editionRepository.deleteById(id);
    }

    //update
    public  Edition updateEdition(Edition newedition) {
        Edition edition = editionRepository.findById(newedition.getId()).orElse(null);

        edition.setYear(newedition.getYear());
        edition.setBeginDate(newedition.getBeginDate());
        edition.setEndDate(newedition.getEndDate());


        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Edition");
        Map<String, Object> data = new HashMap<>();
        data.put("id",edition.getId());
        data.put("year",edition.getYear());
        data.put("beginDate",edition.getBeginDate());
        data.put("endDate",edition.getEndDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return editionRepository.save(edition);
    }
}
