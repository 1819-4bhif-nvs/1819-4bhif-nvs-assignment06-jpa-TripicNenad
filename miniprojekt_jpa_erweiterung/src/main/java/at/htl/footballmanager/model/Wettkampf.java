package at.htl.footballmanager.model;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Wettkaempfe")
public abstract class Wettkampf implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    int teilnehmerzahl;
    @Enumerated(EnumType.STRING)
    private Wettkampftyp typ;

    //region Konstruktoren
    public Wettkampf() {
    }

    public Wettkampf(int teilnehmerzahl, Wettkampftyp typ) {
        this.teilnehmerzahl = teilnehmerzahl;
        this.typ = typ;
    }
    //endregion

    //region Getter und Setter
    public Long getId() {
        return Id;
    }

    public int getTeilnehmerzahl() {
        return teilnehmerzahl;
    }

    public void setTeilnehmerzahl(int teilnehmerzahl) {
        this.teilnehmerzahl = teilnehmerzahl;
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
                ", teilnehmerzahl=" + teilnehmerzahl +
                ", typ=" + typ +
                '}';
    }
}
