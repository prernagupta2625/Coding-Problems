//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

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
	        PrintWriter out=new PrintWriter(System.out);
	        int test = Integer.parseInt(br.readLine());
	        while(test-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	int key = Integer.parseInt(br.readLine());
        	    Solution obj = new Solution();
        	    Node res = obj.nextRight(root, key);
        	    out.println(res.data);
        }
        out.close();
    }
  
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	Node nextRight(Node root, int key)
    {
		//Write your code here
		Queue<Node> que=new LinkedList<>();
		que.add(root);
		que.add(null);
		Node node=new Node(-1);
		int f=0;
		while(que.peek()!=null)
		{
		    while(que.peek()!=null)
		    {
		        Node n=que.remove();
		        if(n.data==key)
		        {
		            if(que.peek()!=null)
		            {
		                node=que.remove();
		                f=1;
		                break;
		            }
		        }
		        if(n.left!=null)
		        que.add(n.left);
		        if(n.right!=null)
		        que.add(n.right);
		        
		    }
		    if(f==1)
		    break;
		    que.remove();
		    que.add(null);
		    
		}
		return node;
    }
}