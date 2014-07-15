package sort;

public class InsertionSort {
	public static int total = 0;

	public static void insertionSort(int arry[]) {

		for (int i = 0; i < arry.length; i++) {
			// To be inserted value.
			int key = arry[i];
			// The index for sorted number
			int j = i - 1;
			// Find the position which can be inserted.
			while (j >= 0 && arry[j] > key) {
				// Move the higher position
				arry[j + 1] = arry[j];
				j--;
				total++;
			}
			// insert
			arry[j + 1] = key;
		}
	}

	public static void main(String args[]) {

		int arry[] = { 10, 11, 0, 20, 19, 101, 999, 100, 299, 33, 45, 67, 89,
				13, 14, 17, 56, 78, 55, 443, 33, 6, 3445, 345, 345, 345, 34532,
				2346, 4356, 56464, 56 };

		insertionSort(arry);
		for (int a : arry) {
			System.out.println(a);

		}
		System.out.println("================" + total);
	}

}
