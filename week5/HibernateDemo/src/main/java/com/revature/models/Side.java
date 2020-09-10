package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sides")
public class Side {

	@Id
	private String name;
	
	private String url;

	public Side() {
		super();
	}

	public Side(String name, String url) {
		super();
		this.name = name;
		this.url = url;
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
		return Objects.hash(name, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Side)) {
			return false;
		}
		Side other = (Side) obj;
		return Objects.equals(name, other.name) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Side [name=" + name + ", url=" + url + "]";
	}
}
