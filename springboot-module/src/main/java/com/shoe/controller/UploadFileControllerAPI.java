package com.shoe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileControllerAPI {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "user//dieunguyen";

	@CrossOrigin(origins = "*")
	@PostMapping("/upload-file") // //new annotation since 4.3
	public ResponseEntity<?> singleFileUpload(@RequestParam("filepond") MultipartFile file) {
		System.out.println("api upload file calling");
		ResponseEntity<?> responseEntity = new ResponseEntity<Object>(null, HttpStatus.OK);

		if (file.isEmpty()) {
			responseEntity = new ResponseEntity<Object>("Please select a file to upload", HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		responseEntity = new ResponseEntity<Object>("You successfully uploaded '" + file.getOriginalFilename(),
				HttpStatus.OK);
		return responseEntity;
	}
}