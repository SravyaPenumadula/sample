

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyFirstClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Reversing String without using method
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the string:");

		String input1 = sc.nextLine();

		String [] chars = input1.split("");

		for(int i = chars.length-1 ; i>=0 ; i--)

		{

		System.out.print(chars[i]);

		}
		
	  
	//Finding Pallendrum
	
	 //String input = "abbaalla" ;      
	    if (input1.length() <= 1) 
	    {
	        System.out.println("Not Palindrome Found.");
	    }
	    else
	    {   
	        int length = input1.length();            
	        Set<String> set = new HashSet<String>();
	        for (int i = 0; i <length; i++)
	        {
	            //if(i==0)
	            for (int j=i+1;j<length+1;j++) 
	            {
	                String s = input1.substring(i, j);                   
	                StringBuffer sb = new StringBuffer(s);
	                sb.reverse();

	                if(s.equals(sb.toString()) && s.length()>1)
	                {                       
	                    set.add(s);
	                }
	            }
	        } 
	        System.out.println("\nThe Pallendrums are:");
	        System.out.println(set);
	    }
}
	
}




