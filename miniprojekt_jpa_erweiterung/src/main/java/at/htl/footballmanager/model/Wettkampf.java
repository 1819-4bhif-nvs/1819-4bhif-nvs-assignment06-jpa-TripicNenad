package at.htl.footballmanager.model;


import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Wettkaempfe")
public abstract class Wettkampf implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    int teilnehmeranzahl;
    LocalDate finalDatum;
    String saison;
    @Enumerated(EnumType.STRING)
    private Wettkampftyp typ;

    //region Konstruktoren
    public Wettkampf() {
    }

    public Wettkampf(int teilnehmeranzahl, String saison, Wettkampftyp typ) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.saison = saison;
        this.typ = typ;
    }

    public Wettkampf(int teilnehmeranzahl, LocalDate finalDatum, String saison, Wettkampftyp typ) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.finalDatum = finalDatum;
        this.saison = saison;
        this.typ = typ;
    }
    //endregion

    //region Getter und Setter

    public Long getId() {
        return Id;
    }

    public int getTeilnehmeranzahl() {
        return teilnehmeranzahl;
    }

    public void setTeilnehmeranzahl(int teilnehmeranzahl) {
        this.teilnehmeranzahl = teilnehmeranzahl;
    }

    public LocalDate getFinalDatum() {
        return finalDatum;
    }

    public void setFinalDatum(LocalDate finalDatum) {
        this.finalDatum = finalDatum;
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

    //endregion


    @Override
    public String toString() {
        return "Wettkampf{" +
                "Id=" + Id +
                ", teilnehmeranzahl=" + teilnehmeranzahl +
                ", finalDatum=" + finalDatum +
                ", saison='" + saison + '\'' +
                ", typ=" + typ +
                '}';
    }
}
