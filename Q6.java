package arrstr;

import java.util.Objects;

public class Q6 {

    public String compress(String input) {
        Objects.requireNonNull(input);
        
        StringBuilder sb = new StringBuilder();
        
        char prev = ' ';
        
        for (char c : input.toCharArray()) {
            int prevOutputLocation = sb.length() - 1;
            if (c == prev) {
                sb.setCharAt(prevOutputLocation, (char) ((int) sb.charAt(prevOutputLocation) + 1));
            } else {
                sb.append(c).append(1);
            }
            prev = c;
        }
        
        String output = sb.toString();
        
        return output.length() < input.length() ? output : input;
    }
}
