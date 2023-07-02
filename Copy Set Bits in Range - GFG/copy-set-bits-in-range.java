//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
        int dif=r-l;
        int f=1;
       
        while(dif>0)
        {
           f=f<<1;
           f=f|1;
           dif-=1;
        }
        while(l>1)
        {
            f=f<<1;
            l-=1;
        }
       // System.out.println(f);
        f=f&y;
        return x|f;
    }
}