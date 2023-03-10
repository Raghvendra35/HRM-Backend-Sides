package com.employee.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.LeaveImageRepository;
import com.employee.entities.Employee;
import com.employee.entities.ImageAndFile;
import com.employee.entities.LeaveImage;

@Service
public class LeaveImageService 
{

	@Autowired
	private LeaveImageRepository leaveImageRepo;

	 @Value("${project.image}")
	 private String path;
	 
	 
	 
	// private final String FOLDER_PATH="C:\\Users\\Lenovo\\eclipse-workspace\\HRManagements\\src\\main\\resources\\LeaveFiles\\";		
	  
	 //Save Image
//	   public String uploadImageToFileSystem(MultipartFile file) throws IOException {
//	        String imageFilePath=FOLDER_PATH;//+file.getOriginalFilename();
//
//	        LeaveImage fileData=this.leaveImageRepo.save(LeaveImage.builder()
//	                .name(file.getOriginalFilename())
//	                .imageType(file.getContentType())
//	                .filePath(imageFilePath).build());
//
//	        file.transferTo(new File(imageFilePath));
//
//	        System.out.println("Inside Service ");
//	        
//	        if (fileData != null) {
//	            return "file uploaded successfully : " + imageFilePath;
//	        }
//	        return null;
//	    }

	
	 
	 
	 
	 
	 public String uploadImageToFileSystem(MultipartFile file) 
	 {
		 try
		 {
	        String imageFilePath=path;//+file.getOriginalFilename();
 
	         
	        
	        LeaveImage fileData=this.leaveImageRepo.save(LeaveImage.builder()
	                                     .name(file.getOriginalFilename())
	                                     .imageType(file.getContentType())
	                                     .filePath(imageFilePath).build());

	        File files=new File(imageFilePath);
	        
	        file.transferTo(files);

	         if(files.exists() && ! files.canWrite())
	         {
	        	 System.out.println("File exists and it is read only, making it writable");
	             files.setWritable(true);
	         }
	         
	         
	        
//	        if (fileData != null) {
//	            return "file uploaded successfully : " + imageFilePath;
//	        }
//	      
		 }catch(Exception e)  
		 {
			e.printStackTrace(); 
		 }
         return null;
	    }

	
	 
	 
	
	// fetch image
	   public byte[] downloadImageFormFileSystem(String imageName) throws IOException
	   {
		Optional<LeaveImage> fileData=this.leaveImageRepo.findByName(imageName);
		   String filePath=fileData.get().getFilePath();
		    byte[] images=Files.readAllBytes(new File(filePath).toPath());
		   return images;
	   }
	   
	
	 //Find by Id
		public byte[] findImageById(int id) throws IOException
		{
		 LeaveImage imageRec=this.leaveImageRepo.findById(id).get();
		 
           String file=imageRec.getFilePath();
           byte[] images=Files.readAllBytes(new File(file).toPath());
		// return imageRec.getFilePath();
		 return images;
			
			
		}
		
		
	
	
	
	    // get All Image
	      public List<LeaveImage> getAllImages()
		  {
		   
	     List<LeaveImage> list=(List<LeaveImage>) this.leaveImageRepo.findAll();
		 return list;
		  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //Save Image
//	   public LeaveImage uploadImageToFileSystem(String path, MultipartFile file) throws IOException 
//	   {
//		   LeaveImage leaveImage=new LeaveImage();
//		   
//		   String name=file.getOriginalFilename();
//		   String type=file.getContentType();
//		   
//		   leaveImage.setImageName(name);
//		   leaveImage.setImageType(type);
//		   
//		   String filePath=path+File.separator+name;
//		   File files=new File(path);
//		   
//		   if(!files.exists())
//		   {
//			   files.mkdir();
//		   }
//		   
//		    return this.leaveImageRepo.save(leaveImage);
//	   
//	      }   
//	   
	   
	   
		  // return file.getOriginalFilename(); 
		   
	 
//	        String imageFilePath=FOLDER_PATH+file.getOriginalFilename();
//
//	        LeaveImage fileData=this.leaveImageRepo.save(LeaveImage.builder()
//	                .imageName(file.getOriginalFilename())
//	                .imageType(file.getContentType())
//	                .filePath(imageFilePath).build());
//
//	        file.transferTo(new File(imageFilePath));
//
//	        System.out.println("Inside Service ");
//	        
//	        if (fileData != null) {
//	            return "file uploaded successfully : " + imageFilePath;
//	        }
//	        return null;
//	    }
	   
}
