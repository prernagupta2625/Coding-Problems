//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s1 = br.readLine();
	            String s2 = br.readLine();
    	    	Node root1 = buildTree(s1);
    	    	Node root2 = buildTree(s2);
        	    Solution tree = new Solution();
        	    if (tree.isIsomorphic(root1, root2) == true) 
                    System.out.println("Yes"); 
                else
                    System.out.println("No");
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java

class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        int l1=0,l2=0,r1=0,r2=0;
        if(root1==null && root2==null)
        return(true);
         if(root1.data==root2.data)
         {
             if(root1.left!=null)
             l1=root1.left.data;
             if(root1.right!=null)
             r1=root1.right.data;
             if(root2.left!=null)
             l2=root2.left.data;
             if(root2.right!=null)
             r2=root2.right.data;
            
            if(l1==l2&&r1==r2&&l1==r1)
            return((isIsomorphic(root1.left,root2.right)&&isIsomorphic(root1.right,root2.left))||(isIsomorphic(root1.left,root2.left)&&isIsomorphic(root1.right,root2.right)));
             else if(l1==l2 && r1==r2)
            {
                Node left1=root1.left;
                Node left2=root2.left;
                Node right1=root1.right;
                Node right2=root2.right;
                return(isIsomorphic(left1,left2) && isIsomorphic(right1,right2));
            }
            else if(l1==r2 && l2==r1)
            {
                Node left1=root1.left;
                Node left2=root2.right;
                Node right1=root1.right;
                Node right2=root2.left;
                return(isIsomorphic(left1,left2) && isIsomorphic(right1,right2));
            }
            else 
            return false;
         }
         else 
         return false;
    }
    
}    