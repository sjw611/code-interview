package recursive;

import java.math.BigDecimal;

public class TripleStep {
	public BigDecimal count(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		BigDecimal a = BigDecimal.ONE;
		BigDecimal b = BigDecimal.ONE;
		BigDecimal c = BigDecimal.valueOf(2);
		BigDecimal d = BigDecimal.ZERO;

		for (int i = 1; i <= n; ++i) {
			d = a.add(b).add(c);
			a = b;
			b = c;
			c = d;
		}
		return a;
	}
}
