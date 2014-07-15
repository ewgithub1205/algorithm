package sort;

public class SelectSort {

	public static void selectSort(int[] list) {

		for (int i = 0; i < list.length; i++) {
			
			//Assume the i is the min number
			int tmp = list[i];
			//Find out the min position in the list
			int minPos = i;
			for (int j = i + 1; j < list.length; j++) {
				if (tmp > list[j]) {
					tmp = list[j];
					minPos = j;
				}
			}
			// SWAP
			swap(list, i, minPos);
		}

	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {

		int arry[] = { 10, 11, 0, 20, 19, 101, 999, 100, 299, 33, 45, 67, 89,
				13, 14, 17, 56, 78, 55, 443, 33, 6, 3445, 345, 345, 345, 34532,
				2346, 4356, 56464, 56 };

		selectSort(arry);
		for (int a : arry) {
			System.out.println(a);

		}

	}

}
