package ordenacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
    

	public static void executar(
			int start,
			int stop,
			int step,
			int nIterations,
			int LIMITE_ALEATORIO,
			String nomeFile) throws IOException{
		
		FileWriter arq = new FileWriter(nomeFile);
		BufferedWriter buffW = new BufferedWriter (arq);
		buffW.write ("InsertionSort: start="+start+", stop="+stop+", step="+step+", nIterations="+nIterations);
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
				insertionSort(A);
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
