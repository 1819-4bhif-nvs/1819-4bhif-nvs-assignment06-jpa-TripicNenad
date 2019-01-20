package at.htl.fussballturniermanager.model;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "WETTKAEMPFE")
public abstract class Wettkampf implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    LocalDate finalDatum;
    @ManyToMany
    @JsonbTransient
    List<Team> teams;
    String saison;
    @Enumerated (EnumType.STRING)
    private Wettkampftyp typ;


    //region Konstuktoren
    public Wettkampf() {
        this.teams = new LinkedList<Team>();
    }

    public Wettkampf(String name, String saison, Wettkampftyp typ) {
        this.name = name;
        this.teams = new LinkedList<Team>();
        this.saison = saison;
        this.typ = typ;
    }

    public Wettkampf(String name, LocalDate finalDatum, String saison, Wettkampftyp typ) {
        this.name = name;
        this.finalDatum = finalDatum;
        this.teams = new LinkedList<Team>();
        this.saison = saison;
        this.typ = typ;
    }

    //endregion

    //region Getter und Setter
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFinalDatum() {
        return finalDatum;
    }

    public void setFinalDatum(LocalDate finalDatum) {
        this.finalDatum = finalDatum;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public Wettkampftyp getTyp() {
        return typ;
    }

    public void setTyp(Wettkampftyp typ) {
        this.typ = typ;
    }

    public void addTeam(Team t)
    {
        if (this.teams==null)
            this.teams = new LinkedList<Team>();
        if (!this.teams.contains(t)){
            t.addCompetition(this);
            this.teams.add(t);
        }
    }
    //endregion
}
