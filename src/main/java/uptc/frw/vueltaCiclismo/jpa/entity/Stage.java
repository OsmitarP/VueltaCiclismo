package uptc.frw.vueltaCiclismo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "etapa")
public class Stage {

    @Id
    @Column(name = "id_etapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_edicion", updatable = false, insertable = false)
    private long idEdition; //FK

    @Column(name = "numero_etapa")
    private int stageNumber;

    @Column(name = "origen")
    private String start;

    @Column(name = "destino")
    private String finish;

    @Column(name = "longitud")
    private  float distance;

    @Column(name = "tipo")
    private String type;


    @ManyToOne
    @JoinColumn(name="id_edicion")
    private Edition edition;


    //relacion con podioetapa
    @JsonIgnore
    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StagePodium> stagePodiums;


    public Stage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(long idEdition) {
        this.idEdition = idEdition;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public List<StagePodium> getStagePodiums() {
        return stagePodiums;
    }

    public void setStagePodiums(List<StagePodium> stagePodiums) {
        this.stagePodiums = stagePodiums;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", idEdition=" + idEdition +
                ", stageNumber=" + stageNumber +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }
}
