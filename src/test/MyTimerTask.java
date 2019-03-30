package test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	private static volatile int count = 1 ;
	
	@Override
	public void run() {
		count = (count + 1) % 2;
		System.out.println("Boom");
		new Timer().schedule(new MyTimerTask(), 2000 + (2000*count));

	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 2000+(2000*count));
		
		while(true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);	
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
