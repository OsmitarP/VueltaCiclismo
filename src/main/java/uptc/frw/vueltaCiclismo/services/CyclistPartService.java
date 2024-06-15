package uptc.frw.vueltaCiclismo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.CyclistParticipationKey;

import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.CyclistPartRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CyclistPartService {

    @Autowired
    private CyclistPartRepository cyclistPartRepository;

    @Autowired
    private CyclistService cyclistService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private EditionService editionService;

    @Autowired
    private AuditTransactionRepository auditTransactionRepository;

    //get All Cyclists participations
    public List<CyclistParticipation> getAllCyclistPart() {
        return cyclistPartRepository.findAll();
    }

    //get Cyclist Participation by id
    public CyclistParticipation getCyclistPartId(CyclistParticipationKey id) {
        CyclistParticipation cyclistParticipation = cyclistPartRepository.findById(id).orElse(null);
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("get");
        auditTransaction.setTable("CyclistParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("CyclistPart", cyclistParticipation);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        return cyclistParticipation;
    }

//delete Cyclist Participation

    public void deleteCyclistPart(CyclistParticipationKey id) {
        CyclistParticipation cyclistParticipation = cyclistPartRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("delete");
        auditTransaction.setTable("CyclistParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("CyclistPart", cyclistParticipation);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        cyclistPartRepository.deleteById(id);
    }


    //create Cyclist Participation
    public CyclistParticipation createCyclistParts(CyclistParticipation cyclistPart) {


            Cyclist cyclist = cyclistService.getCyclistById(cyclistPart.getIdCyclist());
            Team team = teamService.getTeamById(cyclistPart.getIdTeam());
            Edition edition = editionService.getEditionById(cyclistPart.getIdEdition());

        cyclistPart.setCyclist(cyclist);
        cyclistPart.setTeam(team);
        cyclistPart.setEdition(edition);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("create");
        auditTransaction.setTable("CyclistParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("CyclistPart", cyclistPart);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return cyclistPartRepository.save(cyclistPart);
    }


}
