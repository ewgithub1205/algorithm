package sort;

public class QuickSort {
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void quicksort(int list[], int from, int to) {
		// If the indexes cross, then we've sorted the whole array.
		if (from >= to) {
			return;
		}

		// Choose a pivot value and then partition the array so that every value
		// less than the pivot is positioned before the pivot in the array and
		// every value greater than the pivot is positioned after the pivot in
		// the array.
		int pivot = list[from];
		int i = from - 1;
		int j = to + 1;
		while (i < j) {
			// Keep incrementing from the start of the range so long as the
			// values are less than the pivot.
			i++;
			while (list[i] < pivot) {
				i++;
			}
			// Keep decrementing from the end of the range so long as the values
			// are greater than the pivot.
			j--;
			while (list[j] > pivot) {
				j--;
			}
			// So long at the indexes have not crossed, swap the pivot with the
			// value that was out of place.
			if (i < j) {
				swap(list, i, j);
			}
		}

		// Recursively sort the two portions of the array
		quicksort(list, from, j);
		quicksort(list, j + 1, to);
	}

	// Helper method that kicks off the recursive quicksort method
	public static int[] quicksort(int[] list) {
		quicksort(list, 0, list.length - 1);
		return list;
	}

	public static void main(String args[]) {

		int arry[] = { 10, 11, 0, 20, 19, 101, 999, 100, 299, 33, 45, 67, 89,
				13, 14, 17, 56, 78, 55, 443, 33, 6, 3445, 345, 345, 345, 34532,
				2346, 4356, 56464, 56 };

		quicksort(arry);
		for (int a : arry) {
			System.out.println(a);

		}

	}

}
