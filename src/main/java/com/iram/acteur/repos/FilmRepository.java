package com.iram.acteur.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iram.acteur.entitites.Film;

@RepositoryRestResource(path = "film")
@CrossOrigin("http://localhost:4200/")
public interface FilmRepository extends JpaRepository<Film, Long>{

	List<Film> findAll();
	
	
	
}
