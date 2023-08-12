//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends

class pair{
    long num,freq;
    pair(long n,long f)
    {
        num=n;
        freq=f;
    }
}
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        Stack<pair> st=new Stack<pair>();
        
        long left[]=new long[(int)n];
        long right[]=new long[(int)n];
        
        for(int i=0;i<(int)n;i++)
        {
            long count=1;
            while(!st.isEmpty() && st.peek().num>=hist[i])
            {
                count=count+st.peek().freq;
                st.pop();
            }
            st.push(new pair(hist[i],count));
            left[i]=count;
        }
        st.clear();
        for(int i=(int)n-1;i>=0;i--)
        {
            long count=1;
            while(!st.isEmpty() && st.peek().num>=hist[i])
            {
                count=count+st.peek().freq;
                st.pop();
            }
            st.push(new pair(hist[i],count));
            right[i]=count;
        }
        
        long max=0;
        for(int j=0;j<(int)n;j++)
        {
            max=Math.max(max,(left[j]+right[j]-1)*hist[j]);
            //System.out.println("left"+left[j]+"right"+right[j]+"max"+max+"j"+j);
        }
        return max;
    }
        
}



