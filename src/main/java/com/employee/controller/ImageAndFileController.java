package com.employee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.service.ImageAndFileService;

@RestController
@RequestMapping("api/")
public class ImageAndFileController
{
	
		 
	@Autowired
	private ImageAndFileService imageAndFileService;
	
	//Save Image
	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = this.imageAndFileService.uploadImageToFileSystem(file);
		
		System.out.println("Inside Controller ");
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	
	
	
	
	
	//Get Image
	
	@GetMapping("/fileSystem/{imageId}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable long imageId) throws IOException {
		byte[] imageData=this.imageAndFileService.downloadImageFromFileSystem(imageId);
		
		return ResponseEntity.status(HttpStatus.OK)
//				.contentType(MediaType.valueOf("image/int"))
				.contentType(MediaType.ALL)
				.body(imageData);

	}

}
