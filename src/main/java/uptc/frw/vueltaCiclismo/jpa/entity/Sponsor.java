package uptc.frw.vueltaCiclismo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patrocinador")
public class Sponsor {

    @Id
    @Column(name = "nit")
    private String nit;

    @Column(name = "nombre")
    private String name;

    //relation Team Participation
    @JsonIgnore
    @OneToMany(mappedBy = "sponsor",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamParticipation> teamParticipations;

    public Sponsor() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeamParticipation> getTeamParticipations() {
        return teamParticipations;
    }

    public void setTeamParticipations(List<TeamParticipation> teamParticipations) {
        this.teamParticipations = teamParticipations;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "nit='" + nit + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
