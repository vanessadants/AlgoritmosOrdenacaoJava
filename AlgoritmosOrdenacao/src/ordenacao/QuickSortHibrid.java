package ordenacao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QuickSortHibrid {
	public static int LIMITE;
	
	private static void exchange(float[] A, int i, int j) {
		float aux=A[i];
		A[i]=A[j];
		A[j]=aux;
	}
	
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
		if(r-p+1<LIMITE) {
			insertionSort(A, p, r);
		}else if(p<r) { 
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
			int LIMITE,
			String nomeFile) throws IOException{
		
		QuickSortHibrid.LIMITE=LIMITE;
		FileWriter arq = new FileWriter(nomeFile);
		BufferedWriter buffW = new BufferedWriter (arq);
		buffW.write ("QuickSortHibrid: start="+start+", stop="+stop+", step="+step+", nIterations="+nIterations+", Limite Insertion/quick="+LIMITE);
        buffW.newLine ();
        buffW.write ("Size= Array Size, mean= Mean Execution Time (nanoseconds)");
        buffW.newLine ();
	  
		
		/*Define problem size*/ 
		for (int i=start;i<=stop;i=i+step) {
			/*Repeat experiment nIteration times*/
			long meanExecutionTime=0;
			
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
				
				//System.out.println(Arrays.toString(A));	
			}
			meanExecutionTime=meanExecutionTime/nIterations;

			/*Save problemSize, meanExecutionTime*/
			buffW.write (i+" "+meanExecutionTime);
	        buffW.newLine ();
		}
		buffW.close ();
		arq.close();
	}
	
}
