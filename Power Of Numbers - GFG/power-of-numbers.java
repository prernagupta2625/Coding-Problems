//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
        
    long power(int N,int R)
    {
        //Your code he
        long power=1;
        while(R>0)
       { int pow =(int)(Math.log(R)/Math.log(2));
        int dif=R-(int)Math.pow(2,pow);
        power=(power*calculate(pow,N))%1000000007;
        if(dif==1)
        {
            power=(power*N)%1000000007;
            dif-=1;
        }
    
        R=dif;
       }
        return power;
    }
    static long calculate(int pow,long num)
    {
        if(pow>0)
        {
            num=(num*num)%1000000007;
            return calculate(pow-1,num);
        }
        else
        return num;
        
    }

}
