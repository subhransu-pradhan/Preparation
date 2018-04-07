package HowToCrackCodingInterview.chapter3StackAndQueue.util;

import HowToCrackCodingInterview.chapter3StackAndQueue.util.Queue;
import HowToCrackCodingInterview.chapter3StackAndQueue.util.Stack;

public class TestStackAndQueue {

    public static void main (String[] args){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
