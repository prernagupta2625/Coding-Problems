//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int max=Integer.MIN_VALUE;
        int sum=0, start=0,end=-1,sfinal=-1,efinal=-1;
        for(int i=0;i<x.length;i++)
        {
            hm.put(x[i],b[i]);
        }
        for(int j=0;j<w.length();j++)
        {
            char ch=w.charAt(j);
            end++;
            if(hm.containsKey(ch))
            {
                sum=sum+hm.get(ch);
            }
            else
            {
                sum=sum+(int)ch;            
            }
               if(sum>max)
            {
              sfinal=start;
            efinal=end; 
            }
            max=Math.max(max,sum);
           
        
        if(sum<0)
        {
            sum=0;
            end=j;
            start=j+1;
            
        }
        // System.out.println("sum"+sum+"start"+sfinal+"end"+efinal);
    }
       //System.out.println("sum"+sum+"start"+sfinal+"end"+efinal);
       String str=w.substring(sfinal,efinal+1);
    return str;
}
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends