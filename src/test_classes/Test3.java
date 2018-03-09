package test_classes;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) 
	{
		Double[] elements = {1.0,0.2,2.1,4.4};
		int index = 0;
		
		System.out.println(minVal(elements, index)); 
		

	}// end
	
	public static int mystery(int n, int m) 
	{
	   if (n == 0)
	   {
	      return 0;
	   }

	   if (n == 1)
	   {
	      return m;
	   }
	   return m + mystery(n - 1, m);
	}
	
	public static double minVal(Double[] elements, int index) 
	{    
	   if (index == elements.length - 1) 
	   {
	      return elements[index];
	   }

	   double val = minVal(elements, index + 1);    

	   if (elements[index] < val) 
	   {
	      return elements[index];   
	   }
	   else
	   {  
	      return val; 
	   }
	}
}
