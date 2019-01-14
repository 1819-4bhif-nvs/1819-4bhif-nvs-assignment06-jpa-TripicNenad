package at.htl.footballmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class Team {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String teamname;
    String stadt;
    String land;

    //region Konstruktoren
    public Team() {
    }

    public Team(String teamname, String stadt, String land) {
        this.teamname = teamname;
        this.stadt = stadt;
        this.land = land;
    }

    //endregion


    //region Getter und Setter
    public Long getId() {
        return Id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

//endregion


    @Override
    public String toString() {
        return "Team{" +
                "Id=" + Id +
                ", teamname='" + teamname + '\'' +
                ", stadt='" + stadt + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}
