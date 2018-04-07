package HowToCrackCodingInterview.chapter4TreeAndGraph.util;

public class Node <T> {
    public Node next;
    public T data;

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(Node node, T data) {
            this.next = node;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", data=" + data +
                    '}';
        }
}
