package com.iram.acteur.entitites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFilm;
	private String nomFilm;
	
	@JsonIgnore
	@OneToMany(mappedBy = "film")
	private List<Acteur> films;


	public Film(String nomFilm, List<Acteur> films) {
		super();
		this.nomFilm = nomFilm;
		this.films = films;
	}



	public Film() {
		super();
	}
	
	

}
