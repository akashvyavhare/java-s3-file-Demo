package com.s3.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSConfiguration {

    @Bean
    S3Client getS3Client() {
		return S3Client.builder().region(Region.US_EAST_1).credentialsProvider(ProfileCredentialsProvider.create("akash-admin")).build();
	}
}
