package com.thread.fileapp;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {
	//Image path
	private String imageUrl;
	//Destination local path
	private String destinationPath;
	public ImageDownloader(String imageUrl, String destinationPath) {
		this.imageUrl = imageUrl;
		this.destinationPath = destinationPath;
	}
	
		public void download() throws Exception {
	        // Open connection to the image
	        URL url = new URL(imageUrl);
	        InputStream is = url.openStream();
	        // Stream to the destination file
	        FileOutputStream fos = new FileOutputStream(destinationPath);
	 
	        // Read bytes from URL to the local file
	        byte[] buffer = new byte[4096];
	        int bytesRead = 0;
	        while ((bytesRead = is.read(buffer)) != -1)
	            fos.write(buffer,0,bytesRead);
	 
	        // Close destination stream
	        fos.close();
	        // Close URL stream
	        is.close();
	    }
		                                        
}
