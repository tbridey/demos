package com.revature.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Match;
import com.revature.models.Video;
import com.revature.util.HibernateUtil;

/*
 * Methods that are on the session:
 * 
 * save() & persist() -> result in a SQL insert
 * update() & merge() -> result in a SQL update
 * delete() 		  -> result in a SQL delete
 * get() & load()	  -> result in a SQL select
 * 
 * saveOrUpdate()	  -> result in either a SQL insert or update accordingly
 * 
 * 
 * 
 * update() does NOT allow duplicates in your cache
 * 		If the entity was already in the cache, this will throw an exception
 * merge() will insert into the cache or overwrite the value in the cache accordingly
 * 
 * 
 * get() will retrieve from the database immediately
 * 
 * load() will use a placeholder (called a proxy) until you actually need the value
 * 		Attempting to use the proxy after the session is closed will result in a
 * 		LazyInitializationException
 */

public class MatchDAO implements IMatchDAO {

	@Override
	public List<Match> findAll() {
		Session s = HibernateUtil.getSession();
		
		Transaction tx = s.beginTransaction();
		
		// HQL = Hibernate Query Language
		// We could use the Entity name to reference tables
//		Query<Match> query = s.createQuery("FROM Match m", Match.class);
//		
//		List<Match> matches = query.getResultList();
		
		
		// NativeSQL Query
		// We have to use the exact table names to reference
//		String sql = "SELECT * FROM matches";
//		
//		Query<Match> query = s.createNativeQuery(sql, Match.class);
//		
//		List<Match> matches = query.getResultList();
		
		// The below code here uses Hibernate 5's new Criteria Query API
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Match> query = builder.createQuery(Match.class);
		Root<Match> root = query.from(Match.class);
		
		query.select(root);
		
		List<Match> matches = s.createQuery(query).getResultList();
		
		tx.commit();
		
		return matches;
	}

	@Override
	public Match findByEmbed(String embed) {
		Session sess = HibernateUtil.getSession();
		
		return sess.get(Match.class, embed);
	}

	@Override
	public Set<Match> findByVideo(Video v) {
		Set<Match> set = null;
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Match> query = builder.createQuery(Match.class);
		
		Root<Match> root = query.from(Match.class);
		Join<Match, Video> join = root.join("videos", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("embed"), v.getEmbed()));

		set = s.createQuery(query).getResultStream()
					.collect(Collectors.toSet());
		
		tx.commit();
		
		return set;
	}

	@Override
	public void delete(Match m) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		sess.delete(m);
		
		tx.commit();
	}

	@Override
	public boolean insert(Match m) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		String id = (String) sess.save(m);
		
		if(id != null && !id.equals("")) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}

	@Override
	public boolean update(Match m) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		Match result = (Match) sess.merge(m);
		
		if(result.equals(m)) {
			tx.commit();
			return true;
		}
		
		tx.rollback();
		return false;
	}
}
