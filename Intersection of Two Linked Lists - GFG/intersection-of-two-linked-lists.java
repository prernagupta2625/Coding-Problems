//{ Driver Code Starts
//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Solution obj = new Solution();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
        Node ptr1,ptr2;
        ptr1=head2;
        ptr2=head1;
        while(ptr1!=null)
        {
            mp.put(ptr1.data,1);
            ptr1=ptr1.next;
        }
        while(ptr2.next!=null)
        {
            if(ptr2==head1 && !mp.containsKey(ptr2.data))
            {
                   head1=ptr2.next;
                     ptr2=ptr2.next;
                 
                
                 
            }
            else
            {
            if(!mp.containsKey(ptr2.next.data))
            {
                ptr2.next=ptr2.next.next;
            }
            else
            ptr2=ptr2.next;
            }
        }
        return(head1);
        
    }
}