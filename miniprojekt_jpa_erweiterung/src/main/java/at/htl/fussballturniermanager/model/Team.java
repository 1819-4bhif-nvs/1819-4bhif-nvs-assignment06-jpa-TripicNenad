package at.htl.fussballturniermanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "TEAMS")
public class Team implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String stadt;
    String land;
    @ManyToMany
    List<Wettkampf> wettkaempfe;



    //region Konstruktoren
    public Team() {
    }

    public Team(String name, String stadt, String land, List<Wettkampf> wettkaempfe) {
        this.name = name;
        this.stadt = stadt;
        this.land = land;
        this.wettkaempfe = wettkaempfe;
    }

    public Team(String name, String stadt, String land) {
        this.name = name;
        this.stadt = stadt;
        this.land = land;
    }

    //endregion


    //region Getter und Setter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Wettkampf> getWettkaempfe() {
        return wettkaempfe;
    }

    public void setWettkaempfe(List<Wettkampf> wettkaempfe) {
        this.wettkaempfe = wettkaempfe;
    }

    //endregion


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt='" + stadt + '\'' +
                ", land='" + land + '\'' +
                ", wettkaempfe=" + wettkaempfe +
                '}';
    }

    public void addCompetition(Wettkampf wettkampf) {
        if (this.wettkaempfe == null)
            this.wettkaempfe = new LinkedList<Wettkampf>();
        if (!this.wettkaempfe.contains(wettkampf))
            this.wettkaempfe.add(wettkampf);
    }
}
