//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int len=adj.size();
        int vis[]=new int[V];
        int count=0;
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                count++;
                vis[i]=1;
                que.add(i);
                while(!que.isEmpty())
                {
                    int n=que.remove();
                for(int j=0;j<adj.get(n).size();j++)
                {
                    int num=adj.get(n).get(j);
                    if(num==1)
                    {
                    if(vis[j]==0)
                    {
                        que.add(j);
                        vis[j]=1;
                    }
                    }
                }
                }
            }
        }
        return count;
    }
};