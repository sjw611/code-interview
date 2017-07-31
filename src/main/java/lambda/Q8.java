package lambda;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Q8 {
	public List<Integer> getRandomSubset(List<Integer> list) {
		Objects.requireNonNull(list);

		return list.stream().filter(i -> {
			return ThreadLocalRandom.current().nextBoolean();
		}).collect(Collectors.toList());
	}
}
