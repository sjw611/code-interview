package arrstrings;

import java.util.Objects;

public class Q3 {
	public char[] urlify(char[] url, int trueLength) {
		Objects.requireNonNull(url);
		int pointer = trueLength - 1;
		
		for (int i = url.length - 1; i >= 0; --i) {
			if (url[pointer] == ' ') {
				url[i] = '0';
				url[i - 1] = '2';
				url[i - 2] = '%';
				i -= 2;
			} else {
				url[i] = url[pointer];
			}
			
			--pointer;
		}
		
		return url;
	}

}
