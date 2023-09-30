//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Node{
    int node,color;
    Node(int node,int color){
        this.node=node;
        this.color=color;
        
    }
}
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        Queue<Node> que=new LinkedList<>();
        int f=0;
        int len=adj.size()-1;
        for(int i=0;i<len+1;i++)
        {
            if(hm.containsKey(i))
            continue;
            hm.put(i,0);
            que.add(new Node(i,0));
            while(!que.isEmpty())
            {
                Node obj=que.remove();
                int color=obj.color;
                int n=obj.node;
                for(int j=0;j<adj.get(n).size();j++)
                {
                    int v=adj.get(n).get(j);
                    if(hm.containsKey(v))
                    {
                        if(hm.get(v)==color)
                       { f++;
                       break;
                       }
                        
                    }
                    else
                    {
                        hm.put(v,color^1);
                        que.add(new Node(v,color^1));
                    }
                }
                if(f>0)
                break;
            }
            if(f>0)
            break;
        }
        if(f>0)
        return false;
        return true;
    }
}