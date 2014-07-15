package tree;

import sort.HeapSort;

public class BinaryTreeSort {
	public static void main(String[] args) {
		System.out.println(Math.log(4) / Math.log(2));
		int arry[] = { 10, 11, 0, 20, 19, 101, 999, 100, 299, 33, 45, 67, 89,
				13, 14, 17, 56, 78, 55, 443, 33, 6, 3445, 345, 345, 345, 34532,
				2346, 4356, 56464, 56, 88 };
		HeapSort.buildWholeHeapTree(arry);
		
		HeapSort.sortTopHeap(arry);
		
		HeapSort.printTree(arry);

		printDLRTree(arry, 0);
	}

	public static void printDLRTree(int[] data, int index) {
		System.out.println(data[index]);
		if (hasLeft(data, index)) {
			int leftIndex = (index << 1) + 1;
			if (isLeaf(data, leftIndex)) {
				System.out.println(data[leftIndex] + " left leaf");
			} else {
				printDLRTree(data, leftIndex);
			}

		}
		if (hasRight(data, index)) {
			int rightIndex = (index << 1) + 2;
			if (isLeaf(data, rightIndex)) {
				System.out.println(data[rightIndex] + " right leaf");
			} else {
				printDLRTree(data, rightIndex);
			}
		}

	}

	public static boolean hasLeft(int[] data, int index) {
		if ((index << 1) + 1 < data.length) {
			return true;
		}
		return false;
	}

	public static boolean hasRight(int[] data, int index) {
		if ((index << 1) + 2 < data.length) {
			return true;
		}
		return false;
	}

	public static boolean isLeaf(int[] data, int index) {
		return !hasLeft(data, index);
	}

}
