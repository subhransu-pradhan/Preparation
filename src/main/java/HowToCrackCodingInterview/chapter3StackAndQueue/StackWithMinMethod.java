package HowToCrackCodingInterview.chapter3StackAndQueue;

import HowToCrackCodingInterview.chapter3StackAndQueue.util.Node;

public class StackWithMinMethod {
    Node head;
    Node min;

    public void push(int data){
        if(head == null)
        {
            head = new Node(null, data);
            min = new Node(null, data);
        }
        else
        {
            head = new Node(head, data);
            if(min.data >= data)
                min = new Node(min, data);
        }
    }

    public Integer pop(){
        Node current = head;
        if(current == null){
            return null;
        }
        head = head.next;
        current.next = null;
        if(current.data == min.data){
            Node currentMin = min;
            min = min.next;
            currentMin.next = null;
        }
        return current.data;
    }

    public int pip(){
        return head.data;
    }

    public Integer min(){
        if(min == null){
            return null;
        }
        return min.data;
    }

    public void print(Node head){
        System.out.println();
        System.out.println();
        System.out.print("[\t");
        if(head != null) {
            System.out.print(head.data + ",\t");
            while (head.next != null) {
                head = head.next;
                System.out.print(head.data + ",\t");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println();
    }

    public static void main (String[] a){
        StackWithMinMethod stack = new StackWithMinMethod();
        stack.push(97);
        stack.push(64);
        stack.push(72);
        stack.push(75);
        stack.push(17);
        stack.push(7);
        stack.push(7);
        stack.push(78);
        stack.push(2);
        stack.push(74);

        stack.print(stack.head);
        stack.print(stack.min);

        for(int i = 0; i < 11; i++) {
            stack.pop();
            stack.print(stack.head);
            stack.print(stack.min);

            System.out.println("Min value is : " + stack.min());;
        }

    }

}
