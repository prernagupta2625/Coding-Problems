//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{  static Node head1;
   static int c=0;
    public static Node addOne(Node head) 
    { 
        Node ptr=head;
        head1=head;
        prerna(ptr);
        return(head1);
       
        
    }
    public static int prerna(Node ptr)
    { 
        if(ptr.next!=null)
        {
            //System.out.println(ptr.data);
            c=prerna(ptr.next);
        }
        else
        {
            if(ptr==head1)
            {
                if(ptr.data>=9)
           { Node obj=new Node(1);
            obj.next=head1;
            head1=obj;
            ptr.data=0;
            head1.data=1;
            return(0); 
            }
            else
            {
                ptr.data=ptr.data+1;
                return(0);
            }
            }
            else
            {
            if(ptr.data<9)
            {
                ptr.data=ptr.data+1;
                return(0);
            }
            else
            {
              ptr.data=0;
              return(1);
            }
            }
        }
    
        if(c==1)
        {
        if( ptr.data<9)
        {
                ptr.data=ptr.data+1;
                return(0);
        }
    else {
        if(ptr==head1)
        {
            Node obj=new Node(1);
            obj.next=head1;
            head1=obj;
            ptr.data=0;
            head1.data=1;
            return(0);
        }
        else
        {
            ptr.data=0;
            return(1);
        }
    }
    }

    else{
    
    return(0);
        
    }
    }
    
}
