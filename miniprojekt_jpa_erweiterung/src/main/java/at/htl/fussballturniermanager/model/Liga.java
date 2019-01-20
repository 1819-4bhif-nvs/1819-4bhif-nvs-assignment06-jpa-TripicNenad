package at.htl.fussballturniermanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LIGEN")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Liga extends Wettkampf{

    String land;
    int spieltage;


    //region Konstruktoren
    public Liga() {
    }


    public Liga(String name, String saison, String land) {
        super(name,saison, Wettkampftyp.LIGA);
        this.land = land;
        this.spieltage = (teams.size()-1)*2;
    }
    //endregion

    //region Getter und Setter
    public String getLand() {
        return land;
    }

    public int getSpieltage() {
        return spieltage;
    }
    //endregion


    @Override
    public String toString() {
        return "Liga{" +
                "land='" + land + '\'' +
                ", spieltage=" + spieltage +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                ", finalDatum=" + finalDatum +
                ", teams=" + teams +
                ", saison='" + saison + '\'' +
                '}';
    }
}
