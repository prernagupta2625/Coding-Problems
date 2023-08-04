//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        Map<Integer,Queue<Integer>> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            if(hm.containsKey(inorder[i]))
            {
                hm.get(inorder[i]).add(i);
            }
             else
             {
                 
             hm.put(inorder[i],new LinkedList<>());
             hm.get(inorder[i]).add(i);
             }
        }
        return func(hm,preorder,0,preorder.length-1,0,inorder.length-1);
        
    }
    public static Node func(Map<Integer,Queue<Integer>> hm,int preorder[],int prestart,int preend, int instart,int inend)
    {   if(instart>inend || prestart>preend|| prestart>=preorder.length|| instart>=preorder.length)
        return null;
        Node node=new Node(preorder[prestart]);
        int pos=hm.get(preorder[prestart]).remove();
        //System.out.println("value"+node.data+prestart+preend+instart+inend);
        node.left=func(hm,preorder,prestart+1,prestart+pos-instart,instart,pos-1);
        node.right=func(hm,preorder,prestart+pos-instart+1,preend,pos+1,inend);
        
        return node;
    }
}