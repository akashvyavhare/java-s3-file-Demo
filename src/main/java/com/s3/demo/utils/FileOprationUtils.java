package com.s3.demo.utils;

import org.springframework.http.MediaType;

public class FileOprationUtils {
	
	public static String getFileMediaType(String fileName) {
		String[] fileNameSplit = fileName.split("\\.");
		String fileExtension = fileNameSplit[fileNameSplit.length-1];
		switch (fileExtension) {
			case "pdf": {
				return MediaType.APPLICATION_PDF_VALUE;
			}
			case("xlsx"):{
				return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
			}
			case("xls"):{
				return "application/vnd.ms-excel";
			}
			case("jpeg"):{
				return MediaType.IMAGE_JPEG_VALUE;
			}
			case("png"):{
				return MediaType.IMAGE_PNG_VALUE;
			}
			default:{
				return MediaType.APPLICATION_OCTET_STREAM_VALUE;
			}
		}

	}
}
