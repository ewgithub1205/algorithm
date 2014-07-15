package sort;

public class HeapSort {
	public static void main(String[] args) {
		int arry[] = { 10, 11, 0, 20, 19, 101, 999, 100, 299, 33, 45, 67, 89,
				13, 14, 17, 56, 78, 55, 443, 33, 6, 3445, 345, 345, 345, 34532,
				2346, 4356, 56464, 56, 88 };
		buildWholeHeapTree(arry);
		// printTree(arry);
		sortTopHeap(arry);
		printTree(arry);
	}

	/**
	 * build the heap for the indexed parent node
	 * 
	 * @param data
	 *            Array for sorting.
	 * @param heapSize
	 *            The unIndexed heap size
	 * @param index
	 *            The last unIndexed parent node
	 */
	public static void buildSubMaxHeap(int[] data, int heapSize, int index) {

		int left = (index << 1) + 1;
		int right = (index << 1) + 2;
		// Try to find the larger node in it's sub node.
		int largeIndex = index;

		if (left < heapSize && data[index] < data[left]) {
			largeIndex = left;
		}

		if (right < heapSize && data[largeIndex] < data[right]) {
			largeIndex = right;
		}
		// if there is large node under index ,then swap it!!!
		if (largeIndex != index) {
			swap(data, index, largeIndex);
			// After we swap the index and largeIndex, we need to re-build the
			// max heap for largeIndex node. actually the heapSize is not
			// changed!!!!
			buildSubMaxHeap(data, heapSize, largeIndex);
		}

	}

	/**
	 * Sort the heap ,swap the top to the bottom ,and rebuild the heap.
	 * 
	 * @param data
	 *            Data for sorting.
	 */
	public static void sortTopHeap(int[] data) {
		for (int i = data.length - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			// After we swap the top heap to the last node,we need to re-build
			// the heap for the top!!!!
			buildSubMaxHeap(data, i, 0);
		}

	}

	public static void swap(int[] data, int from, int to) {

		int temp = data[to];
		data[to] = data[from];
		data[from] = temp;
	}

	public static void buildWholeHeapTree(int[] data) {
		// I think this should plus 2 instead of 1
		int lastParentNodeIndex = (data.length - 2) >> 1;

		for (int i = lastParentNodeIndex; i >= 0; i--) {
			buildSubMaxHeap(data, data.length, i);
		}

	}

	public static void printTree(int[] data) {
		System.out.println("----------------------------");
		int temp = -2;
		int lines = (int) ((Math.log(data.length)) / (Math.log(2)));
		for (int i = 0; i < data.length; i++) {
			int log = (int) (Math.log(i + 1) / Math.log(2));
			if (log > temp) {
				temp = log;
				System.out.println();
			}
			for (int j = 0; j < (1 << (lines - log)); j++) {
				System.out.print("-");
			}
			System.out.print(data[i] + " ");
			for (int j = 0; j < (1 << (lines - log)); j++) {
				System.out.print("-");
			}
		}

	}

	public static void printDLF(int[] data, int i) {
		if (((i << 1) + 1) < data.length) {
			System.out.println(data[i]);
			printDLF(data, i << 1 + 1);
		} else {
			System.out.println(data[i << 1 + 2]);
		}
	}

}
