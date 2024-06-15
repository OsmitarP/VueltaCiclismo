package uptc.frw.vueltaCiclismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;
import uptc.frw.vueltaCiclismo.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    //create Teams
    @PostMapping
    public Team createTeams(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    //Get All Teams
    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    //Get Team by Id
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable long id) {
        return teamService.getTeamById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable long id) {
        teamService.deleteTeamById(id);
    }

    @PutMapping
    public Team updateTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

}
