package HowToCrackCodingInterview.chapter2LinkedList;

public class LinkListUtil {

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
}
