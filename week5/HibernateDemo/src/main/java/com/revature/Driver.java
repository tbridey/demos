package com.revature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Competition;
import com.revature.models.Match;
import com.revature.models.Pokemon;
import com.revature.models.Side;
import com.revature.models.Trainer;
import com.revature.models.Video;
import com.revature.repositories.IMatchDAO;
import com.revature.repositories.MatchDAO;
import com.revature.util.HibernateUtil;

public class Driver {
	
	private static IMatchDAO dao = new MatchDAO();

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();

		Transaction tx = s.beginTransaction();
		
		// These entities are in the TRANSIENT State
		// They are not yet associated with our session above
		Side side1 = new Side("Zorka W", "https://www.scorebat.com/live-stream/zorka-w/");
		Side side2 = new Side("Neman W", "https://www.scorebat.com/live-stream/neman-w/");
		
		// These statements transition the entities into the PERSISTENT state
		// Considering that our entities don't have @Ids declared, Hibernate might not work properly
		s.save(side1);
		s.save(side2);
		
		tx.commit();
		HibernateUtil.closeSession();
		
		// Our objects are now in the DETACHED state
		
		s = HibernateUtil.getSession();
		tx = s.beginTransaction();
		
		// These objects should be once again PERSISTENT
		side1 = (Side) s.merge(side1);
		side2 = (Side) s.merge(side2);
		
		Competition c = new Competition(3121, "BELARUS: Premier League - Women",
				"https://www.scorebat.com/belarus-premier-league--women-live-scores/");
		
		s.save(c);
		
		Video v = new Video("Live Stream", "<div style='width:100%;height:0px;position:relative"
				+ ";padding-bottom:56.250%;'><iframe src='https://www.scorebat.com/embed"
				+ "/v/5f5a31d9a1fac/?s=2' frameborder='0' width='100%' height='100%' allowfullscreen"
				+" allow='autoplay; fullscreen' style='width:100%;height:100%;position:absolute;left:0px"
				+";top:0px;overflow:hidden;'></iframe></div>");
		
		s.save(v);
		
		List<Video> videoList = new ArrayList<>();
		videoList.add(v);
		
		Match m = new Match("Zorka W - Neman W", "<div style='width:100%;height:0px;position:relative;padding-bottom:calc(56.25% + 335px);' class='_scorebatEmbeddedPlayerW_'><iframe src='https://www.scorebat.com/embed/g/927048/?s=2' frameborder='0' width='560' height='650' allowfullscreen allow='autoplay; fullscreen' style='width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;' class='_scorebatEmbeddedPlayer_'></iframe></div>",
				"https://www.scorebat.com/neman-w-vs-zorka-w-live-stream/", "https://www.scorebat.com/og/m/og927048.jpeg",
				LocalDateTime.parse("2020-09-10T14:00:00+0000", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")),
				side1, side2, c, videoList);
				
		tx.commit();
		
		dao.insert(m);
		
		List<Match> matches = dao.findAll();
		
		System.out.println(matches);
		
		Set<Match> matchSet = dao.findByVideo(v);
		
		System.out.println(matchSet);
		
		System.out.println(dao.findByEmbed(m.getEmbed()));
		
		m.setDate(LocalDateTime.now());
		
		System.out.println(dao.update(m));
		System.out.println(m);
		
		dao.delete(m);
		
		System.out.println(dao.findAll());
		
		s = HibernateUtil.getSession();
		tx = s.beginTransaction();
		
		Trainer t = new Trainer(0, "Ash Ketchum", new HashSet<>());
		s.save(t);
		
		
		Pokemon p = new Pokemon(0, "Pikachu", "Electric", t);
		s.save(p);

		tx.commit();
		
		HibernateUtil.closeSession();
		
		s = HibernateUtil.getSession();
		
		System.out.println(s.get(Trainer.class, t.getId()).getParty());
		
		List<Trainer> result1 = s.createNamedQuery("getAll", Trainer.class).getResultList();
		
		System.out.println(result1);
		
		List<Pokemon> result2 = s.createNamedQuery("getByType", Pokemon.class)
					.setParameter("type", "Electric")
					.getResultList();
		
		System.out.println(result2);
		
		System.out.println(result2.get(0).getTrainer());
		
		List<Trainer> result3 = s.createNamedQuery("get_trainer_with_pokemon", Trainer.class)
					.setParameter("name", "Pikachu")
					.getResultList();
		
		System.out.println(result3);
		
		List<Trainer> result4 = s.createNamedQuery("get_trainer_with_pokemon", Trainer.class)
				.setParameter("name", "Bulbasaur")
				.getResultList();
	
		System.out.println(result4);
	}
}
