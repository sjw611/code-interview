package recursive;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class PowerSetTest {

	private PowerSet sut = new PowerSet();
	
	@Test
	public void test() {
		System.out.println(sut.enumerate(new HashSet<>()));
		System.out.println(sut.enumerate(new HashSet<>(Arrays.asList(1))));
		System.out.println(sut.enumerate(new HashSet<>(Arrays.asList(1, 2))));
		System.out.println(sut.enumerate(new HashSet<>(Arrays.asList(1, 2, 3))));
		System.out.println(sut.enumerate(new HashSet<>(Arrays.asList(1, 2, 3, 4))));
	}

}
