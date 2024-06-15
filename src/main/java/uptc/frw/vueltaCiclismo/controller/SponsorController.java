package uptc.frw.vueltaCiclismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.vueltaCiclismo.jpa.entity.Sponsor;
import uptc.frw.vueltaCiclismo.services.SponsorService;

import java.util.List;

@RestController
@RequestMapping("sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    //create sponsors
    @PostMapping
    public Sponsor createSponsors(@RequestBody Sponsor sponsor){
        return  sponsorService.createSponsors(sponsor);
    }

    //get All Sponsors
    @GetMapping
    public  List<Sponsor> getAllSponsors(){
        return sponsorService.getAllSponsors();
    }

    //get Sponsor by nit
    @GetMapping("/{nit}")
    public Sponsor getSponsorByNit(@PathVariable String nit){
        return sponsorService.getSponsorByNIT(nit);
    }

    //delete
    @DeleteMapping("/{nit}")
    public void deleteSponsorByNit(@PathVariable String nit){
        sponsorService.deleteSponsorByNIT(nit);
    }

    //update
    @PutMapping
    public  Sponsor uptadeSponsor(@RequestBody Sponsor sponsor){
        return sponsorService.updateSponsor(sponsor);
    }
}
