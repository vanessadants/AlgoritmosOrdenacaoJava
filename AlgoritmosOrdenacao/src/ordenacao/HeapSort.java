package ordenacao;
import java.util.Arrays;

public class HeapSort {

	private static void exchange(float[] A, int i, int j) {
		float aux=A[i];
		A[i]=A[j];
		A[j]=aux;
	}
	
	public static void maxHeapify(float[] A, int i) { 
		
	}
	
	public static void buildMaxHeapify(float[] A) { 
		
	}
    
	public static void heapSort(float[] A) { 
		
	}
	public static void main(String[] args) {
		float[] A = {3, 5, (float) 2.5 , 6, (float) 9.1, (float)1.1,8,9,1};
		System.out.println(Arrays.toString(A));
		heapSort(A);
		System.out.println(Arrays.toString(A));
	}
	
}
