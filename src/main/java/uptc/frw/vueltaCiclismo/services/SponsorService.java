package uptc.frw.vueltaCiclismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import uptc.frw.vueltaCiclismo.jpa.entity.AuditTransaction;
import uptc.frw.vueltaCiclismo.jpa.entity.Sponsor;
import uptc.frw.vueltaCiclismo.jpa.repository.AuditTransactionRepository;
import uptc.frw.vueltaCiclismo.jpa.repository.SponsorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepository sponsorRepository;
    @Autowired
    private AuditTransactionRepository auditTransactionRepository;

    //create Sponsor
    public Sponsor createSponsors(Sponsor sponsor) {
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("Create");
        auditTransaction.setTable("Sponsor");
        Map<String, Object> data = new HashMap<>();
        data.put("sponsorNit",sponsor.getNit());
        data.put("sponsorName",sponsor.getName());
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return sponsorRepository.save(sponsor);
    }


    //get All Sponsors
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();

    }

    // get Sponsor by NIT
    public Sponsor getSponsorByNIT(String nit) {
        Sponsor sponsor = sponsorRepository.findById(nit).orElse(null);
        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("get");
        auditTransaction.setTable("Sponsor");
        Map<String, Object> data = new HashMap<>();

        data.put("sponsorNit",sponsor.getNit());
        data.put("sponsorName",sponsor.getName());
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return sponsorRepository.findById(nit).orElse(null);
    }

    //delete sponsor
    public void deleteSponsorByNIT(String nit) {
        Sponsor sponsor = sponsorRepository.findById(nit).orElse(null);

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("delete");
        auditTransaction.setTable("Sponsor");
        Map<String, Object> data = new HashMap<>();
        data.put("sponsorNit",sponsor.getNit());
        data.put("sponsorName",sponsor.getName());
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        sponsorRepository.deleteById(nit);
    }

    //update
    public Sponsor updateSponsor(Sponsor newsponsor){

        Sponsor sponsor= sponsorRepository.findById(newsponsor.getNit()).orElse(null);
        sponsor.setName(newsponsor.getName());

        AuditTransaction auditTransaction = new AuditTransaction();
        auditTransaction.setAction("update");
        auditTransaction.setTable("Sponsor");
        Map<String, Object> data = new HashMap<>();
        data.put("sponsorNit",sponsor.getNit());;
        data.put("sponsorName",sponsor.getName());
        auditTransaction.setData(data);
        auditTransactionRepository.save(auditTransaction);

        return sponsorRepository.save(sponsor);
    }

}
