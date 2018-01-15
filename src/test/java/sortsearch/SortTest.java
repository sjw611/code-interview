package sortsearch;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {

	private Sort<Integer> sortingAlgorithm;

	private Integer[] original = Arrays.asList(3, 2, 1, 1, 5, 9, 8).toArray(new Integer[] {});
	
	private Integer[] sorted = Arrays.asList(1, 1, 2, 3, 5, 8, 9).toArray(new Integer[] {});

	@Test
	public void bubbleSort() {
		sortingAlgorithm = new BubbleSort<>();
		Integer[] array = original.clone();
		
		sortingAlgorithm.sort(array);
		
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void selectionSort() {
		sortingAlgorithm = new SelectionSort<>();
		Integer[] array = original.clone();
		
		sortingAlgorithm.sort(array);
		
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void insertionSort() {
		sortingAlgorithm = new InsertionSort<>();
		Integer[] array = original.clone();
		
		sortingAlgorithm.sort(array);
		
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void mergeSort() {
		sortingAlgorithm = new MergeSort<>();
		Integer[] array = original.clone();
		
		sortingAlgorithm.sort(array);
		
		assertArrayEquals(sorted, array);
	}

}
