import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {
    public static void main (String [] args) {
    	Random rand = new Random();
    	int randNum = 0;
    	
        int[] numbers = new int[1000];
        for (int i=0; i<numbers.length; i++) {
        	randNum = rand.nextInt(10 + 1 - 5) + 1;
        	numbers[i] = (int)(Math.random()*50) - randNum; // generate a random number
        }
        System.out.println("Answer: "+solution(numbers));

        int[] numbers1 = {-1,-2,4,5,10,1,3,-8,12,15,20,25,10,10,1,-3,7};
        System.out.println("Answer: "+solution(numbers1));
    }
    
    public static int solution (int[] A) {
        // write your code in Java SE 8
    	Integer check = 1;
    	
    	List<Integer> p = new ArrayList<Integer>();
    	
    	System.out.println("-----------");
    	for (Integer i: Arrays.stream(A).sorted().distinct().filter(x-> x>0).toArray()) {
    		if (i > 0) {
    			p.add(i);
    			System.out.print(","+i);
    		}
    	}
    	System.out.println("\n-----------");
    	
    	while (check < A.length+1) {
    		if(!p.contains(check)) {
    			break;
    		}
    		check++;
    	}
    
    	return check;
    }
    

    
}
