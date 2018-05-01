package HowToCrackCodingInterview.chapter4TreeAndGraph;

import HowToCrackCodingInterview.chapter3StackAndQueue.util.Stack;

import java.util.ArrayList;

class Node1{
    int data;
    Node1 left, right;
    Node1(int value) {
        data = value;
        left = right = null;
    }
}

class StackNode1{
    int data;
    StackNode1 previous;
    StackNode1 next;

    public StackNode1() {

    }

    public StackNode1(int data, StackNode1 previous) {
        this.data = data;
        this.previous = previous;
        previous.next = this;
    }
}

public class FindAncestor {

    static StackNode1 path1 = new StackNode1();
    static StackNode1 path2 = new StackNode1();

    public static Integer findAncestor(Node1 tree, int data1, int data2) {

        StackNode1 path1Temp = path1;
        StackNode1 path2Temp = path2;

        findPath(tree, data1, path1);
        findPath(tree, data2, path2);

        if((path1.next == null) || (path2.next == null)){
            if(path1.next == null){
                System.out.print("No path for node 1.");
            } else {
                System.out.print("No path for node 2.");
            }
            return null;
        }

        while((path1Temp != null || path2Temp != null) && (path1Temp.data == path2Temp.data)){
            path1Temp = path1Temp.next;
            path2Temp = path2Temp.next;
        }

        if(path1Temp == null || path2Temp == null){
            return null;
        }

        return path1Temp.previous.data;
    }

    public static boolean findPath(Node1 tree, int data, StackNode1 path){
        path = new StackNode1(tree.data, path);

        if(tree.data == data)
            return true;
        else if(tree.left != null && findPath(tree.left, data, path))
            return true;
        else if(tree.right != null && findPath(tree.right, data, path))
            return true;

        StackNode1 tempPath = path.previous;
        tempPath.next = null;
        path.previous = null;
        path = tempPath;
        return false;
    }

    public static void main(String[] args){
        Node1 node1 = new Node1(1);
        node1.left = new Node1(11);
        node1.right = new Node1(12);
        node1.left.left = new Node1(21);
        node1.left.right = new Node1(22);
        node1.right.left = new Node1(23);
        node1.right.right = new Node1(24);

        System.out.println(findAncestor(node1, 21, 22));
        System.out.println(findAncestor(node1, 21, 24));
        System.out.println(findAncestor(node1, 11, 24));
        System.out.println(findAncestor(node1, 11, 25));
        System.out.println(findAncestor(node1, 26, 25));
    }
}
