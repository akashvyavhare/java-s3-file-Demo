package com.s3.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

	boolean saveObjectToS3(MultipartFile file);
	
	boolean deleteObjectFromS3(String objectKey);
	
	void downloadObjectFromS3(String objectKey);
	
	void updateS3Object(String objectUpdateKey, MultipartFile file);
}
