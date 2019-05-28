package ordenacao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MergeSortHibrid {
	
	public static int LIMITE;

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
	private static void mergeSort(float[] A, int p, int r) { 
		if(r-p+1<LIMITE) {
			insertionSort(A, p, r);
		}else if(p<r) { 
			int q=(p+r)/2;
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
			merge(A,p,q,r);
		}
	}
	private static void mergeSort(float[] A) { 
		mergeSort(A,0,A.length-1);
	}
	public static void executar(
			int start,
			int stop,
			int step,
			int nIterations,
			int LIMITE_ALEATORIO,
			int LIMITE,
			String nomeFile) throws IOException{
		
		MergeSortHibrid.LIMITE=LIMITE;
		FileWriter arq = new FileWriter(nomeFile);
		BufferedWriter buffW = new BufferedWriter (arq);
		buffW.write ("mergeSortHibrid: start="+start+", stop="+stop+", step="+step+", nIterations="+nIterations+", Limite Insertion/merge="+LIMITE);
        buffW.newLine ();
        buffW.write ("Size= Array Size, mean= Mean Execution Time (nanoseconds), standardDeviation = Standard Deviation (nanoseconds)");
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
				mergeSort(A);
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
			buffW.write (i+" "+meanExecutionTime+" "+standardDeviation);
	        buffW.newLine ();
		}
		buffW.close ();
		arq.close();
	}
	
}
