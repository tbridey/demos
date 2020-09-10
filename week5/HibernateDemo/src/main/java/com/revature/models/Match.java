package com.revature.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "matches") // optional
public class Match {

	@Column(name = "title") // optional
	private String title;
	
	@Id
	@Column(length = 1000)
	private String embed;
	private String url;
	private String thumbnail;
	private LocalDateTime date;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "side1_id", referencedColumnName = "name")
	private Side side1;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "side2_id", referencedColumnName = "name")
	private Side side2;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "competition_id", referencedColumnName = "competition_id")
	private Competition competition;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
//	@JoinColumn(name = "video_embed", referencedColumnName = "embed")
	@JoinTable(joinColumns = {
			@JoinColumn(name = "match_id", referencedColumnName = "embed")
	}, inverseJoinColumns = {
			@JoinColumn(name = "video_id", referencedColumnName = "embed")
	})
	private List<Video> videos;

	public Match() {
		super();
	}

	public Match(String title, String embed, String url, String thumbnail, LocalDateTime date, Side side1, Side side2,
			Competition competition, List<Video> videos) {
		super();
		this.title = title;
		this.embed = embed;
		this.url = url;
		this.thumbnail = thumbnail;
		this.date = date;
		this.side1 = side1;
		this.side2 = side2;
		this.competition = competition;
		this.videos = videos;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmbed() {
		return embed;
	}

	public void setEmbed(String embed) {
		this.embed = embed;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Side getSide1() {
		return side1;
	}

	public void setSide1(Side side1) {
		this.side1 = side1;
	}

	public Side getSide2() {
		return side2;
	}

	public void setSide2(Side side2) {
		this.side2 = side2;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(competition, date, embed, side1, side2, thumbnail, title, url, videos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Match)) {
			return false;
		}
		Match other = (Match) obj;
		return Objects.equals(competition, other.competition) && Objects.equals(date, other.date)
				&& Objects.equals(embed, other.embed) && Objects.equals(side1, other.side1)
				&& Objects.equals(side2, other.side2) && Objects.equals(thumbnail, other.thumbnail)
				&& Objects.equals(title, other.title) && Objects.equals(url, other.url)
				&& Objects.equals(videos, other.videos);
	}

	@Override
	public String toString() {
		return "Match [title=" + title + ", embed=" + embed + ", url=" + url + ", thumbnail=" + thumbnail + ", date="
				+ date + ", side1=" + side1 + ", side2=" + side2 + ", competition=" + competition + ", videos=" + videos
				+ "]";
	}
}
