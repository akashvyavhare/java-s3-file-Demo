package com.s3.demo.service;

import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;


public interface S3Service {

	boolean saveObjectToS3(MultipartFile file);
	
	boolean deleteObjectFromS3(String objectKey);
	
	ResponseInputStream<GetObjectResponse> downloadObjectFromS3(String objectKey);
	
	void updateS3Object(String objectUpdateKey, MultipartFile file);
}
