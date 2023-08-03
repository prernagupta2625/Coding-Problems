//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
       int max=Integer.MAX_VALUE;
       int min=Integer.MIN_VALUE;
       return func(post,new int []{n-1},min,max);
       
       
    }
    public static Node func(int post[],int no[],int min,int max)
    {
        if(no[0]>=0)
        {
        if(post[no[0]]>min && post[no[0]]<max)
         {Node n=new Node(post[no[0]]);
         no[0]-=1;
          n.right=func(post,no,n.data,max);
         n.left=func(post,no,min,n.data);
         return n;
         }
         else
         return null;
        }
        else
        return null;
        
         
    }
}