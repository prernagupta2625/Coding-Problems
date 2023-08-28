//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}
// } Driver Code Ends

class pair{
    int a,b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        ArrayList<pair> arr=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            arr.add(new pair(A[i],B[i]));
        }
        int sum=0;
        Collections.sort(arr,(o1,o2)->{
            if(o1.b==o2.b)
            return o2.a-o1.a;
            return o2.b-o1.b;
        });
        for(int j=0;j<arr.size();j++)
        {
            pair obj=arr.get(j);
             //System.out.println(obj.a+" hello "+obj.b);
            if(obj.a>=T)
           { sum= sum+T*obj.b;
           break;
           }
            else
            { 
                sum=sum+obj.a*obj.b;
                T-=obj.a;
            }
        }
        return sum;
    }
}