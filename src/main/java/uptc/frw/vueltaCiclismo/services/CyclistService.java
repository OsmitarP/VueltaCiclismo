package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.CyclistRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private AuditTransactionRepository auditTransactionRepository;

    //create Cyclist
    public Cyclist createCyclist(Cyclist cyclist) {

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Cyclist");
        Map<String, Object> data = new HashMap<>();
        data.put("id",cyclist.getId());
        data.put("cyclist",cyclist.getName());
        data.put("countryBirth",cyclist.getCountryBirth());
        data.put("birthdate",cyclist.getBirthDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);


        return cyclistRepository.save(cyclist);
    }

    //show All Cyclist
    public List<Cyclist> getAllCyclist() {
        return cyclistRepository.findAll();
    }

    //show edition by Id
    public Cyclist getCyclistById(long id) {

        Cyclist cyclist = cyclistRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Get");
        auditTransaction.setTable("Cyclist");
        Map<String, Object> data = new HashMap<>();
        data.put("id",cyclist.getId());
        data.put("cyclist",cyclist.getName());
        data.put("countryBirth",cyclist.getCountryBirth());
        data.put("birthdate",cyclist.getBirthDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return cyclistRepository.findById(id).orElse(null);
    }

    //Delete
    public void deleteCyclist(long id) {

        Cyclist cyclist = cyclistRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Delete");
        auditTransaction.setTable("Cyclist");
        Map<String, Object> data = new HashMap<>();
        data.put("id",cyclist.getId());
        data.put("cyclist",cyclist.getName());
        data.put("countryBirth",cyclist.getCountryBirth());
        data.put("birthdate",cyclist.getBirthDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        cyclistRepository.deleteById(id);
    }

    //update
    public Cyclist updateCyclist(Cyclist newcyclist) {
    Cyclist cyclist = cyclistRepository.findById(newcyclist.getId()).orElse(null);

    cyclist.setName(newcyclist.getName());
    cyclist.setLastName(newcyclist.getLastName());
    cyclist.setBirthDate(newcyclist.getBirthDate());
    cyclist.setCountryBirth(newcyclist.getCountryBirth());

    AuditTransaction auditTransaction = new AuditTransaction();
    auditTransaction.setAction("update");
    auditTransaction.setTable("Cyclist");
    Map<String, Object> data = new HashMap<>();
    data.put("id",cyclist.getId());
    data.put("cyclist",cyclist.getName());
    data.put("countryBirth",cyclist.getCountryBirth());
    data.put("birthdate",cyclist.getBirthDate());

    auditTransaction.setData(data);
    auditTransactionRepository.save(auditTransaction);

    return cyclistRepository.save(cyclist);
    }
}
