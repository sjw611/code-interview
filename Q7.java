package arrstr;

import java.util.Arrays;
import java.util.Objects;

public class Q7 {
    public int[][] rotate(int[][] image) {
        inputValidation(image);

        return rotateClockwise(image);
    }

    private int[][] rotateClockwise(int[][] image) {
        int length = image.length;

        int half = length >> 1;

        for (int i = 0; i < half; ++i) {
            for (int j = 0; j < (length % 2 == 0 ? half : half + 1); ++j) {
                swap(image, i, j, j, length - 1 - i);
                swap(image, i, j, length - 1 - i, length - 1 - j);
                swap(image, i, j, length - 1 - j, i);
            }

        }

        return image;
    }

    void print(int[][] image) {

        System.out.println("****");

        for (int i = 0; i < image.length; ++i) {
            System.out.println(Arrays.toString(image[i]));
        }

        System.out.println("****");
    }

    private void swap(int[][] image, int fromX, int fromY, int toX, int toY) {
        int tmp = image[fromX][fromY];
        image[fromX][fromY] = image[toX][toY];
        image[toX][toY] = tmp;
    }

    private void inputValidation(int[][] image) {
        Objects.requireNonNull(image);

        int height = image.length;

        for (int[] row : image) {
            if (row.length != height) {
                throw new IllegalArgumentException("Height " + height + " Width " + row.length + " do not match");
            }
        }
    }
}
