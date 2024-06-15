package uptc.frw.vueltaCiclismo.jpa.entity;

import jakarta.persistence.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.CyclistParticipationKey;

@Entity
@Table(name = "part_corredor")
@IdClass(CyclistParticipationKey.class)
public class CyclistParticipation {

    @Column(name = "id_edicion",updatable = false,insertable = false)
    private long idEdition;

    @Column(name = "id_corredor",updatable = false,insertable = false)
    private long idCyclist;

    @Column(name = "id_equipo",updatable = false,insertable = false)
    private long idTeam;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_edicion")
    private Edition edition;


    @Id
    @ManyToOne
    @JoinColumn(name = "id_corredor")
    private Cyclist cyclist;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Team team;

    public CyclistParticipation() {
    }

    public long getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(long idEdition) {
        this.idEdition = idEdition;
    }

    public long getIdCyclist() {
        return idCyclist;
    }

    public void setIdCyclist(long idCyclist) {
        this.idCyclist = idCyclist;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "CyclistParticipation{" +
                "idEdition=" + idEdition +
                ", idCyclist=" + idCyclist +
                ", idTeam=" + idTeam +
                ", edition=" + edition +
                ", cyclist=" + cyclist +
                ", team=" + team +
                '}';
    }
}
