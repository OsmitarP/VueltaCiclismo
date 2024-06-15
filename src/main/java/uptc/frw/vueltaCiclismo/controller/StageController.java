package uptc.frw.vueltaCiclismo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Stage;
import uptc.frw.vueltaCiclismo.services.StageService;

import java.util.List;

@RestController
@RequestMapping("stage")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable long id) {
        return stageService.getStageById(id);
    }

    @PostMapping
    public Stage createStage(@RequestBody Stage stage) {
        return stageService.createStage(stage);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable long id) {
        stageService.deleteStageById(id);
    }

    @PutMapping
    public Stage updateStage(@RequestBody Stage stage) {
    return stageService.updateStage(stage);
    }
}
