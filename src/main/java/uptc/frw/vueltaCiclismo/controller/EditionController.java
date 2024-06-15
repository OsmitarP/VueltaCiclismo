package uptc.frw.vueltaCiclismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.services.EditionService;

import java.util.List;

@RestController
@RequestMapping("edition")
public class EditionController {
    @Autowired
    private EditionService editionService;

    //create edition
    @PostMapping
    public Edition createEditions(@RequestBody Edition edition) {
        return editionService.createEditions(edition);
    }

    //show All editions
    @GetMapping
    public List<Edition> getAlleditions() {
        return editionService.getAlleditions();
    }

    //show edition by Id
    @GetMapping("/{id}")
    public Edition getEditionById(@PathVariable long id) {
        return editionService.getEditionById(id);
    }

    //delete edition by id
    @DeleteMapping("/{id}")
    public void deleteEditionById(@PathVariable long id) {
        editionService.deleteEditionById(id);
    }

    //update edition
    @PutMapping
    public Edition updateEdition(@RequestBody Edition edition) {
        return editionService.updateEdition(edition);
    }
}
