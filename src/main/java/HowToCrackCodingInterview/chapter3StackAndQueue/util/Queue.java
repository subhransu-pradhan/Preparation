package HowToCrackCodingInterview.chapter3StackAndQueue.util;

public class Queue {
    Node head;
    Node tail;

    public void push(int data){
        if(head == null) {
            head = new Node(null, data);
            tail = head;
        }
        else {
            Node newNode = new Node(null, data);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer pop(){
        Node current = head;
        if(current == null){
            return null;
        }
        head = head.next;
        current.next = null;
        return current.data;
    }

    public int pip(){
        return head.data;
    }
}
