package model;

import java.util.Calendar;

import gui.DisplayGui;

public class DisplayController {

	private DisplayGui display;
	
	public static void main(String[] args) {
		new DisplayController();
	}
	
	public DisplayController() {
		display = new DisplayGui();
		startHourThread();
	}

	private void startHourThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					display.setHour(Clock.getHourStringFromDate(Calendar.getInstance().getTime()));	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
	}
}
