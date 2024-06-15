package uptc.frw.vueltaCiclismo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "edicion")
public class Edition {
    @Id
    @Column(name = "id_edicion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "anio")
    private int year;

    @Column(name = "fecha_inicio")
    private Date beginDate;

    @Column(name = "fecha_fin")
    private Date endDate;

    //relacion  con etapa(Stage)
    @JsonIgnore
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stage> stages;

    //relacion con CiclystParticipation
    @JsonIgnore
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CyclistParticipation> cyclistParticipations;

    //relation TeamParticipation
    @JsonIgnore
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamParticipation> teamParticipations;

    public Edition() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
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
        return "Edition{" +
                "id=" + id +
                ", year=" + year +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
