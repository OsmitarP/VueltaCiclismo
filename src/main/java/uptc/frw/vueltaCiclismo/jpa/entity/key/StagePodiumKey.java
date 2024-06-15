package uptc.frw.vueltaCiclismo.jpa.entity.key;

import jakarta.persistence.Embeddable;
import uptc.frw.vueltaCiclismo.jpa.entity.Cyclist;
import uptc.frw.vueltaCiclismo.jpa.entity.Stage;

import java.io.Serializable;
@Embeddable
public class StagePodiumKey implements Serializable {

    private Stage stage;

    private Cyclist cyclist;

    public StagePodiumKey() {
    }

    public StagePodiumKey(Stage stage, Cyclist cyclist) {
        this.stage = stage;
        this.cyclist = cyclist;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }
}
