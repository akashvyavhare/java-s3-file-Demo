package com.s3.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.s3.demo.service.S3Service;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;


@RestController
@RequestMapping("/")
public class RequestControoler {
	
	@Autowired
	private S3Service s3Service;
	
	@PostMapping("/upload")
	public String uploadObjectToS3(@RequestParam("file") MultipartFile multipartFile){
		try {
			boolean isUploaded = s3Service.saveObjectToS3(multipartFile);
			if(isUploaded) {
				return "Upload to S3 Successfully";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "Fial To upload on S3";
	}
	
	@GetMapping("/download")
	public ResponseEntity<?> downloadS3Object(@RequestParam("fileName") String objectKey) {
		try {
			ResponseInputStream<GetObjectResponse> response = s3Service.downloadObjectFromS3(objectKey);
			if(response!=null) {
				return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + objectKey + "\"")
						.contentType(MediaType.APPLICATION_OCTET_STREAM)
						.contentLength(response.response().contentLength()).body(response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().body("Fial to download File or Not Present..");
	}

	@GetMapping("/view")
	public ResponseEntity<?> viewS3Object(@RequestParam("fileName") String objectKey) {
		try {
			ResponseInputStream<GetObjectResponse> resp = s3Service.downloadObjectFromS3(objectKey);
			if(resp!=null) {
				GetObjectResponse response = resp.response();
				System.out.println(response);
				System.out.println(response.contentType());
				return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\"" + objectKey + "\"")
						.contentType(MediaType.parseMediaType(response.contentType()))
						.contentLength(response.contentLength()).body(resp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().body("Fial to download File or Not Present..");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
