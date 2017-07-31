package lambda;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class Q7Test {

	private Q7 sut = new Q7();
	
	@Test
	public void emptyListOfCountries() {
		assertEquals(0, sut.getPopulation(Collections.<Country>emptyList(), "Asia"));
	}

	@Test(expected = NullPointerException.class)
	public void nullCheckCountries() {
		assertEquals(0, sut.getPopulation(null, "Asia"));
	}
	
	@Test(expected = NullPointerException.class)
	public void nullCheckContinent() {
		assertEquals(0, sut.getPopulation(Collections.<Country>emptyList(), null));
	}
	
	@Test
	public void singleton() {
		assertEquals(10, sut.getPopulation(Collections.<Country>singletonList(new Country("Asia", 10)), "Asia"));
	}
	
	@Test
	public void noMatch() {
		assertEquals(0, sut.getPopulation(Collections.<Country>singletonList(new Country("Europe", 10)), "Asia"));
	}
	
	@Test
	public void sumAllMatch() {
		assertEquals(13, sut.getPopulation(Arrays.asList(new Country("Asia", 1), new Country("Asia", 2), new Country("Asia", 10)), "Asia"));
	}
	
	@Test
	public void sumAllMatchCase() {
		assertEquals(13, sut.getPopulation(Arrays.asList(new Country("asia", 1), new Country("Asia", 2), new Country("Asia", 10)), "Asia"));
	}
	
	@Test
	public void sumSomeMatch() {
		assertEquals(11, sut.getPopulation(Arrays.asList(new Country("Asia", 1), new Country("Europe", 2), new Country("Asia", 10)), "Asia"));
	}
	
	@Test
	public void sumSomeMatchNullContry() {
		assertEquals(11, sut.getPopulation(Arrays.asList(new Country("Asia", 1), new Country(null, 2), new Country("Asia", 10)), "Asia"));
	}
}
