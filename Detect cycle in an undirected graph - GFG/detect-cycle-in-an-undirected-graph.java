//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class pair{
    int vertex,parent;
    pair(int vertex,int parent)
    {
        this.vertex=vertex;
        this.parent=parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        Queue<pair> que=new LinkedList<>();
        int vis[]=new int[V];
        for(int j=0;j<V;j++)
        {
            if(vis[j]!=1)
            {
        que.add(new pair(j,-1));
        vis[j]=1;
        while(!que.isEmpty())
        {
            pair obj=que.remove();
            int node=obj.vertex;
            int parent=obj.parent;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int n=adj.get(node).get(i);
                
                    if(vis[n]==1)
                    {
                    if(parent!=n)
                    return true;
                    }
                    else
                    {
                        que.add(new pair(n,node));
                        vis[n]=1;
                    }
                
            }
        }
            }
        }
        return false;
    }
}