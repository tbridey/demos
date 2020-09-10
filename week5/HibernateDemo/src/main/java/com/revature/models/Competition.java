package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitions")
public class Competition {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "competition_id")
	private int id;
	
	private String name;
	private String url;
	
	public Competition() {
		super();
	}

	public Competition(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Competition)) {
			return false;
		}
		Competition other = (Competition) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
}
