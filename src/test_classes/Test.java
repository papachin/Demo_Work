package test_classes;

import java.util.Arrays;

public class Test {
	
	public static void main (String [] args) {
		
		int[] t = {0,2,9,6,5,6};

		byte b = 'A';
		System.out.println(b);
		//System.out.print(getTime(t));
		
	}
	
	public static String getTime (int[] clock) {
		String time = "";
		
		int[] small = Arrays.stream(clock).filter(x->x < 6).sorted().toArray();
		int[] large = Arrays.stream(clock).filter(x->x >= 6).sorted().toArray();
		
		if (small[0] == 0 && small[1] == 0 || small[0] == 2 && small[1] == 4) {

		    time = "Not Valid Time";
		    
		} else {
			
    		if (small.length == 3 && large.length == 3) {
    			time = ""+small[0]+large[0]+":"+small[1]+large[1]+":"+small[2]+large[2]+"";
    			
    		} else if (small.length == 4 && large.length == 2)  { 
    			time = ""+small[0]+small[1]+":"+small[2]+large[0]+":"+small[3]+large[1]+"";
    			
    		} else if (small.length == 5) {
    			time = ""+small[0]+small[1]+":"+small[2]+small[3]+":"+small[4]+large[0]+"";
    			
    		} else {
    			time = "Not Valid Time";
    		}
		}
		
		return time;
	}
}
