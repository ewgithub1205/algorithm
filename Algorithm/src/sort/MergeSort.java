package sort;

public class MergeSort {
	public static int[] mergeSort(int[] list) {
		int size = list.length;
		if (size < 2) {
			return list;
		}
		int[] firstHalf = new int[list.length/2];
		int[] secondHalf = new int[list.length -firstHalf.length];
		
		System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);
		System.arraycopy(list, firstHalf.length, secondHalf, 0, secondHalf.length);

		mergeSort(firstHalf);
		mergeSort(secondHalf);
		
		merge(firstHalf,secondHalf,list);
		return list;
		
	}
	public static void  merge(int[] firstHalf,int[] secondHalf,int[] result){
		int fi = 0;
		int si = 0;
		int j = 0;
		
		while(fi<firstHalf.length&& si <secondHalf.length){
			if(firstHalf[fi]<secondHalf[si]){
				result[j] = firstHalf[fi];
				fi++;
			}else{
				result[j] = secondHalf[si];
				si++;
			}
			j++;
		}
		
		System.arraycopy(firstHalf, fi, result, j, firstHalf.length-fi);
		System.arraycopy(secondHalf, si,result,j, secondHalf.length -si);
	}


}
