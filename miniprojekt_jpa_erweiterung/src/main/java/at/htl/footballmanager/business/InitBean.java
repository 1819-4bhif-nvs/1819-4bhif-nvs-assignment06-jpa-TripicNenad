package at.htl.footballmanager.business;

import at.htl.footballmanager.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Startup
@Singleton
public class InitBean {
    @PersistenceContext
    EntityManager em;

    public InitBean() {
    }

    @PostConstruct
    private void init()
    {
        initGermanTeams();
        initLeagues();
        initNationalCup();
        initInternationalCup();
    }

    private void initGermanTeams()
    {
        em.persist(new Team(1,"FC BAYERN MUENCHEN","MUENCHEN",0));
        em.persist(new Team(2,"BORUSSIA DORTMUND","DORTMUND",0));
        em.persist(new Team(3,"WERDER BREMEN","BREMEN",0));
        em.persist(new Team(4,"RB LEIPZIG","LEIPZIG",0));
        em.persist(new Team(5,"HERTHA BSC","BERLIN",0));
        em.persist(new Team(6,"BORUSSIA MOENCHENGLADBACH","GLADBACH",0));
        em.persist(new Team(7,"EINTRACHT FRANKFURT","FRANKFURT",0));
        em.persist(new Team(8,"TSG HOFFENHEIM","HOFFENHEIM",0));
        em.persist(new Team(9,"FC AUGSBURG","AUGSBURG",0));
        em.persist(new Team(10,"FSV MAINZ 05","MAINZ",0));
        em.persist(new Team(11,"VFL WOLFSBURG","WOLFSBURG",0));
        em.persist(new Team(12,"SC FREIBURG","FREIBURG",0));
        em.persist(new Team(13,"BAYER LEVERKUSEN","LEVERKUSEN",0));
        em.persist(new Team(14,"1. FC NUERNBERG","NUERNBERG",0));
        em.persist(new Team(15,"HANNOVER 96","HANNOVER",0));
        em.persist(new Team(16,"FC SCHALKE 04","GELSENKIRCHEN",0));
        em.persist(new Team(17,"VFB STUTTGART","STUTTGART",0));
        em.persist(new Team(18,"FORTUNA DUESSELDORF","DUESSELDORF",0));
    }

    private void initLeagues()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        //int teilnehmerzahl, Wettkampftyp typ, String liganame, List<Team> teams, int spieltage
        em.persist(new Liga(allGermanTeams.size(), Wettkampftyp.LIGA,"1. Deutsche Bundesliga",allGermanTeams,34));
    }

    private void initNationalCup()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        //int teilnehmerzahl, Wettkampftyp typ, String name, String land, List<Team> teams, LocalDate finalDatum
        LocalDate finalDate =  LocalDate.of(2019, 5, 1);
        em.persist(new NationalerCup(allGermanTeams.size(),Wettkampftyp.NATIONALERCUP,"DFB-POKAL","Deutschland",allGermanTeams,finalDate));
    }

    private void initInternationalCup()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        LocalDate finalDate =  LocalDate.of(2019, 5, 25);
        //int teilnehmerzahl, Wettkampftyp typ, String name, String kontinent, List<Team> teams, LocalDate finalDatum
        em.persist(new InternationalerCup(allGermanTeams.size(),Wettkampftyp.INTERNATIONALES_TURNIER,"Champions League","Europa",allGermanTeams,finalDate));
    }
}
