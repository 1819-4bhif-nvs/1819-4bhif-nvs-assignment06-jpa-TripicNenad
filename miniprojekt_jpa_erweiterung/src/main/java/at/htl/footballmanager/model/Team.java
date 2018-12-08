package at.htl.footballmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class Team {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String teamname;
    String city;
    int points;
    int rank;

    //region Konstruktoren
    public Team() {
    }

    public Team(String teamname, String city, int points, int rank) {
        this.teamname = teamname;
        this.city = city;
        this.points = points;
        this.rank = rank;
    }

    public Team(int rank, String teamname, String city, int points)
    {
        this.teamname = teamname;
        this.city = city;
        this.points = points;
        this.rank = rank;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    //endregion


    @Override
    public String toString() {
        return "Team{" +
                "Id=" + Id +
                ", teamname='" + teamname + '\'' +
                ", city='" + city + '\'' +
                ", points=" + points +
                ", rank=" + rank +
                '}';
    }
}
