package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.TeamRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AuditTransactionRepository auditTransactionRepository;
    //create Team
    public Team createTeam(Team team) {

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Team");
        Map<String, Object> data = new HashMap<>();
        data.put("id",team.getId());
        data.put("name",team.getName());
        data.put("foundationDate",team.getFoundingDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return teamRepository.save(team);
    }

    //Get All Teams
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    //Get Team by Id
    public Team getTeamById(long id) {

        Team team = teamRepository.findById(id).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Get");
        auditTransaction.setTable("Team");
        Map<String, Object> data = new HashMap<>();
        data.put("id",team.getId());
        data.put("name",team.getName());
        data.put("foundationDate",team.getFoundingDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return teamRepository.findById(id).orElse(null);
    }

    //delete team,
    public void deleteTeamById(long id) {

        Team team = teamRepository.findById(id).orElse(null);
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Delete");
        auditTransaction.setTable("Team");
        Map<String, Object> data = new HashMap<>();
        data.put("id",team.getId());
        data.put("name",team.getName());
        data.put("foundationDate",team.getFoundingDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        teamRepository.deleteById(id);
    }

    //update Team
    public Team updateTeam(Team newteam) {
        Team team = teamRepository.findById(newteam.getId()).orElse(null);
        team.setName(newteam.getName());
        team.setFoundingDate(newteam.getFoundingDate());

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Update");
        auditTransaction.setTable("Team");
        Map<String, Object> data = new HashMap<>();
        data.put("id",team.getId());
        data.put("name",team.getName());
        data.put("foundationDate",team.getFoundingDate());

        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);
        return teamRepository.save(team);
    }
}
