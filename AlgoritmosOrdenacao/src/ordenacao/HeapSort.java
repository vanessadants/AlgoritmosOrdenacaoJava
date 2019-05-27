package ordenacao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HeapSort {
	
	private static void exchange(float[] A, int i, int j) {
		float aux=A[i];
		A[i]=A[j];
		A[j]=aux;
	}
	private static int left(int i) {
		return 2*i+1;
	}
	private static int right(int i) {
		return 2*i+2;
	}
	private static void maxHeapify(float[] A, int i, int heapSize) { 
		int lagest;
		int l= left(i);
		int r= right(i);
		if(l< heapSize && A[l]>A[i]) {
			lagest=l;
		}else {
			lagest=i;
		}
		if(r< heapSize && A[r] > A[lagest]) {
			lagest=r;
		}
		if(lagest!=i) {
			exchange(A, i, lagest);
			maxHeapify(A, lagest, heapSize);
		}
	}
	
	private static void buildMaxHeap(float[] A) { 
		for (int i= A.length/2 - 1; i>=0;i--) {
			maxHeapify(A, i, A.length);
		}
	}
    
	private static void heapSort(float[] A) {
		int heapSize = A.length;
		buildMaxHeap(A);
		for(int i = A.length-1; i > 0 ; i--) {
			exchange(A,0,i);
			maxHeapify(A, 0, --heapSize);
		}
		
		
	}
	public static void executar(
			int start,
			int stop,
			int step,
			int nIterations,
			int LIMITE_ALEATORIO) throws IOException{
		
		FileWriter arq = new FileWriter("heapSort.txt");
		BufferedWriter buffW = new BufferedWriter (arq);
		buffW.write ("HeapSort: start="+start+", stop="+stop+", step="+step+", nIterations="+nIterations);
        buffW.newLine ();
        buffW.write ("Size= Array Size, mean= Mean Execution Time (milliseconds), standardDeviation = Standard Deviation (milliseconds)");
        buffW.newLine ();
	  
		
		/*Define problem size*/ 
		for (int i=start;i<=stop;i=i+step) {
			/*Repeat experiment nIteration times*/
			long meanExecutionTime=0;
			long minExecutionTime=Long.MAX_VALUE;
			for(int j=0;j<nIterations;j++) {
				/*Initialize array*/
				float[] A= new float[i];
				Random random = new Random();
				for(int k=0;k<i;k++) {
					A[k]=random.nextFloat()*LIMITE_ALEATORIO;
				}
				
				//System.out.println(Arrays.toString(A));
				
				/*Measure execution time*/
				long startTime = System.nanoTime();
				heapSort(A);
				long executionTime= System.nanoTime() - startTime;
				
				meanExecutionTime+=executionTime;
				if(executionTime<minExecutionTime) {
					minExecutionTime=executionTime;
				}
				
				//System.out.println(Arrays.toString(A));	
			}
			meanExecutionTime=meanExecutionTime/nIterations;
			long standardDeviation = meanExecutionTime-minExecutionTime;
			/*Save problemSize, meanExecutionTime, standardDeviation*/
			buffW.write ("size="+i+", mean="+meanExecutionTime+", standardDeviation="+standardDeviation);
	        buffW.newLine ();
		}
		buffW.close ();
		arq.close();
	}
	
}
