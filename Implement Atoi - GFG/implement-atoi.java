//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int sum=0,n=0,f=0;
	if(str.charAt(0)=='-')
{	f=1;
str=str.substring(1);
}
	for(int i=0;i<str.length();i++)
	{
	    char ch=str.charAt(i);
	    if(ch=='1')
	    n=1;
	    else if(ch=='2')
	    n=2;
	     else if(ch=='3')
	     n=3;
	      else if(ch=='4')
	      n=4;
	       else if(ch=='5')
	       n=5;
	        else if(ch=='6')
	        n=6;
	         else if(ch=='7')
	         n=7;
	          else if(ch=='8')
	          n=8;
	           else if(ch=='9')
	           n=9;
	            else if(ch=='0')
	            n=0;
	            else
	            n=-1;
	            if(n==-1)
	            return -1;
	            else
	            sum=sum*10+n;
	}
	if(f==1)
	sum=sum-2*sum;
	return sum;
    }
}
