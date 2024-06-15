package uptc.frw.vueltaCiclismo.jpa.entity;

//ENTIDAD DE LLAVES COMPUESTAS

import jakarta.persistence.*;
import uptc.frw.vueltaCiclismo.jpa.entity.key.StagePodiumKey;

import java.sql.Time;

@Entity
@Table(name = "podioetapa")
@IdClass(StagePodiumKey.class)
public class StagePodium {


    @Column(name = "id_etapa", updatable = false,insertable = false)
    private long idStage;

    @Column(name = "id_corredor", updatable = false,insertable = false)
    private long idCyclist;

    @Column(name = "posicion")
    private int position;

    @Column(name = "tiempo")
    private Time time;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_etapa")
    private Stage stage;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_corredor")
    private Cyclist cyclist;

    public StagePodium() {
    }

    public long getIdStage() {
        return idStage;
    }

    public void setIdStage(long idStage) {
        this.idStage = idStage;
    }

    public long getIdCyclist() {
        return idCyclist;
    }

    public void setIdCyclist(long idCyclist) {
        this.idCyclist = idCyclist;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "StagePodium{" +
                "idStage=" + idStage +
                ", idCyclist=" + idCyclist +
                ", position=" + position +
                ", time=" + time +
                ", stage=" + stage +
                ", cyclist=" + cyclist +
                '}';
    }
}
