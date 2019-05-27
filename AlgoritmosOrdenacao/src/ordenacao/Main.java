package ordenacao;

public class Main {
	private static final int LIMITE_ALEATORIO=100;
	
	/*args consist of 5 arguments
		start;
		stop;
		step; 
		nIterations; 
	*/
	public static void main(String[] args) {
		try {
			/*int start=Integer.valueOf(args[0]); 
			int stop=Integer.valueOf(args[1]); 
			int step=Integer.valueOf(args[2]);  
			int nIterations=Integer.valueOf(args[3]); */
			
			int start=10;
			int stop=100;
			int step=10; 
			int nIterations=10; 
	
			InsertionSort.executar(start,stop,step,nIterations,LIMITE_ALEATORIO);
			HeapSort.executar(start,stop,step,nIterations,LIMITE_ALEATORIO);
			MergeSort.executar(start, stop, step, nIterations, LIMITE_ALEATORIO);
			MergeSortHibrid.executar(start, stop, step, nIterations, LIMITE_ALEATORIO);
			QuickSort.executar(start, stop, step, nIterations, LIMITE_ALEATORIO);
			QuickSortHibrid.executar(start, stop, step, nIterations, LIMITE_ALEATORIO);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
