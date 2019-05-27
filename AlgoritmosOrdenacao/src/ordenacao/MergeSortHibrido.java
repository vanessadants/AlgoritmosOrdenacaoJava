package ordenacao;
import java.util.Arrays;

public class MergeSortHibrido {

	private static void insertionSort(float[] A, int p, int r) {
		float key;
		int i, j;
		for(j=p+1; j<=r; j++) {
			key = A[j];
			i = j-1;
			while(i>=p && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	
    
	public static void mergeSort(float[] A, int p, int r) { 
		if(p<r) { 
			int q=(p+r)/2;
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
			insertionSort(A,p,r);
		}
	}
	public static void mergeSort(float[] A) { 
		mergeSort(A,0,A.length-1);
	}
	public static void main(String[] args) {
		float[] A = {3, 5, (float) 2.5 , 6, (float) 9.1, (float)1.1,8,9,1};
		System.out.println(Arrays.toString(A));
		mergeSort(A);
		System.out.println(Arrays.toString(A));
	}
	
}
