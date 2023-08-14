//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends


class pair{
    int num,freq;
    pair(int n,int f)
    {
        num=n;
        freq=f;
    }
}
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<pair> st=new Stack<pair>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {int count=1;
            while(!st.isEmpty() && st.peek().num<=price[i])
            {
                pair obj=st.pop();
                count=count+obj.freq;
                
            }
            
           
            ans[i]=count;
            st.push(new pair(price[i],count));
        }
        return ans;
    }
    
}