package com.revature.repositories;

import java.util.List;
import java.util.Set;

import com.revature.models.Match;
import com.revature.models.Video;

public interface IMatchDAO {
	
	public List<Match> findAll();

	public Match findByEmbed(String embed);
	
	public Set<Match> findByVideo(Video v);
	
	public void delete(Match m);
	
	public boolean insert(Match m);
	
	public boolean update(Match m);
}
