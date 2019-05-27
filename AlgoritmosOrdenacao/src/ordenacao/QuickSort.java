package ordenacao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
    
	private static void quickSort(float[] A, int p, int r) { 
		if(p<r) { 
			int q=partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	private static void quickSort(float[] A) { 
		quickSort(A,0,A.length-1);
	}
	public static void executar(
			int start,
			int stop,
			int step,
			int nIterations,
			int LIMITE_ALEATORIO,
			String nomeFile) throws IOException{
		
		FileWriter arq = new FileWriter(nomeFile);
		BufferedWriter buffW = new BufferedWriter (arq);
		buffW.write ("QuickSort: start="+start+", stop="+stop+", step="+step+", nIterations="+nIterations);
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
				quickSort(A);
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
