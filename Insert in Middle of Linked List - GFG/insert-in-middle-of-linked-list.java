//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();   
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();
            
            //display(head);
            Solution obj = new Solution();
            obj.insertInMid(head, key);
            display(head);
            System.out.println();
        }
    }
    
    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
    public Node insertInMid(Node head, int data){
        Node start=head;
        int count=0;
         Node obj=new Node(data);
        //Insert code here, return the head of modified linked list
        if(start==null)
        {
            head=obj;
        }
        else
        {
        while(start!=null)
        {
            count++;
            start=start.next;
        }
        if(count%2==0)
        count=count/2;
        else
        count=count/2+1;
        count--;
        Node start2=head;
        while(count>0)
        {
            start2=start2.next;
            count--;
        }
       
        obj.next=start2.next;
        start2.next=obj;
        }
        return(head);
        
    }
}