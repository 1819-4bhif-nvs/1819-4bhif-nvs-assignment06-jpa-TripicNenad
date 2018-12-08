package at.htl.footballmanager.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "InternationaleCups")
public class InternationalerCup extends Wettkampf {
    String name;
    String kontinent;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonbTransient
    List<Team> teams;
    LocalDate finalDatum;

    //region Konstruktoren
    public InternationalerCup() {
    }

    public InternationalerCup(int teilnehmerzahl, Wettkampftyp typ, String name, String kontinent, List<Team> teams, LocalDate finalDatum) {
        super(teilnehmerzahl, typ);
        this.name = name;
        this.kontinent = kontinent;
        this.teams = teams;
        this.finalDatum = finalDatum;
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

    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String kontinent) {
        this.kontinent = kontinent;
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
        return "InternationalerCup{" +
                "name='" + name + '\'' +
                ", kontinent='" + kontinent + '\'' +
                ", teams=" + teams +
                ", finalDatum=" + finalDatum +
                ", Id=" + Id +
                ", teilnehmerzahl=" + teilnehmerzahl +
                '}';
    }
}
