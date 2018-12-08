package at.htl.footballmanager.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ligen")
public class Liga extends Wettkampf{

    String liganame;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonbTransient
    List<Team> teams;
    int spieltage;

    //region Konstruktoren
    public Liga() {
    }

    public Liga(int teilnehmerzahl, Wettkampftyp typ, String liganame, List<Team> teams, int spieltage) {
        super(teilnehmerzahl, typ);
        this.liganame = liganame;
        this.teams = teams;
        this.spieltage = spieltage;
    }
    //endregion

    //region Getter und Setter
    public String getLiganame() {
        return liganame;
    }

    public void setLiganame(String liganame) {
        this.liganame = liganame;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int getSpieltage() {
        return spieltage;
    }

    public void setSpieltage(int spieltage) {
        this.spieltage = spieltage;
    }
    //endregion


    @Override
    public String toString() {
        return "Liga{" +
                "liganame='" + liganame + '\'' +
                ", teams=" + teams +
                ", spieltage=" + spieltage +
                ", Id=" + Id +
                ", teilnehmerzahl=" + teilnehmerzahl +
                '}';
    }
}
