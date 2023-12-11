package com.iram.acteur.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iram.acteur.entitites.Image;
import com.iram.acteur.entitites.Acteur;
import com.iram.acteur.repos.ImageRepository;
import com.iram.acteur.repos.ActeurRepository;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {
	
	 @Autowired
	 ImageRepository imageRepository;


	 @Autowired
	 ActeurService acteurService;
	 
	 @Autowired
	 ActeurRepository acteurRepository;
	 
		@Override
		public Image uplaodImage(MultipartFile file) throws IOException {
			/*
			 * Ce code commenté est équivalent au code utilisant le design pattern Builder
			 * Image image = new Image(null, file.getOriginalFilename(),
			 * file.getContentType(), file.getBytes(), null);
			 *   return imageRepository.save(image);
			 */
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).build());
		}

		@Override
		public Image getImageDetails(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return Image.builder()
					.idImage(dbImage
					.get().getIdImage()).name(dbImage.get().getName())
					.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
		}

		@Override
		public ResponseEntity<byte[]> getImage(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
					.body(dbImage.get().getImage());
		}

		@Override
		public void deleteImage(Long id) {
			imageRepository.deleteById(id);
		}

		@Override
		public Image uplaodImageAct(MultipartFile file,Long idAct) 
		throws IOException {
				Acteur a = new Acteur();
				a.setIdActeur(idAct);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .acteur(a).build() );
		}

		@Override
		public List<Image> getImagesParAct(Long actId) {
			Acteur a = acteurRepository.findById(actId).get();
				return a.getImages();
		}

		
		
		
		
		
	}