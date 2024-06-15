package uptc.frw.vueltaCiclismo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Team {

    @Id
    @Column(name = "id_equipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "fecha_fundacion")
    private Date foundingDate;

    //relation Cyclist Participation
    @JsonIgnore
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CyclistParticipation> cyclistParticipations;

    //relation Team Participation
    @JsonIgnore
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamParticipation> teamParticipations;

    public Team() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public List<CyclistParticipation> getCyclistParticipations() {
        return cyclistParticipations;
    }

    public void setCyclistParticipations(List<CyclistParticipation> cyclistParticipations) {
        this.cyclistParticipations = cyclistParticipations;
    }

    public List<TeamParticipation> getTeamParticipations() {
        return teamParticipations;
    }

    public void setTeamParticipations(List<TeamParticipation> teamParticipations) {
        this.teamParticipations = teamParticipations;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }
}
