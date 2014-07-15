package sort;

public class ShellSort {
	public static void shellSort(int arry[],int initGroupMembers) {
		//The number of groups
		int groups = arry.length;
		while (groups > 1) {
            //Separate into groups PER initGroupMembers
			groups = (groups % initGroupMembers > 0) ? (groups / initGroupMembers) + 1 : (groups / initGroupMembers);
			// There are #len groups
			for (int i = 0; i < groups; i++) {
				// Insert sort every group.
				for (int j = i+1; j < arry.length; j += groups) {
					int key = arry[j];
					int k = j - 1;
					while (k >= 0 && arry[k] > key) {
						arry[k + 1] = arry[k];
						k--;
					}
					arry[k + 1] = key;
				}

			}
		}
	}

}
