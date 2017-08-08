package arrstr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q7Test {

    private Q7 sut = new Q7();

    @Test(expected = NullPointerException.class)
    public void nullCheck() {
        sut.rotate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void squareCheck() {
        int[][] image = { { 1, 2 }, { 1 } };
        sut.rotate(image);
    }

    @Test
    public void rotateWidth4() {
        int[][] input = { { 1, 2, 3, 4 }, { 5, 4, 3, 2 }, { 1, 3, 5, 7 }, { 9, 8, 6, 2 } };

        int[][] output = { { 9, 1, 5, 1 }, { 8, 3, 4, 2 }, { 6, 5, 3, 3 }, { 2, 7, 2, 4 } };

        sut.rotate(input);

        assertTrue(Arrays.deepEquals(input, output));
    }

    @Test
    public void rotateWidth3() {
        int[][] input = { { 1, 2, 3 }, { 5, 4, 3 }, { 1, 3, 5 } };

        int[][] output = { { 1, 5, 1 }, { 3, 4, 2 }, { 5, 3, 3 } };

        sut.rotate(input);
        assertTrue(Arrays.deepEquals(input, output));
    }

    @Test
    public void rotateWidth2() {
        int[][] input = { { 1, 2 }, { 5, 4 } };

        int[][] output = { { 5, 1 }, { 4, 2 } };

        sut.rotate(input);
        assertTrue(Arrays.deepEquals(input, output));
    }
}
