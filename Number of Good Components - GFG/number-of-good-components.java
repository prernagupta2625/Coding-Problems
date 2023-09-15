//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]=new int[V+1];
        int am[][]=new int[V+1][V+1];
       Arrays.fill(vis,0);
        Queue<Integer> que=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        for(int i=1;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                am[i][adj.get(i).get(j)]=1;
            }
        }
        
        // for(int i=0;i<=V;i++)
        // {
        //     for(int j=0;j<=V;j++)
        //     System.out.print(am[i][j]+" ");
        //     System.out.println();
        // }
        for(int i=1;i<=V;i++)
        {
            if(vis[i]==0)
            {
                vis[i]=1;
                que.add(i);
                list.add(i);
                while(!que.isEmpty())
                {
                    int num=que.remove();
                   
                    for(int j=1;j<=V;j++)
                    {
                        if(am[num][j]==1 && vis[j]==0)
                        {
                            list.add(j);
                            vis[j]=1;                           
                            que.add(j);
                        }
                    }
                    
                }
                int f=0;
                for(int j=0;j<list.size();j++)
                {
                    for(int k=0;k<list.size();k++)
                    {
                        if(k==j)
                        continue;
                        if(am[list.get(j)][list.get(k)]==0)
                        {
                            f=1;
                            break;
                        }
                    }
                    if(f==1)
                    break;
                }
                if(f==0)
                count++;
                list.clear();
                
            }
        }
        return count;
    }
}