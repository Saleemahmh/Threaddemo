	package com.thread.demo1;
	class Hi1 implements Runnable{
		public void run(){
			
			for(int i=1;i<=5;i++){
			System.out.println("Hi");
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}
	}
		class Hello2 implements Runnable{
			public void run(){
				
				for(int i=1;i<=5;i++){
				System.out.println("Hello");
				try {Thread.sleep(500);} catch (Exception e) {}
			}
		}
		}
	public class Samplethread2 {

		public static void main(String[] args) {
			Hi1 obj1=new Hi1();
			Hello2 obj2=new Hello2();
			Thread t1=new Thread(obj1);
			Thread t2=new Thread(obj2);
			t1.start();
			try {Thread.sleep(10);} catch (Exception e) {}
			t2.start();
			
						
		}

	}
