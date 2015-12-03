package webApp;

public class Model {
	public long FibonacciDP(int i) {
		long result[] = new long[10000];
		if(i <= 1)
			return 1;
		if(result[i] != 0)
			return result[i];
		result[i] = FibonacciDP(i-1) + FibonacciDP(i-2);
		return result[i];
	}
	public long FactorialDB (int x) {
		long result[] = new long[10000];
	
		if (x<0) return 0;
		result[0] = 1;		
		if (x >= 0) {			
			for(int i=1; i<=x; i++) {
				result[i] = i * result[i-1];
			}
		}
		return result[x];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		int n = 20;   // It can accept until 9999 only.
		long start = System.nanoTime();
		long result = m.FactorialDB(n); 		
		long end = System.nanoTime();		
		System.out.println("The sum is " + result );
		System.out.println("Time taken by Dynamic Programming method is " + (end - start));
	}	
}
