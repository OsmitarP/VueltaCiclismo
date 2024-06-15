package uptc.frw.vueltaCiclismo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.TeamParticipationKey;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.TeamPartRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamPartService {

    @Autowired
    private TeamPartRepository teamPartRepository;

    @Autowired
    private EditionService editionService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private SponsorService sponsorService;

    @Autowired
    private AuditTransactionRepository auditTransactionRepository;

    //getAll
    public List<TeamParticipation> getAllTeamParts() {
        return teamPartRepository.findAll();
    }

    //get by Id
    public TeamParticipation getTeamPartById(TeamParticipationKey key) {
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("get");
        auditTransaction.setTable("TeamParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("teamPartService", key);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        return teamPartRepository.findById(key).orElse(null);
    }

    //delete
    public  void deleteTeamPart(TeamParticipationKey key) {
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("delete");
        auditTransaction.setTable("TeamParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("teamPartService", key);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        teamPartRepository.deleteById(key);
    }

    //create
    public TeamParticipation createTeamPart(TeamParticipation teamPart) {
            Edition edition = editionService.getEditionById(teamPart.getIdEdition());
            Team team = teamService.getTeamById(teamPart.getIdTeam());
            Sponsor sponsor = sponsorService.getSponsorByNIT(teamPart.getIdNitSponsor());

        teamPart.setEdition(edition);
        teamPart.setSponsor(sponsor);
        teamPart.setTeam(team);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("create");
        auditTransaction.setTable("TeamParticipation");
        Map<String, Object> data = new HashMap<>();
        data.put("teamPartService", teamPart);
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return teamPartRepository.save(teamPart);
    }

}
