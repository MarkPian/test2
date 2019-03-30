package test;

public class TreadRun {

	public static void main(String[] args) {
		final MyThread myThread = new MyThread();

		// ×ÓÏß³Ì
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					myThread.subMethod();
				}
			}

		}).start();

		for (int i = 0; i < 3; i++) {
			myThread.mainMethod();
		}

		
	}
}
