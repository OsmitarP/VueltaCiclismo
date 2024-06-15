package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.jpa.entity.Stage;
import uptc.frw.vueltaCiclismo.jpa.entity.StagePodium;
import uptc.frw.vueltaCiclismo.jpa.entity.key.StagePodiumKey;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.StagePodiumRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StagePodiumService {
@Autowired
private StagePodiumRepository stagePodiumRepository;

@Autowired
private CyclistService cyclistService;

@Autowired
private StageService stageService;

@Autowired
private AuditTransactionRepository auditTransactionRepository;

//get All StagePodiums
public List<StagePodium> getAllStagePodium() {
    return stagePodiumRepository.findAll();
}

//get StagePodium by ids
public StagePodium getStagePodiumById(StagePodiumKey id) {
    AuditTransaction auditTransaction = new AuditTransaction();
    auditTransaction.setAction("get");
    auditTransaction.setTable("StagePodium");
    Map<String, Object> data = new HashMap<>();
    data.put("StagePodium", id);
    auditTransaction.setData(data);
    auditTransactionRepository.save(auditTransaction);

    return stagePodiumRepository.findById(id).orElse(null);
}

//delete StagePodium

public void deleteStagePodiumById(StagePodiumKey id) {
    AuditTransaction auditTransaction = new AuditTransaction();
    auditTransaction.setAction("delete");
    auditTransaction.setTable("StagePodium");
    Map<String, Object> data = new HashMap<>();
    data.put("StagePodium", id);
    auditTransaction.setData(data);
    auditTransactionRepository.save(auditTransaction);

    stagePodiumRepository.deleteById(id);
}




//create StagePodiums
public StagePodium createStagePodiums(StagePodium stagePodium) {
        Cyclist cyclist = cyclistService.getCyclistById(stagePodium.getIdCyclist());
        Stage stage = stageService.getStageById(stagePodium.getIdStage());

        stagePodium.setCyclist(cyclist);
        stagePodium.setStage(stage);

    AuditTransaction auditTransaction = new AuditTransaction();
    auditTransaction.setAction("create");
    auditTransaction.setTable("StagePodium");
    Map<String, Object> data = new HashMap<>();
    data.put("StagePodium", stagePodium);
    auditTransaction.setData(data);
    auditTransactionRepository.save(auditTransaction);

         return stagePodiumRepository.save(stagePodium);
        }
    //uptade StagePodium
    public StagePodium updateStagePodium(StagePodium newsp){

        Stage stage = stageService.getStageById(newsp.getIdStage());
        Cyclist cyclist = cyclistService.getCyclistById(newsp.getIdCyclist());

        StagePodiumKey key= new StagePodiumKey(stage,cyclist);

        StagePodium stagePodium=getStagePodiumById(key);
        stagePodium.setPosition(newsp.getPosition());
        stagePodium.setTime(newsp.getTime());

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("update");
        auditTransaction.setTable("StagePodium");
        Map<String, Object> data = new HashMap<>();
        data.put("StagePodium", newsp);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        return stagePodiumRepository.save(stagePodium);

    }

}
