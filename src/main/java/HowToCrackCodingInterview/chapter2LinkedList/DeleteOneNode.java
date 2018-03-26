package HowToCrackCodingInterview.chapter2LinkedList;

public class DeleteOneNode {

    public static void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String args[]) {
        Node node = new Node(null, 7);
        node = new Node(node, 7);
        node = new Node(node, 7);
        node = new Node(node, 1);
        node = new Node(node, 1);
        Node node1 = new Node(node, 2);
        node = new Node(node1, 4);
        node = new Node(node, 3);
        node = new Node(node, 3);
        node = new Node(node, 4);
        node = new Node(node, 4);
        LinkListUtil.printNodes(node);
        deleteNode(node1);
        LinkListUtil.printNodes(node);
    }
}
