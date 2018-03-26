package HowToCrackCodingInterview.chapter2LinkedList;

public class Node {
    Node next;
    int data;

    public Node(){

    }

    public Node(Node node, int data) {
        this.next = node;
        this.data = data;
    }

    public Node next(){
        return  next;
    }
}
