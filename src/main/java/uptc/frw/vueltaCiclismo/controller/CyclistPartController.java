package uptc.frw.vueltaCiclismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.CyclistParticipationKey;
import uptc.frw.vueltaCiclismo.services.CyclistPartService;

import java.util.List;


@RestController
@RequestMapping("cyclistPart")
public class CyclistPartController {

    @Autowired
    private CyclistPartService cyclistPartService;

    @PostMapping
    public CyclistParticipation createCyclistParts(@RequestBody CyclistParticipation cp){
        return cyclistPartService.createCyclistParts(cp);
    }

    //get
    @GetMapping
    public List<CyclistParticipation> getAllCyclistPart(){
        return cyclistPartService.getAllCyclistPart();
    }

    //get by Id
    @GetMapping("/{idEdition}/{idCyclist}/{idTeam}")
    public CyclistParticipation getCyclistPartId(@PathVariable long idEdition, @PathVariable long idCyclist, @PathVariable long idTeam){

        Edition edition = new Edition();
        edition.setId(idEdition);

        Cyclist cyclist = new Cyclist();
        cyclist.setId(idCyclist);

        Team team = new Team();
        team.setId(idTeam);

        CyclistParticipationKey key = new CyclistParticipationKey(edition,cyclist,team);

        return  cyclistPartService.getCyclistPartId(key);

    }

    //delete by Id
    @DeleteMapping("/{idEdition}/{idCyclist}/{idTeam}")
    public void deleteCyclistPart(@PathVariable long idEdition, @PathVariable long idCyclist, @PathVariable long idTeam){
        Edition edition = new Edition();
        edition.setId(idEdition);

        Cyclist cyclist = new Cyclist();
        cyclist.setId(idCyclist);

        Team team = new Team();
        team.setId(idTeam);

        CyclistParticipationKey key = new CyclistParticipationKey(edition,cyclist,team);

        cyclistPartService.deleteCyclistPart(key);
    }

}
