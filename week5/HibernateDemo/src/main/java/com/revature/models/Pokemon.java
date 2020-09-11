package com.revature.models;

import java.util.Objects;

public class Pokemon {

	private int id;
	private String name;
	private String type;
	private Trainer trainer;
	
	public Pokemon() {
		super();
	}

	public Pokemon(int id, String name, String type, Trainer trainer) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.trainer = trainer;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pokemon)) {
			return false;
		}
		Pokemon other = (Pokemon) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
