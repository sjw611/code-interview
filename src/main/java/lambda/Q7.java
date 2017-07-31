package lambda;

import java.util.List;
import java.util.Objects;

public class Q7 {
	public int getPopulation(List<Country> countries, String continent) {
		Objects.requireNonNull(countries);
		Objects.requireNonNull(continent);

		return countries.stream()
				.filter(c -> continent.equalsIgnoreCase(c.getContinent()))
				.mapToInt(Country::getPopulation)
				.sum();
	}
}
