package ordenacao;
import java.util.Arrays;

public class QuickSort {

	private static void exchange(float[] A, int i, int j) {
		float aux=A[i];
		A[i]=A[j];
		A[j]=aux;
	}
	
	private static int partition(float[] A, int p, int r) {
		int i, j;
		float x;
		
		x=A[r];
		i=p-1;
		for(j=p; j<r ;j++) {
			if(A[j]<=x) {
				i++;
				exchange(A,i,j);
			}
		}
		exchange(A,i+1,r);
		return i+1;
		
	}
    
	public static void quickSort(float[] A, int p, int r) { 
		if(p<r) { 
			int q=partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	public static void quickSort(float[] A) { 
		quickSort(A,0,A.length-1);
	}
	public static void main(String[] args) {
		float[] A = {3, 5, (float) 2.5 , 6, (float) 9.1, (float)1.1,8,9,1};
		System.out.println(Arrays.toString(A));
		quickSort(A);
		System.out.println(Arrays.toString(A));
	}
	
}
