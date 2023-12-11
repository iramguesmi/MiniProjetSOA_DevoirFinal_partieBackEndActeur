package com.iram.acteur.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iram.acteur.entitites.Acteur;
import com.iram.acteur.service.ActeurService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class ActeurRESTController {

	@Autowired(required = true)
	ActeurService acteurService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Acteur> getAllActeur() {
		return acteurService.getAllActeur();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Acteur getActeurById(@PathVariable("id") Long id) {
		return acteurService.getActeur(id);
	}

	@RequestMapping(value="/addAct",method = RequestMethod.POST)
	public Acteur createMusicien(@RequestBody Acteur acteur) {
		return acteurService.saveActeur(acteur);
	}

	@RequestMapping(value="/updateAct",method = RequestMethod.PUT)
	public Acteur updateActeur(@RequestBody Acteur acteur) {
		return acteurService.updateActeur(acteur);
	}

	@RequestMapping(value = "/delAct/{id}", method = RequestMethod.DELETE)
	public void deleteActeurById(@PathVariable("id") Long id) {
		acteurService.deleteActeurById(id);
	}

	@RequestMapping(value = "/films/{idFilm}", method = RequestMethod.GET)
	public List<Acteur> findByFilmIdFilm(@PathVariable("idFilm") Long idFilm) {
		return acteurService.findByFilmIdFilm(idFilm);
	}

	@RequestMapping(value = "/actByName/{nom}", method = RequestMethod.GET)
	public List<Acteur> findByNomMusicienContains(@PathVariable("nom") String nom) {
		return acteurService.findByNomActeurContains(nom);
	}
}
