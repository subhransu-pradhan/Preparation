package HowToCrackCodingInterview.chapter2LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNode {

    public static void removeDuplicateWithoutUsingBuffer(Node head) {
        if(head == null){
            return;
        }
        Node prev = head;
        Node current = head.next;
        while(current != null) {
            Node uniqueSet = head;
            while(uniqueSet != current) {
                if (uniqueSet.data == current.data) {
                    prev.next = current.next;
                    current.next = null;
                    current = prev.next;
                    break;
                } else {
                    uniqueSet = uniqueSet.next;
                }
            }
            current = current.next;
            current = current.next;
        }
    }

    public static void removeDuplicateUsingBuffer(Node head) {
        Set set = new HashSet<Integer>();
        if(head == null){
            return;
        }
        Node prev = head, current = head.next;
        set.add(head.data);
        while(current != null) {
            if(!set.add(current.data)) {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
            }
            else {
                current = current.next;
                prev = prev.next;
            }
        }
    }

    public static void printNodes(Node head) {
        System.out.println();
        System.out.println();
        System.out.print("[\t" + head.data);
        while(head.next != null){
            head  = head.next;
            System.out.print(",\t" + head.data);
        }
        System.out.print("]");
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
        printNodes(node);

        removeDuplicateUsingBuffer(node);

        printNodes(node);
    }
}
