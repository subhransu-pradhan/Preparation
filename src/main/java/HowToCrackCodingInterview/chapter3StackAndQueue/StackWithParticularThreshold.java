package HowToCrackCodingInterview.chapter3StackAndQueue;

import HowToCrackCodingInterview.chapter3StackAndQueue.util.Node;
import HowToCrackCodingInterview.chapter3StackAndQueue.util.Stack;

import java.util.stream.IntStream;

class NodeWithSize extends Node {

    int size;
    Stack stack = new Stack();

    @Override
    public String toString() {
        return "NodeWithSize{" +
                "size=" + size +
                ", stack=" + stack +
                '}';
    }
}

public class StackWithParticularThreshold extends Stack{

    NodeWithSize parentStack;
    int threshold = 5;

    @Override
    public String toString() {
        return "StackWithParticularThreshold{" +
                "parentStack=" + parentStack +
                ", threshold=" + threshold +
                '}';
    }

    @Override
    public void push(int data){
        if(parentStack == null)
        {
            parentStack = new NodeWithSize();
            parentStack.stack.push(data);
        }
        else if (parentStack.size == threshold)
        {
            NodeWithSize newNode = new NodeWithSize();
            newNode.next = parentStack;
            parentStack = newNode;
            parentStack.stack.push(data);
        }
        else if (parentStack.size != threshold)
        {
            parentStack.stack.push(data);
        }
        parentStack.size++;


    }

    @Override
    public Integer pop(){
        NodeWithSize current = parentStack;
        if(current == null){
            return null;
        }
        else if(parentStack.size == 1) {
            parentStack = (NodeWithSize) parentStack.next;
            current.next = null;
        } else {
            parentStack.size--;
        }
        return current.stack.pop();
    }

    public static void main(String[] args){
        StackWithParticularThreshold stack = new StackWithParticularThreshold();
        IntStream.range(1,45).forEach(data -> stack.push(data));
        System.out.println(stack);

        System.out.println();
        IntStream.range(1,46).forEach(data -> System.out.print(stack.pop() + "\t"));
    }
}
