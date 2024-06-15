package uptc.frw.vueltaCiclismo.jpa.entity.key;

import uptc.frw.vueltaCiclismo.jpa.entity.Edition;
import uptc.frw.vueltaCiclismo.jpa.entity.Sponsor;
import uptc.frw.vueltaCiclismo.jpa.entity.Team;

import java.io.Serializable;

public class TeamParticipationKey implements Serializable {

    private Edition edition;

    private Team team;

    private Sponsor sponsor;

    public TeamParticipationKey() {
    }

    public TeamParticipationKey(Edition edition, Team team, Sponsor sponsor) {
        this.edition = edition;
        this.team = team;
        this.sponsor = sponsor;
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
}
