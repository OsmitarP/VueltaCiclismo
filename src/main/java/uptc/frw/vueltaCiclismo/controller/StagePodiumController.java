package uptc.frw.vueltaCiclismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.jpa.entity.Stage;
import uptc.frw.vueltaCiclismo.jpa.entity.StagePodium;
import uptc.frw.vueltaCiclismo.jpa.entity.key.StagePodiumKey;
import uptc.frw.vueltaCiclismo.services.StagePodiumService;

import java.util.List;

@RestController
@RequestMapping("stagePodium")
public class StagePodiumController {
    @Autowired
    private StagePodiumService stagePodiumService;

    //create
    @PostMapping
    public StagePodium createStagePodiums(@RequestBody StagePodium stagePodium){
        return stagePodiumService.createStagePodiums(stagePodium);
    }

    //get StagePodiums
    @GetMapping
    public List<StagePodium> getAllStagePodium(){
        return stagePodiumService.getAllStagePodium();
    }

    //get by Ids StagePodiums
    @GetMapping("/{idStage}/{idCyclist}")
    public StagePodium getStagePodiumId(@PathVariable long idStage, @PathVariable long idCyclist){

        Stage stage = new Stage();
        stage.setId(idStage);

        Cyclist cyclist = new Cyclist();
        cyclist.setId(idCyclist);

        StagePodiumKey key= new StagePodiumKey(stage,cyclist);

        return  stagePodiumService.getStagePodiumById(key);

    }

    //delete by Id
    @DeleteMapping("/{idStage}/{idCyclist}")
    public void deleteStagePodium(@PathVariable long idStage, @PathVariable long idCyclist){
        Stage stage = new Stage();
        stage.setId(idStage);

        Cyclist cyclist = new Cyclist();
        cyclist.setId(idCyclist);

        StagePodiumKey key= new StagePodiumKey(stage,cyclist);

        stagePodiumService.deleteStagePodiumById(key);
    }

    //update
    @PutMapping
    public StagePodium updateStagePodium(@RequestBody StagePodium stagePodium){
        return stagePodiumService.updateStagePodium(stagePodium);
    }
}
