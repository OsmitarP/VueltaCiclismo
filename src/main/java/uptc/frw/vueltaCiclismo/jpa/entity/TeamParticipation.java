package uptc.frw.vueltaCiclismo.jpa.entity;

//ENTIDAD DE LLAVES COMPUESTAS

import jakarta.persistence.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.TeamParticipationKey;

@Entity
@Table(name = "part_equipo")
@IdClass(TeamParticipationKey.class)
public class TeamParticipation {

    @Column(name = "id_edicion", updatable = false,insertable = false)
    private long idEdition;

    @Column(name = "id_equipo", updatable = false,insertable = false)
    private long idTeam;

    @Column(name = "nit", updatable = false,insertable = false)
    private String idNitSponsor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_edicion")
    private Edition edition;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "nit")
    private Sponsor sponsor;

    public TeamParticipation() {
    }

    public long getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(long idEdition) {
        this.idEdition = idEdition;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdNitSponsor() {
        return idNitSponsor;
    }

    public void setIdNitSponsor(String idNitSponsor) {
        this.idNitSponsor = idNitSponsor;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    @Override
    public String toString() {
        return "TeamParticipation{" +
                "idEdition=" + idEdition +
                ", idTeam=" + idTeam +
                ", idNitSponsor='" + idNitSponsor + '\'' +
                ", edition=" + edition +
                ", team=" + team +
                ", sponsor=" + sponsor +
                '}';
    }
}
