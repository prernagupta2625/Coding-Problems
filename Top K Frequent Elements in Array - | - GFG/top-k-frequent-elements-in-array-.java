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
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(Integer t : nums)
        hm.put(t,hm.getOrDefault(t,0)+1);
        
        List<Map.Entry<Integer,Integer> > list=new ArrayList<Map.Entry<Integer,Integer>>();
        for(Map.Entry<Integer,Integer> entry: hm.entrySet())
        list.add(entry);
        Collections.sort(list,(a,b)->{
            if(a.getValue()-b.getValue()==0)
            return b.getKey()-a.getKey();
            else
            return b.getValue()-a.getValue();
        });
        int ans[]=new int[k];
        for(int i=0;i<list.size();i++)
        {    if(i<k)
            ans[i]=list.get(i).getKey();
       // System.out.println("key"+list.get(i).getKey()+"value"+list.get(i).getValue());
        }
        return ans;
    
    }
}