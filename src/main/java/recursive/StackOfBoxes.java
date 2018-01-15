package recursive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class StackOfBoxes {

	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<>(
				List.of(new Box(5, 3, 6), new Box(1, 2, 3), new Box(1, 1, 2), new Box(2, 2, 3)));

		System.out.println(createStack(boxes));
	}

	public static int createStack(List<Box> boxes) {
		boxes.sort(Comparator.comparingInt(Box::getLength));

		int[] cache = new int[boxes.size()];

		return createStack(boxes, null, 0, cache);
	}

	private static int createStack(List<Box> boxes, Box bottom, int offset, int[] cache) {
		if (offset >= boxes.size()) {
			return 0;
		}

		Box newBottom = boxes.get(offset);

		int heightWithBottom = 0;

		if (bottom == null || newBottom.canBeAbove(bottom)) {
			if (cache[offset] == 0) {
				cache[offset] = createStack(boxes, newBottom, offset + 1, cache);
				cache[offset] += newBottom.height;
			}
			heightWithBottom = cache[offset];
		}

		int heightWithoutBottom = createStack(boxes, bottom, offset + 1, cache);

		return Math.max(heightWithBottom, heightWithoutBottom);
	}

	private static class Box {
		private final int length;
		private final int width;
		private final int height;

		private Box(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}

		public int getLength() {
			return length;
		}

		public boolean canBeAbove(Box another) {
			Objects.requireNonNull(another);

			return length > another.length && width > another.width && height > another.height;
		}
	}
}
