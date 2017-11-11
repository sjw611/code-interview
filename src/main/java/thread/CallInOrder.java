package thread;

import java.util.concurrent.Semaphore;

public class CallInOrder {

	public static void main(String[] args) {
		CallInOrder app = new CallInOrder();
		CallInOrder.Foo foo = app.new Foo();
		new Thread(app.new Runner1(foo)).start();
		new Thread(app.new Runner2(foo)).start();
		new Thread(app.new Runner3(foo)).start();
	}

	private class Runner1 implements Runnable {

		private Foo foo;

		public Runner1(Foo foo) {
			this.foo = foo;
		}

		@Override
		public void run() {
			foo.first();
		}
	}

	private class Runner2 implements Runnable {

		private Foo foo;

		public Runner2(Foo foo) {
			this.foo = foo;
		}

		@Override
		public void run() {
			foo.second();
		}
	}

	private class Runner3 implements Runnable {

		private Foo foo;

		public Runner3(Foo foo) {
			this.foo = foo;
		}

		@Override
		public void run() {
			foo.third();
		}
	}

	private class Foo {
		private Semaphore semaphore1;
		private Semaphore semaphore2;

		public Foo() {
			semaphore1 = new Semaphore(1);
			semaphore2 = new Semaphore(1);
			try {
				semaphore1.acquire();
				semaphore2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void first() {
			try {
				Thread.sleep(1000L);
				semaphore1.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("First");
		}

		private void second() {
			try {
				semaphore1.acquire();
				semaphore1.release();
				Thread.sleep(10L);
				semaphore2.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Second");
		}

		private void third() {
			try {
				semaphore2.acquire();
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Third");
		}
	}

}
