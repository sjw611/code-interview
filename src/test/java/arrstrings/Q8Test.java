package arrstrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q8Test {

    private Q8 sut = new Q8();

    @Test
    public void twoDMatrix() {
        int[][] matrix = { { 1, 0 }, { 2, 1 } };

        int[][] output = { { 0, 0 }, { 2, 0 } };

        sut.zeroMatrix(matrix);

        assertTrue(Arrays.deepEquals(output, matrix));
    }

    @Test
    public void threeDMatrix() {
        int[][] matrix = { { 1, 2, 3 }, { 0, 4, 3 }, { 1, 3, 0 } };

        int[][] output = { { 0, 2, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        sut.zeroMatrix(matrix);

        assertTrue(Arrays.deepEquals(output, matrix));
    }

}
