//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
     static List<String> lst=new ArrayList<String>();
    public List<String> find_permutation(String S) {
        // Code here
       lst.clear();
        char ch[]=S.toCharArray();
        Arrays.sort(ch);
        //for(char value: ch)
        //System.out.println(value);
        Solution obj=new Solution();
        int ar[]=new int[ch.length];
        HashSet<String> hs=new HashSet<>();
        Arrays.fill(ar,0);
         obj.permute(ar,ch,"",hs);
         return lst;
    }
    void permute(int ind[],char[] ch,String str,HashSet<String> hs)
    {
    
       for(int k=0;k<ind.length;k++)
       {
           if(ind[k]==0)
           {
              
               ind[k]=1;
               str=str+ch[k];
               if(str.length()==ch.length)
             {  if(!hs.contains(str))
             {
                 hs.add(str);
                 lst.add(str);
                 
             }
             }
               permute(ind,ch,str,hs);
               ind[k]=0;
               str=str.substring(0,str.length()-1);
           }
          
       }
       
    }
}