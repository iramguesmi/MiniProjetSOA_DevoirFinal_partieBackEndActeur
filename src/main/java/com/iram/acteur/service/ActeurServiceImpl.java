package com.iram.acteur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iram.acteur.entitites.Film;
import com.iram.acteur.entitites.Image;
import com.iram.acteur.entitites.Acteur;
import com.iram.acteur.repos.ImageRepository;
import com.iram.acteur.repos.ActeurRepository;

@Service
public class ActeurServiceImpl implements ActeurService {

	@Autowired
	ActeurRepository acteurRepository;
	
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Acteur saveActeur(Acteur m) {
		return acteurRepository.save(m);
	}

	@Override
	public Acteur updateActeur(Acteur m) {
		return acteurRepository.save(m);
	}

	@Override
	public void deleteActeur(Acteur m) {
		acteurRepository.delete(m);
	}

	

	@Override
	public Acteur getActeur(Long id) {
		return acteurRepository.findById(id).get();
	}

	@Override
	public List<Acteur> getAllActeur() {
		return acteurRepository.findAll();
	}

	@Override
	public List<Acteur> findByNomActeur(String nom) {
		return acteurRepository.findByNomActeur(nom);
	}

	@Override
	public List<Acteur> findByNomActeurContains(String nom) {
		return acteurRepository.findByNomActeurContains(nom);
	}

	@Override
	public List<Acteur> findByNomActeurAndTelActeur(String nom, String tel) {
		return acteurRepository.findByNomActeurAndTelActeur(nom, tel);
	}

	@Override
	public List<Acteur> findByFilm(Film film) {
		return acteurRepository.findByFilm(film);
	}

	@Override
	public List<Acteur> findByFilmIdFilm(Long id) {
		return acteurRepository.findByFilmIdFilm(id);
	}

	@Override
	public List<Acteur> findByOrderByNomActeurtAsc() {
		return acteurRepository.findByOrderByNomActeurAsc();
	}
	/*
	@Override
	public List<Acteur> sortByNomActeurAndSalaireActeur() {
		return acteurRepository.sortByNomActeurAndSalaireActeur();
	}
	*/
	
	@Override
	public void deleteActeurById(Long id) {
	    Acteur plat = acteurRepository.findById(id).orElse(null);

	    if (plat != null) {
	        
	        List<Image> images = plat.getImages();
	        if (images != null) {
	            for (Image image : images) {
	         
	                imageRepository.deleteById(image.getIdImage()); 
	            }
	        }

	        acteurRepository.deleteById(id);
	    }
	}

	

}
