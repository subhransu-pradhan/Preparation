package HowToCrackCodingInterview.chapter2LinkedList;

public class FindHeadOfCircularLinkedList {

    public static void removeTheCycle(Node head){
        Node nodeSlow = head.next;
        Node nodeFast = head.next.next;
        while (nodeSlow != nodeFast){
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
        }
        Node previous = nodeSlow;
        while (nodeSlow != head){
            previous = nodeSlow;
            nodeSlow = nodeSlow.next;
            head = head.next;
        }
        previous.next = null;
    }

    public static void main(String args[]) {

        Node node1 = new Node(null, 1);
        Node node = new Node(node1, 2);
        node = new Node(node, 3);
        node = new Node(node, 4);
        node = new Node(node, 5);
        node = new Node(node, 6);
        node1.next = node;
        node = new Node(node1, 7);
        node = new Node(node, 8);
        node = new Node(node, 9);
        node = new Node(node, 10);
        node = new Node(node, 11);
        node = new Node(node, 12);

        removeTheCycle(node);
        LinkListUtil.printNodes(node);

    }
}
