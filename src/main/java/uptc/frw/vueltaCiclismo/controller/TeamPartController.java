package uptc.frw.vueltaCiclismo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.jpa.entity.Sponsor;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;
import uptc.frw.vueltaCiclismo.jpa.entity.TeamParticipation;
import uptc.frw.vueltaCiclismo.jpa.entity.key.TeamParticipationKey;
import uptc.frw.vueltaCiclismo.services.TeamPartService;
import uptc.frw.vueltaCiclismo.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("teamPart")
public class TeamPartController {

    @Autowired
    private TeamPartService teamPartService;
    @Autowired
    private TeamService teamService;


    //create
    @PostMapping
    public TeamParticipation createTeamParts(@RequestBody TeamParticipation teamPart) {
        return teamPartService.createTeamPart(teamPart);
    }

    //get All
    @GetMapping
    public List<TeamParticipation> getAllTeamParts() {
        return teamPartService.getAllTeamParts();
    }

    //get By Id
    @GetMapping("/{idEdition}/{idTeam}/{nitSponsor}")
    public TeamParticipation getTeamPartId(@PathVariable long idEdition, @PathVariable long idTeam,@PathVariable String nitSponsor){

        Edition edition = new Edition();
        edition.setId(idEdition);

        Team team = new Team();
        team.setId(idTeam);

        Sponsor sponsor = new Sponsor();
        sponsor.setNit(nitSponsor);

        TeamParticipationKey tempkey = new TeamParticipationKey(edition, team, sponsor);
        return teamPartService.getTeamPartById(tempkey);
    }

    //delete
    @DeleteMapping("/{idEdition}/{idTeam}/{nitSponsor}")
    public void deleteTeamPart(@PathVariable long idEdition, @PathVariable long idTeam,@PathVariable String nitSponsor){
        Edition edition = new Edition();
        edition.setId(idEdition);

        Team team = new Team();
        team.setId(idTeam);

        Sponsor sponsor = new Sponsor();
        sponsor.setNit(nitSponsor);

        TeamParticipationKey key =new TeamParticipationKey(edition,team,sponsor);
        teamPartService.deleteTeamPart(key);
    }


}
