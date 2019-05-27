package ordenacao;

public class Main {
	
	
	/*args consist of 5 arguments
		start;
		stop;
		step; 
		nIterations; 
	*/
	public static void main(String[] args) {
		try {
			int start=Integer.valueOf(args[0]); 
			int stop=Integer.valueOf(args[1]); 
			int step=Integer.valueOf(args[2]);  
			int nIterations=Integer.valueOf(args[3]); 
			int LIMITE_ALEATORIO=Integer.valueOf(args[4]);
			
			/*int start=10;
			int stop=100;
			int step=10; 
			int nIterations=10;
			int LIMITE_ALEATORIO=10000000;*/
	
			String nomeFile="_I"+start+"_F"+stop+"_P"+step+"_N"+nIterations+"_A"+LIMITE_ALEATORIO+".txt";
			InsertionSort.executar(start,stop,step,nIterations,LIMITE_ALEATORIO,"insertionSort"+nomeFile);
			HeapSort.executar(start,stop,step,nIterations,LIMITE_ALEATORIO,"heapSort"+nomeFile);
			MergeSort.executar(start, stop, step, nIterations, LIMITE_ALEATORIO,"mergeSort"+nomeFile);
			MergeSortHibrid.executar(start, stop, step, nIterations, LIMITE_ALEATORIO,"mergeSortHibrid"+nomeFile);
			QuickSort.executar(start, stop, step, nIterations, LIMITE_ALEATORIO,"quickSort"+nomeFile);
			QuickSortHibrid.executar(start, stop, step, nIterations, LIMITE_ALEATORIO,"quickSortHibrid"+nomeFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
