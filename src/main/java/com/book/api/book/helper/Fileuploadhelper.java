package com.book.api.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Fileuploadhelper {
	public final String UPLOAD_DIR ="C:\\Users\\risha\\Downloads\\book\\src\\main\\resources\\static\\image";
	public boolean uploadFile(MultipartFile multipartFile) 
	{
		boolean f= true;
		
		try {
			multipartFile.getInputStream();
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}
