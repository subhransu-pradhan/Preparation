package HowToCrackCodingInterview.chapter2LinkedList;

public class AddTwoNumbers {

    public static Node sumNodes(Node node, Node node1){
        if(node == null && node1 == null){
            return null;
        }
        int sum = ((node == null)? 0 : node.data) + ((node1 == null)? 0 : node1.data);
        Node result = new Node(null, sum % 10);
        Node resultHead = result;
        int carry = sum/10;
        while(node != null || node1 != null || carry != 0){
            node = node == null? null :node.next;
            node1 = node1 == null ? null :node1.next;
            sum = ((node == null)? 0 : node.data) + ((node1 == null)? 0 : node1.data) + carry;
            result.next = new Node(null, sum % 10);
            result = result.next;
            carry = sum/10;
        }
        return resultHead;
    }

    public static void main(String args[]) {
        Node node = new Node(null, 7);
        node = new Node(node, 7);
        node = new Node(node, 7);
        node = new Node(node, 1);
        node = new Node(node, 1);
        Node node1 = new Node(null, 9);
        node1 = new Node(node1, 4);
        node1 = new Node(node1, 3);
        node1 = new Node(node1, 3);
        node1 = new Node(node1, 4);
        node1 = new Node(node1, 4);
        LinkListUtil.printNodes(node1);
        LinkListUtil.printNodes(node);
        Node result = sumNodes(node1, node);
        LinkListUtil.printNodes(result);
    }
}
