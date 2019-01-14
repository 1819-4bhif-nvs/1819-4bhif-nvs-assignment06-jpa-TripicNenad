package at.htl.footballmanager.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NationalCups")
public class NationalerCup extends Wettkampf {

    String name;
    String land;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonbTransient
    List<Team> teams;

    //region Konstruktoren
    public NationalerCup() {
    }

    public NationalerCup(int teilnehmeranzahl, LocalDate finalDatum, String saison, Wettkampftyp typ, String name, String land, List<Team> teams) {
        super(teilnehmeranzahl, finalDatum, saison, typ);
        this.name = name;
        this.land = land;
        this.teams = teams;
    }

    //endregion


    //region Getter und Setter
    @Override
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    //endregion


    @Override
    public String toString() {
        return "NationalerCup{" +
                "name='" + name + '\'' +
                ", land='" + land + '\'' +
                ", teams=" + teams +
                ", Id=" + Id +
                ", teilnehmeranzahl=" + teilnehmeranzahl +
                ", finalDatum=" + finalDatum +
                ", saison='" + saison + '\'' +
                '}';
    }
}
