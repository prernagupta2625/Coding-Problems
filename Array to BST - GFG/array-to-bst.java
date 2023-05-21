//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class Solution
{
    static ArrayList<Integer> arr=new ArrayList<Integer>();
    public int[] sortedArrayToBST(int[] nums)
    {
        arr.clear();
        Solution obj=new Solution();
        int ar[]=new int[nums.length];
        obj.preorder(ar,0,obj.cal(nums,0,nums.length-1));
        for(int i=0;i<arr.size();i++)
        {
            ar[i]=arr.get(i);
        }
        return(ar);
        
    }
    Node cal(int[] nums,int start,int end)
    {
        if(start>end)
        return(null);
        int mid=(start+end)/2;
        //System.out.println("mid"+nums[mid]);
        Node node=new Node(nums[mid]);
        node.left=cal(nums,start,mid-1);
        node.right=cal(nums,mid+1,end);
        return(node);
    }
    void preorder(int[]ar,int ind,Node n)
    {
        arr.add(n.data);
        int i=ind+1;
        if(n.left!=null)
        preorder(ar,i,n.left);
        if(n.right!=null)
        preorder(ar,i,n.right);
        
        
    }
}