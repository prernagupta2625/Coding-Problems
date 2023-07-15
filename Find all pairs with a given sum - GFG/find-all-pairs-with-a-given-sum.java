//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        List<pair> arr=new ArrayList<pair>();
        HashMap<Long,Long> hm=new HashMap<Long,Long>();
        for(int i=(int)M-1;i>=0;i--)
        {
           
               if(hm.containsKey(B[i]))
               {
                   hm.put(B[i],hm.get(B[i])+1);
               }
               else
               hm.put(B[i],(long)1);
           
        }
        Arrays.sort(A);
         for(int i=(int)N-1;i>=0;i--)
        {
            if(hm.containsKey(X-A[i]))
            {
                long val=hm.get(X-A[i]);
                 arr.add(new pair(A[i],X-A[i]));
                if(val==1)
                {
                   hm.remove(X-A[i]);
                }
                else
                {
                    hm.put(X-A[i],hm.get(X-A[i])-1);
                }
            }
          
        }
        Collections.reverse(arr);
        pair[] ar=new pair[arr.size()];
        ar= arr.toArray(ar);
        return ar;
        
        
    }
}