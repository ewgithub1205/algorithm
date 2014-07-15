package sort;

public class BubbleSort {
	public static void bubbleSort(int[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list[j] > list[j + 1]) {
					int tmp = list[j + 1];
					list[j + 1] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

}
