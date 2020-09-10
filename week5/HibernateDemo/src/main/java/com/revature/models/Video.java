package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {

	private String title;
	
	@Id
	@Column(length = 1000)
	private String embed;
	
	public Video() {
		super();
	}

	public Video(String title, String embed) {
		super();
		this.title = title;
		this.embed = embed;
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

	@Override
	public int hashCode() {
		return Objects.hash(embed, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Video)) {
			return false;
		}
		Video other = (Video) obj;
		return Objects.equals(embed, other.embed) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Video [title=" + title + ", embed=" + embed + "]";
	}
}
