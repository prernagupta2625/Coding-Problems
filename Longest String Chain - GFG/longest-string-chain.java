//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestChain(int N, String words[]){
     //code here
     Arrays.sort(words,(a,b)->{
         return a.length()-b.length();
     });
    //  for(String s: words)
    //  System.out.print(s+" ");
    //  return 2;
    int dp[]=new int[N];
    
    Arrays.fill(dp,1);
   
    int max=1,maxind=0;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
            if(i==j)
            continue;
            if(check(words[j],words[i]))
            {
                
                dp[i]=dp[j]+1;
               // System.out.println(words[j]+" "+words[i]+" "+dp[i]);
                
               
            }
            if(dp[i]> max)
            {
                max=dp[i];
               
            }
        }
    }
    // for(int i=0;i<N;i++)
    // System.out.print(words[i]+" "+dp[i]+" ");
    return max;
   
    }
   
    public static boolean check(String pre,String succ)
    {
        int len1=pre.length(),len2=succ.length(),ind1=0,ind2=0;
        if(len1>=len2 || len2-len1>1)
        return false;
        else
        {
            int f=0;
            while(ind1<len1 && ind2<len2)
            {
                if(pre.charAt(ind1)!=succ.charAt(ind2))
                {
                    if(f>0)
                    return false;
                    f++;
                    ind2++;
                }
                else
                {
                    ind1++;
                    ind2++;
                }
                
            }
            if(f==0 && ind1==len1 && ind2+1==len2)
            return true;
            else if(ind1<len1 || ind2<len2)
            return false;
            else
            return true;
        }
    }
}