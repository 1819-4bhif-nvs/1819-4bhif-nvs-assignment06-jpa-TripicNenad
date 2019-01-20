package at.htl.fussballturniermanager.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "INTERNATIONALEWETTKAEMPFE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Internationalerwettkampf extends Wettkampf{

    String kontinent;

    //region Konstruktoren
    public Internationalerwettkampf() {
    }

    public Internationalerwettkampf(String name, LocalDate finalDatum, String saison, String kontinent) {
        super(name, finalDatum,saison, Wettkampftyp.INTERNATIONALERWETTKAMPF);
        this.kontinent = kontinent;
    }
    //endregion


    //region Getter und Setter
    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String continent) {
        this.kontinent = continent;
    }
    //endregion


    @Override
    public String toString() {
        return "Internationalerwettkampf{" +
                "continent='" + kontinent + '\'' +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                ", finalDatum=" + finalDatum +
                ", teams=" + teams +
                ", saison='" + saison + '\'' +
                '}';
    }
}
