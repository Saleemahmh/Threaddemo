package com.thread.fileapp;

public class DownloaderApp {

	public static void main(String[] args) {
		//Image URLs
		String[] imageToDownload=new String[]{
				"https://image.freepik.com/free-vector/technological-background-with-blue-geometric-shapes_1035-6896.jpg",
				"https://cdn.pixabay.com/photo/2016/09/26/11/58/background-1695798_960_720.jpg",
				"https://image.freepik.com/free-vector/colorful-abstract-background_1207-180.jpg",
				"https://s-media-cache-ak0.pinimg.com/736x/3a/69/89/3a69891eb17c1dbdf74a2e78d9a7a4a5.jpg",
				 "https://thumbs.dreamstime.com/t/fond-en-bois-d-arc-en-ciel-38903873.jpg",
			     "https://s-media-cache-ak0.pinimg.com/originals/c5/1f/00/c51f00a9d342c2ed8aba521d46e3bbe7.jpg",
			     "https://image.freepik.com/free-vector/shiny-diamond-shape-abstract-background_1017-4015.jpg",
			     "https://image.freepik.com/free-vector/technological-background-with-a-circuit_1035-4297.jpg",
			     "https://image.freepik.com/free-vector/technological-background-with-a-futuristic-circuit_1035-4303.jpg",
			     "https://s-media-cache-ak0.pinimg.com/736x/e6/e0/75/e6e0753d99a3a55391974d8da821f546.jpg"
		};
		String destinationFolder="C:\\Users\\saleem\\Documents\\pics\\";
		
		try{
			int nameIndex=0;
			long startTime=0;
			long endTime=0;
		
		//Download images in this thread
		System.out.println("Downloading" +imageToDownload.length+"images with single thread");
		startTime=System.currentTimeMillis();
		for(String url:imageToDownload){
			 new ImageDownloader(url,destinationFolder + "single" + (nameIndex++) + ".jpg").download();
		}
		endTime=System.currentTimeMillis();
		System.out.println("\tdownload time:" + (endTime-startTime)+ "ms");
		//Download images in multiple threads
		nameIndex=0;
		Lock lock=new Lock();//A lock object to synchronize threads on it
		System.out.println("Downloading" +imageToDownload.length+ "images with multiple threads");
		startTime=System.currentTimeMillis();
		for(String url:imageToDownload){
			DownloadThread dt=new DownloadThread(url, destinationFolder + "multiple" + (nameIndex++) + ".jpg",lock);
			dt.start();//Start download in another thread
		}
		while(lock.getRunningThreadsNumber()>0){
			synchronized(lock){
				lock.wait();
			}
			endTime=System.currentTimeMillis();
			System.out.println("\tdownload time:" + (endTime-startTime)+ "ms");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

}
