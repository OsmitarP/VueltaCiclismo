package uptc.frw.vueltaCiclismo.jpa.entity.key;

import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;

import java.io.Serializable;

public class CyclistParticipationKey implements Serializable {

    private Edition edition;

    private Cyclist cyclist;

    private Team team;

    public CyclistParticipationKey() {
    }

    public CyclistParticipationKey(Edition edition, Cyclist cyclist, Team team) {
        this.edition = edition;
        this.cyclist = cyclist;
        this.team = team;
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
}
