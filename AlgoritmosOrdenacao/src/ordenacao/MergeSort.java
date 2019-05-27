package ordenacao;
import java.util.Arrays;

public class MergeSort {

	private static void merge(float[] A, int p, int q, int r) {
		int k, i, j;
		int n1=q-p+1;
		int n2=r-q;
		
		float [] L = new float[n1+1];
		float [] R = new float[n2+1];
		
		for (i = 0; i < n1; i++) {
			L[i] = A[p+i];
		}
		
		for (j = 0; j < n2; j++) {
			R[j] = A[q+j+1];
		}
		L[n1]=Float.POSITIVE_INFINITY;
		R[n2]=Float.POSITIVE_INFINITY;
		
		i=0; 
		j=0;
		k=p;
		while (k<r+1) {
			if (L[i] < R[j]) {
	            A[k++] = L[i++];
	        }
	        else {
	            A[k++] = R[j++];
	        }
		}
		
		
	}
    
	public static void mergeSort(float[] A, int p, int r) { 
		if(p<r) { 
			int q=(p+r)/2;
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
		 	merge(A,p,q,r);
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
