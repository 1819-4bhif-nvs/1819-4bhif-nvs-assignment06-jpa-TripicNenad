package at.htl.fussballturniermanager.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NATIONALEWETTKAEMPFE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Nationalerwettkampf extends Wettkampf{

    String land;


    //region Konstruktoren
    public Nationalerwettkampf() {
    }

    public Nationalerwettkampf(String name, LocalDate finalDatum, String saison, String land) {
        super(name, finalDatum, saison, Wettkampftyp.NATIONALERWETTKAMPF);
        this.land = land;
    }
    //endregion


    //region Getter und Setter
    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
    //endregion


    @Override
    public String toString() {
        return "Nationalerwettkampf{" +
                "land='" + land + '\'' +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                ", finalDatum=" + finalDatum +
                ", teams=" + teams +
                ", saison='" + saison + '\'' +
                '}';
    }
}
