package com.global.hr.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.global.hr.error.FileStorageException;


@Service
public class FileUploadService {
	Logger log = LoggerFactory.getLogger(FileUploadService.class);
	private Path fileStorageLocation;
	@Value("${file.upload.base-path}")
	private final String basePath = "";
	
	public File convertMultipartToFile(MultipartFile multipartFile) {
	    // Create a new File object using the original filename
	    File convFile = new File(multipartFile.getOriginalFilename());
	    
	    // Transfer the content of the multipart file to the new file
	    try (final FileOutputStream outputStream = new FileOutputStream(convFile)){
	    	outputStream.write(multipartFile.getBytes());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return convFile;
	}
	
	
	public String storeFile (File file , Long id , String pathType) {
		try {
	        // base directory (تقدر تغيره حسب مشروعك)
			this.fileStorageLocation = Paths.get(basePath + pathType).toAbsolutePath().normalize();

	        // create folder based on pathType
			try {
	        Files.createDirectories(this.fileStorageLocation);
			}catch (Exception e) {
				throw new FileStorageException("Could not create directory ... " +e);
			}

	        // get original file name + extension
	        String fileName = StringUtils.cleanPath(id+"-"+file.getName());
	        Path targetLocation = this.fileStorageLocation.resolve(fileName);
	        InputStream targetStream = new FileInputStream(file);
	        Files.copy(targetStream,targetLocation, StandardCopyOption.REPLACE_EXISTING);
	        return fileName;

	    } catch (Exception e) {
	        throw new RuntimeException("Error while storing file", e);
	    }
	}
}
