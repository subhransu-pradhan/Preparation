package HowToCrackCodingInterview.chapter3StackAndQueue;

import HowToCrackCodingInterview.chapter3StackAndQueue.util.Stack;

public class MyQueue {
    Stack[] stacks;
    int masterStackIndex;

    public MyQueue() {
        stacks = new Stack[2];
        masterStackIndex = 0;
        stacks[0] = new Stack();
        stacks[1] = new Stack();
    }

    public void push(int data){
        if(masterStackIndex == 1)
        {
            reorderTheStack();
        }
        stacks[masterStackIndex].push(data);
    }

    public void alterMasterIndex(){
        if(masterStackIndex == 0){
            masterStackIndex = 1;
        } else {
            masterStackIndex = 0;
        }
    }

    public Integer pop() {
        if (stacks[masterStackIndex] == null) {
            return null;
        }
        if(masterStackIndex == 0)
        {
            reorderTheStack();
        }
        return stacks[masterStackIndex].pop();
    }

    private void reorderTheStack() {
        int currentMaster = masterStackIndex;
        alterMasterIndex();
        while (stacks[currentMaster].hasNext()) {
            stacks[masterStackIndex].push(stacks[currentMaster].pop());
        }
    }

    public static void main(String[] a){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        queue.push(5);

        System.out.println(queue.pop());
        queue.push(6);
        System.out.println(queue.pop());
        queue.push(7);
        System.out.println(queue.pop());
        queue.push(8);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
