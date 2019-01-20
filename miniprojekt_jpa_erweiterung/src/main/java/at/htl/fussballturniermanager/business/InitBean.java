package at.htl.fussballturniermanager.business;

import at.htl.fussballturniermanager.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

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
        System.err.println("+++++Initialisierung+++++");

        System.err.println("+++++Teams erstellen und Persistierung+++++");
        Team bayern = new Team("FC BAYERN MUENCHEN","MUENCHEN","DEUTSCHLAND");
        em.persist(bayern);
        Team arsenal = new Team ("FC ARSENAL","LONDON","ENGLAND");
        em.persist(arsenal);
        Team barcelona = new Team("FC BARCELONA","BARCELONA","SPANIEN");
        em.persist(barcelona);
        Team psg = new Team("PARIS SAINT GERMAIN","PARIS","FRANKREICH");
        em.persist(psg);

        System.err.println("+++++Wettbewerbe erstellen+++++");

        System.err.println("+++++Ligen erstellen+++++");
        Liga bundesliga = new Liga("BUNDESLIGA","2018/2019","Deutschland");
        Liga pl = new Liga ("PREMIER LEAGUE","2018/2019","ENGLAND");
        Liga laliga = new Liga ("LA LIGA","2018/2019","SPANIEN");
        Liga ligueune = new Liga ("LIGUE UNE","2018/2019","FRANKREICH");

        System.err.println("+++++NW & IW erstellen+++++");
        LocalDate finalDate =  LocalDate.of(2019, 5, 1);
        Nationalerwettkampf dfb = new Nationalerwettkampf("DFB POKAL",finalDate,"2018/2019","DEUTSCHLAND");
        Internationalerwettkampf cl = new Internationalerwettkampf("CHAMPIONS LEAGUE",finalDate,"2018/2019","Europa");

        System.err.println("+++++Teams zu Wettk. hinzufuegen+++++");
        bundesliga.addTeam(bayern);
        pl.addTeam(arsenal);
        laliga.addTeam(barcelona);
        ligueune.addTeam(psg);

        dfb.addTeam(bayern);

        cl.addTeam(bayern);
        cl.addTeam(arsenal);
        cl.addTeam(barcelona);
        cl.addTeam(psg);

        System.err.println("+++++Persistierung+++++");
        em.persist(bundesliga);
        em.persist(pl);
        em.persist(laliga);
        em.persist(ligueune);
        em.persist(dfb);
        em.persist(cl);
    }
}
