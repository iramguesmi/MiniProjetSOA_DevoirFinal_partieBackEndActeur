package com.iram.acteur.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.iram.acteur.entitites.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;

	
	Image uplaodImageAct(MultipartFile file,Long idMus) throws IOException;
	List<Image> getImagesParAct(Long musId);

	

}