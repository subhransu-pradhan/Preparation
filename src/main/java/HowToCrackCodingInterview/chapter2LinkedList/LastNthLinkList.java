package HowToCrackCodingInterview.chapter2LinkedList;

public class LastNthLinkList {

    public static Node splitLinkList(Node head, int n){
        Node tail = head;
        while (n-- != 0) {
            tail = tail.next;
            if(tail == null){
                return null;
            }
        }
        while (tail != null){
            tail = tail.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String args[]) {
        Node node = new Node(null, 7);
        node = new Node(node, 7);
        node = new Node(node, 7);
        node = new Node(node, 1);
        node = new Node(node, 1);
        node = new Node(node, 2);
        node = new Node(node, 4);
        node = new Node(node, 3);
        node = new Node(node, 3);
        node = new Node(node, 4);
        node = new Node(node, 4);
        LinkListUtil.printNodes(node);
        node = splitLinkList(node, 12);
        LinkListUtil.printNodes(node);
    }
}
