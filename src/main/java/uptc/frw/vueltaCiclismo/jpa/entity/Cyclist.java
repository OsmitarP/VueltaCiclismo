package uptc.frw.vueltaCiclismo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "corredor")
public class Cyclist {

    @Id
    @Column(name = "id_corredor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "pais_nacimiento")
    private  String countryBirth;

    @Column(name = "fecha_nacimiento")
    private Date birthDate;


    //relacion podioetapa
    @JsonIgnore
    @OneToMany(mappedBy = "cyclist",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StagePodium> stagePodiums;

    //relacion CyclistPraticipation
    @JsonIgnore
    @OneToMany(mappedBy = "cyclist",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CyclistParticipation> cyclistParticipations;

    public Cyclist() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<StagePodium> getStagePodiums() {
        return stagePodiums;
    }

    public void setStagePodiums(List<StagePodium> stagePodiums) {
        this.stagePodiums = stagePodiums;
    }

    public List<CyclistParticipation> getCyclistParticipations() {
        return cyclistParticipations;
    }

    public void setCyclistParticipations(List<CyclistParticipation> cyclistParticipations) {
        this.cyclistParticipations = cyclistParticipations;
    }

    @Override
    public String toString() {
        return "Cyclist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryBirth='" + countryBirth + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

