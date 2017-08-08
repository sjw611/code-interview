package arrstrings;

import java.util.Objects;

public class Q5 {

    public boolean isOneEditAway(String src, String dest) {
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);

        if (src.equals(dest)) {
            return true;
        }

        if (isInsertOrDelete(src, dest)) {
            return true;
        }

        return isMod(src, dest);
    }

    private boolean isMod(String src, String dest) {
        if (src.length() != dest.length()) {
            return false;
        }
        boolean oneEditReached = false;

        for (int i = 0; i < src.length(); ++i) {
            if (src.charAt(i) != dest.charAt(i)) {
                if (oneEditReached) {
                    return false;
                }
                oneEditReached = true;
            }
        }
        return true;
    }

    private boolean isInsertOrDelete(String src, String dest) {
        String shorter = src.length() <= dest.length() ? src : dest;
        String longer = src.length() > dest.length() ? src : dest;

        if (shorter.length() + 1 != longer.length()) {
            return false;
        }

        boolean oneEditReached = false;
        int longerPointer = 0;

        for (int i = 0; i < shorter.length(); ++i) {
            if (longer.charAt(longerPointer) != shorter.charAt(i)) {
                if (oneEditReached) {
                    return false;
                }
                oneEditReached = true;
                ++longerPointer;
            }
            ++longerPointer;
        }
        return true;
    }
}
