package com.iram.acteur.entitites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data

@Entity
public class Acteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idActeur;
	private String nomActeur;
	private String telActeur;
	private double salaireActeur;
	private int rateActeur;
	
	/*@OneToOne
	private Image image; */
	
	@OneToMany (mappedBy = "acteur")
	 private List<Image> images;
	 
	 private String imagePath;
	
	@ManyToOne
	private Film film;
	
	public Acteur(String nomActeur, String telActeur, double salaireActeur, int rateActeur) {
		super();
		this.nomActeur = nomActeur;
		this.telActeur = telActeur;
		this.salaireActeur = salaireActeur;
		this.rateActeur = rateActeur;
	}

	@Override
	public String toString() {
		return "Acteur [idActeur=" + idActeur + ", nomActeur=" + nomActeur + ", telActeur=" + telActeur
				+ ", salaireActeur=" + salaireActeur + ", rateActeur=" + rateActeur + "]";
	}

	public Acteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

}


