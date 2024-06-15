package uptc.frw.vueltaCiclismo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.services.CyclistService;

import java.util.List;

@RestController
@RequestMapping("cyclist")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    //create cyclists
    @PostMapping
    public Cyclist CreateCyclists(@RequestBody Cyclist cyclist) {
        return cyclistService.createCyclist(cyclist);
    }

    //Get All Cyclits
    @GetMapping
    public List<Cyclist> getAllCyclists() {
        return cyclistService.getAllCyclist();
    }

    //Get Cyclist by Id
    @GetMapping("/{id}")
    public Cyclist getCyclistById(@PathVariable long id) {
        return cyclistService.getCyclistById(id);
    }

    //Delete Cyclist
    @DeleteMapping("/{id}")
    public void deleteCyclistById(@PathVariable long id) {
        cyclistService.deleteCyclist(id);
    }

    //update
    @PutMapping()
    public Cyclist updateCyclist(@RequestBody Cyclist cyclist) {
        return cyclistService.updateCyclist(cyclist);
    }
}
