package com.employee.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.ImageAndFileRepository;
import com.employee.entities.ImageAndFile;

@Service
public class ImageAndFileService
{

	@Autowired
	private ImageAndFileRepository imageAndFileRepo;
	
	// private final String FOLDER_PATH="C:\\Users\\Lenovo\\eclipse-workspace\\HRManagements\\src\\main\\resources\\MyFiles\\";
	 
	 @Value("${project.image}")
	 private String path;
		
	  //Save Image
	   public String uploadImageToFileSystem(MultipartFile file) throws IOException {
	        String imageFilePath=path+file.getOriginalFilename();

	        ImageAndFile fileData=this.imageAndFileRepo.save(ImageAndFile.builder()
	                .name(file.getOriginalFilename())
	                .imageType(file.getContentType())
	                .filePath(imageFilePath).build());

	        file.transferTo(new File(imageFilePath));

	        System.out.println("Inside Service ");
	        
	        if (fileData != null) {
	            return "file uploaded successfully : " + imageFilePath;
	        }
	        return null;
	    }

	   
	   

	   
	   
	   //Fetch Image

	    public byte[] downloadImageFromFileSystem(long imageId) throws IOException {
	        Optional<ImageAndFile> fileData =this.imageAndFileRepo.findById(imageId);
	        String filePath=fileData.get().getFilePath();
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        return images;
	    }
}
