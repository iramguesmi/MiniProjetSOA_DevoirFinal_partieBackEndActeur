package com.iram.acteur.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.iram.acteur.entitites.Film;
import com.iram.acteur.entitites.Acteur;

@RepositoryRestResource(path = "rest")
public interface ActeurRepository extends JpaRepository <Acteur, Long>{
	List<Acteur> findByNomActeur(String nom);
	List<Acteur> findByNomActeurContains(String nom);
	
	//@Query("select a from Acteur a where m.nom_acteur like %?1 and a.tel_acteur like %?2") 
	List<Acteur> findByNomActeurAndTelActeur (String nom, String tel);
	
	//@Query("select a from Acteur a where a.film = ?1") 
	List<Acteur> findByFilm (Film band);
	
	List<Acteur> findByFilmIdFilm(Long id);
	
	List<Acteur> findByOrderByNomActeurAsc();
	
	//@Query("select a from Acteur a order by a.nomActeur ASC, a.salaire DESC")
	/*List<Acteur> sortByNomActeurAndSalaireActeur ();*/
}
