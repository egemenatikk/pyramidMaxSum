import java.util.*;
import java.io.*;

public class Main{
	
	static List<List<Integer>> pyramid = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//Currently, you can enter the input to STDIN part in the right
		//If you want this program to read from a file, please uncomment the lines:
		//16,19,35,36,37,38 
		//and change System.in to file in the 21th line
		
		//absolute path of the input file should be written here
		//File file = new File("Your input file");
		
		
	    //try {

	        Scanner scanner = new Scanner(System.in);
	        int count = 1;
	        
	        while (scanner.hasNextLine()) {
	        	pyramid.add(new ArrayList<>());
	            String line=scanner.nextLine();
	            Scanner lineScan = new Scanner(line);
	            for(int i=0;i<count;i++) {
	            	pyramid.get(count-1).add(lineScan.nextInt());
	            }
	            lineScan.close();
	            count++;
	        }
	        scanner.close();
	    /*} 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }*/
	    
	    System.out.println(findMax(0,0));
	}
	
	public static boolean isPrime(int n) {
		
		if(n==1 || n==0)
			return false;
		
		for(int k=2;k<=n/2;k++) {
			if(n%k==0)
				return false;
		}
		
		return true;
	}
	
	public static int findMax(int row, int column) {
		
		if(column<0 || row >= pyramid.size() ||  column>=pyramid.get(row).size()) {
			return 0;
		}
		
		if(isPrime(pyramid.get(row).get(column))) {
			return 0;
		}
		
		return pyramid.get(row).get(column)+Math.max(findMax(row+1,column-1), Math.max(findMax(row+1,column), findMax(row+1,column+1)));
	}
	
	
}
