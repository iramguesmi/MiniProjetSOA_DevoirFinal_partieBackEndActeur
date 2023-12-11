package com.iram.acteur;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iram.acteur.entitites.Film;
import com.iram.acteur.entitites.Acteur;
import com.iram.acteur.repos.ActeurRepository;

@SpringBootTest
class ActeurApplicationTests {

	@Autowired
	private ActeurRepository acteurRepository;

	@Test
	public void testCreateActeur() {
		Acteur a = new Acteur("test", "test", 1300.00, 6);
		acteurRepository.save(a);
	}

	@Test
	public void testFindActeur() {
		Acteur a = acteurRepository.findById(1L).get();
		System.out.println(a);
	}

	@Test
	public void testUpdateActeur() {
		Acteur a = acteurRepository.findById(1L).get();
		a.setSalaireActeur(1000.0);
		acteurRepository.save(a);
	}

	@Test
	public void testDeleteActeur() {
		acteurRepository.deleteById(2L);
		;
	}

	@Test
	public void testListerTousActeurs() {
		List<Acteur> acteurs = acteurRepository.findAll();
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}

	@Test
	public void testFindByNomActeur() {
		List<Acteur> musiciens = acteurRepository.findByNomActeur("test");
		for (Acteur m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByNomActeurContains() {
		List<Acteur> acteurs = acteurRepository.findByNomActeurContains("test");
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}

	@Test
	public void testFindByTelActeur() {
		List<Acteur> acteurs = acteurRepository.findByNomActeurAndTelActeur("test", "testr");
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}

	@Test
	public void testFindByFilm() {
		Film film = new Film();
		film.setIdFilm(1L);
		List<Acteur> acteur = acteurRepository.findByFilm(film);
		for (Acteur a : acteur) {
			System.out.println(a);
		}
	}

	@Test
	public void testFindByFimIdFilm() {
		List<Acteur> acteurs = acteurRepository.findByFilmIdFilm(1L);
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}

	@Test
	public void testFindByOrderByNomActeurAsc() {
		List<Acteur> acteurs = acteurRepository.findByOrderByNomActeurAsc();
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}
/*
	@Test
	public void testTrierMusiciensNomsSalaire() {
		List<Acteur> acteurs = acteurRepository.sortByNomActeurAndSalaireActeur();
		for (Acteur a : acteurs) {
			System.out.println(a);
		}
	}
	*/
}
