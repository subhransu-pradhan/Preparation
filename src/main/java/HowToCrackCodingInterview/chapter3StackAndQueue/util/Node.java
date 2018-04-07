package HowToCrackCodingInterview.chapter3StackAndQueue.util;

public class Node {
    public Node next;
    public int data;

    public Node(){

    }

    public Node(Node node, int data) {
        this.next = node;
        this.data = data;
    }

    public Node next(){
        return  next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
