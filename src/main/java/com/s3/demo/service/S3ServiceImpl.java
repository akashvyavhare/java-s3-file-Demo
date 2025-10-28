package com.s3.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3ServiceImpl implements S3Service{

	@Override
	public boolean saveObjectToS3(MultipartFile file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteObjectFromS3(String objectKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void downloadObjectFromS3(String objectKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateS3Object(String objectUpdateKey, MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

}
