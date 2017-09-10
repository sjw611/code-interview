package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	private Fibonacci sut = new Fibonacci();
	
	@Test(expected = IllegalArgumentException.class)
	public void negative() {
		sut.fib(-1);
	}

	@Test
	public void fib() {
		assertEquals(1, sut.fib(1));
		assertEquals(1, sut.fib(2));
		assertEquals(2, sut.fib(3));
		assertEquals(3, sut.fib(4));
		assertEquals(5, sut.fib(5));
		assertEquals(8, sut.fib(6));
		assertEquals(13, sut.fib(7));
		assertEquals(21, sut.fib(8));
		assertEquals(34, sut.fib(9));
		assertEquals(55, sut.fib(10));
	}
}
