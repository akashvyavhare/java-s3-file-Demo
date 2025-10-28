package com.s3.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/")
public class RequestControoler {
	
	@GetMapping("/upload")
	public String uploadObjectToS3(@RequestParam MultipartFile multipartFile){
		
		return "";
	}

}
