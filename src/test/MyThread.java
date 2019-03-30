package test;

public class MyThread {

	private boolean flag = true;

	public synchronized void mainMethod() {

		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": main thread running loop count -- " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		flag = true;
		notify();
	}

	public synchronized void subMethod() {

		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": subMethod running loop count --" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		flag = false;
		notify();
	}

}
