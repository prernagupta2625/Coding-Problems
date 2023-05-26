//{ Driver Code Starts
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

class GFG {
    
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
    static void printInorder(Node root){
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
            String s = br.readLine();
	    	Node root = buildTree(s);
	    	
            Solution ob = new Solution();
    		System.out.println(ob.maxGCD(root));
            t--;
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    static int maxgcd,maxnode;
    int maxGCD(Node root) {
        maxgcd=0;
        maxnode=0;
        Solution pre=new Solution();
        pre.traverse(root);
        return(maxnode);
    }
    void traverse(Node node)
    {
        int gcd;
        Solution obj=new Solution();
        if(node.left!=null && node.right!=null)
       { 
           
        gcd=calgcd(node.left.data,node.right.data);
        if(gcd==maxgcd)
        {if(node.data>maxnode)
        maxnode=node.data;;}
        else if(gcd>maxgcd)
        {
            maxgcd=gcd;
            maxnode=node.data;
        }
         
       }
      
       if(node.left!=null)
       traverse(node.left);
       if(node.right!=null)
       traverse(node.right);
        
    }
    public int calgcd(int a,int b)
    {
      
        if(a==0)
        return b;
        else if(b==0)
        return a;
        else if(a==b)
        return a;
        else if(a>b)
        return calgcd(a-b,b);
        else
        return calgcd(a,b-a);
    }
}

