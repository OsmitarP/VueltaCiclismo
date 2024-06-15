package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.jpa.entity.Stage;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.StageRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StageService {
  @Autowired
  private StageRepository stageRepository;

  @Autowired
  private EditionService editionService;

  @Autowired
  private AuditTransactionRepository auditTransactionRepository;

  //getAll Stage
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

   // get Stage By Id
    public Stage getStageById(long id) {

        Stage stage = stageRepository.findById(id).orElse(null);
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Get");
        auditTransaction.setTable("Stage");
        Map<String, Object> data = new HashMap<>();

        data.put("id",stage.getId());
        data.put("edition",stage.getIdEdition());
        data.put("start",stage.getStart());
        data.put("end",stage.getFinish());
        data.put("distance",stage.getDistance());
        data.put("type",stage.getType());
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return stageRepository.findById(id).orElse(null);
    }

  //create Stages
    public Stage createStage(Stage stage) {

        Edition edition =  editionService.getEditionById(stage.getIdEdition());
        stage.setEdition(edition);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Stage");
        Map<String, Object> data = new HashMap<>();
        data.put("id",stage.getId());
        data.put("edition",stage.getIdEdition());
        data.put("start",stage.getStart());
        data.put("end",stage.getFinish());
        data.put("distance",stage.getDistance());
        data.put("type",stage.getType());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

    return stageRepository.save(stage);
    }

    //delete
    public void deleteStageById(long id) {

        Stage stage = stageRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Delete");
        auditTransaction.setTable("Stage");
        Map<String, Object> data = new HashMap<>();
        data.put("id",stage.getId());
        data.put("edition",stage.getIdEdition());
        data.put("start",stage.getStart());
        data.put("end",stage.getFinish());
        data.put("distance",stage.getDistance());
        data.put("type",stage.getType());
        auditTransaction.setData(data);

        auditTransactionRepository.save(auditTransaction);
        stageRepository.deleteById(id);
    }

    //update
    public Stage updateStage(Stage newstage) {
        Stage stage = stageRepository.findById(newstage.getId()).orElse(null);
        Edition edition =  editionService.getEditionById(newstage.getIdEdition());

        stage.setEdition(edition);
        stage.setStageNumber(newstage.getStageNumber());
        stage.setStart(newstage.getStart());
        stage.setFinish(newstage.getFinish());
        stage.setDistance(newstage.getDistance());
        stage.setType(newstage.getType());

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Stage");
        Map<String, Object> data = new HashMap<>();
        data.put("id",stage.getId());
        data.put("edition",stage.getIdEdition());
        data.put("start",stage.getStart());
        data.put("end",stage.getFinish());
        data.put("distance",stage.getDistance());
        data.put("type",stage.getType());
        auditTransaction.setData(data);

        auditTransactionRepository.save(auditTransaction);
        return stageRepository.save(stage);
    }
}
