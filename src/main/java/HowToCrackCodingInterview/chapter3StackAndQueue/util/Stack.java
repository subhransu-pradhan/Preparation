package HowToCrackCodingInterview.chapter3StackAndQueue.util;

public class Stack {
    Node head;

    public boolean hasNext(){
        return head != null;
    }

    public void push(int data){
        if(head == null)
            head = new Node(null, data);
        else
            head = new Node(head, data);
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

    @Override
    public String toString() {
        return "Stack{" +
                "head=" + head +
                '}';
    }
}
