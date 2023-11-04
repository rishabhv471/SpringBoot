package com.book.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.api.book.helper.Fileuploadhelper;

//import Fileuploadhelper.Fileuploadhelper;

@RestController
public class FileUploadController {
	@Autowired
	private Fileuploadhelper fileuploadhelper;
	
	@PostMapping("/upload-file")
	 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	 {
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());
		try 
		{
			if (file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			
			if (!file.getContentType().equals("image/jpeg"))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg allowed");
			}
			
			boolean f = fileuploadhelper.uploadFile(file);
			if (f) 
			{
				return ResponseEntity.ok("File is uploaded");
			}

		}catch (Exception e) {
				e.printStackTrace();
			}
 //else
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMEHING WENT WRONG");
		
	 }
}
