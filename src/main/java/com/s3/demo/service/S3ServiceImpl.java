package com.s3.demo.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3ServiceImpl implements S3Service{

	@Autowired
	private S3Client s3Client;
	
	private String s3BucketName = "java-s3-demo-akash";
	
	@Override
	public boolean saveObjectToS3(MultipartFile file) {
		try {
			PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(s3BucketName).key(file.getOriginalFilename()).build();
			s3Client.putObject(putObjectRequest,RequestBody.fromBytes(file.getBytes()) );
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteObjectFromS3(String objectKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResponseInputStream<GetObjectResponse> downloadObjectFromS3(String objectKey) {
		try {
			GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(s3BucketName).key(objectKey).build();
			ResponseInputStream<GetObjectResponse> response = s3Client.getObject(getObjectRequest);
			return response;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void updateS3Object(String objectUpdateKey, MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

}
