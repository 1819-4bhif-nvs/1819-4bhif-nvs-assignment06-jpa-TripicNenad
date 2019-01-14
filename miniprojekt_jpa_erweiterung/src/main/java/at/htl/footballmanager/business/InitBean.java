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
        em.persist(new Team("FC BAYERN MUENCHEN","MUENCHEN","DEUTSCHLAND"));
        em.persist(new Team("BORUSSIA DORTMUND","DORTMUND","DEUTSCHLAND"));
        em.persist(new Team("WERDER BREMEN","BREMEN","DEUTSCHLAND"));
        em.persist(new Team("RB LEIPZIG","LEIPZIG","DEUTSCHLAND"));
        em.persist(new Team("HERTHA BSC","BERLIN","DEUTSCHLAND"));
        em.persist(new Team("BORUSSIA MOENCHENGLADBACH","GLADBACH","DEUTSCHLAND"));
        em.persist(new Team("EINTRACHT FRANKFURT","FRANKFURT","DEUTSCHLAND"));
        em.persist(new Team("TSG HOFFENHEIM","HOFFENHEIM","DEUTSCHLAND"));
        em.persist(new Team("FC AUGSBURG","AUGSBURG","DEUTSCHLAND"));
        em.persist(new Team("FSV MAINZ 05","MAINZ","DEUTSCHLAND"));
        em.persist(new Team("VFL WOLFSBURG","WOLFSBURG","DEUTSCHLAND"));
        em.persist(new Team("SC FREIBURG","FREIBURG","DEUTSCHLAND"));
        em.persist(new Team("BAYER LEVERKUSEN","LEVERKUSEN","DEUTSCHLAND"));
        em.persist(new Team("1. FC NUERNBERG","NUERNBERG","DEUTSCHLAND"));
        em.persist(new Team("HANNOVER 96","HANNOVER","DEUTSCHLAND"));
        em.persist(new Team("FC SCHALKE 04","GELSENKIRCHEN","DEUTSCHLAND"));
        em.persist(new Team("VFB STUTTGART","STUTTGART","DEUTSCHLAND"));
        em.persist(new Team("FORTUNA DUESSELDORF","DUESSELDORF","DEUTSCHLAND"));
    }

    private void initLeagues()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        em.persist(new Liga(allGermanTeams.size(),"2018/2019" ,Wettkampftyp.LIGA,"1. Deutsche Bundesliga",allGermanTeams,34,"DEUTSCHLAND"));
        //public Liga(int teilnehmeranzahl, String saison, Wettkampftyp typ, String liganame, List<Team> teams, int spieltage, String land)
    }

    private void initNationalCup()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        LocalDate finalDate =  LocalDate.of(2019, 5, 1);
        em.persist(new NationalerCup(allGermanTeams.size(),finalDate,"2018/2019",Wettkampftyp.NATIONALERCUP,"DFB-POKAL","Deutschland",allGermanTeams));
        //public NationalerCup(int teilnehmeranzahl, LocalDate finalDatum, String saison, Wettkampftyp typ, String name, String land, List<Team> teams)
    }

    private void initInternationalCup()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> allGermanTeams = query.getResultList();
        LocalDate finalDate =  LocalDate.of(2019, 5, 25);
        em.persist(new InternationalerCup(allGermanTeams.size(),finalDate,"2018/2019",Wettkampftyp.INTERNATIONALES_TURNIER,"Champions League","Europa",allGermanTeams));
        //public InternationalerCup(int teilnehmeranzahl, LocalDate finalDatum, String saison, Wettkampftyp typ, String name, String kontinent, List<Team> teams) {
    }
}
