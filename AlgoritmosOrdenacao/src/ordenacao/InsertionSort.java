package ordenacao;

import java.util.Arrays;

public class InsertionSort {
	
	private static void insertionSort(float[] A) {
		float key;
		int i, j;
		for(j=1; j<A.length; j++) {
			key = A[j];
			i = j-1;
			while(i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
    
	
	public static void main(String[] args) {
		float[] A = {3, 5, (float) 2.5 , 6, (float) 9.1, (float)1.1,8,9,1};
		System.out.println(Arrays.toString(A));
		insertionSort(A);
		System.out.println(Arrays.toString(A));
	}
}
