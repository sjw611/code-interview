package arrstr;

import java.util.Objects;

public class Q8 {

    public void zeroMatrix(int[][] matrix) {
        Objects.requireNonNull(matrix);

        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
