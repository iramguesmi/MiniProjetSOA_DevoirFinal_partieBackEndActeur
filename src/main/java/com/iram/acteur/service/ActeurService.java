package com.iram.acteur.service;

import java.util.List;

import com.iram.acteur.entitites.Film;
import com.iram.acteur.entitites.Acteur;



public interface ActeurService {
	Acteur saveActeur(Acteur m);
	Acteur updateActeur(Acteur m);
	void deleteActeur(Acteur m);
	void deleteActeurById(Long id);
	Acteur getActeur(Long id);
	List<Acteur> getAllActeur();
	List<Acteur> findByNomActeur(String nom);
	List<Acteur> findByNomActeurContains(String nom);
	List<Acteur> findByNomActeurAndTelActeur (String nom, String tel);
	List<Acteur> findByFilm (Film film);
	List<Acteur> findByFilmIdFilm(Long id);
	List<Acteur> findByOrderByNomActeurtAsc();
	/*List<Acteur> sortByNomActeurAndSalaireActeur();*/
	
	
	
}
