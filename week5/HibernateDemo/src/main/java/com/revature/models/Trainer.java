package com.revature.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({
	// uses HQL
	@NamedQuery(name = "getAll", query = "FROM Trainer"),
	@NamedQuery(name = "getByType", query = "FROM Pokemon p WHERE p.type = :type")
})

@Entity
@Table(name = "trainers")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;

	@OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER)
	private Set<Pokemon> party;

	public Trainer() {
		super();
	}

	public Trainer(int id, String name, Set<Pokemon> party) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
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

	public Set<Pokemon> getParty() {
		return party;
	}

	public void setParty(Set<Pokemon> party) {
		this.party = party;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, party);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Trainer)) {
			return false;
		}
		Trainer other = (Trainer) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(party, other.party);
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", party=" + party + "]";
	}
}
