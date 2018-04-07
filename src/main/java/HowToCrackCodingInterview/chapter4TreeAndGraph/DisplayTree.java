package HowToCrackCodingInterview.chapter4TreeAndGraph;

import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Node;
import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Tree;

class StackOfTree{
    Node<Tree> head;

    public void push(Tree tree) {
        head = new Node<Tree>(head, tree);
    }

    public Tree pop(){
        Node<Tree> current = head;
        if(current == null)
            return null;
        head = head.getNext();
        current.setNext(null);
        return current.getData();
    }

    public Tree peak(){
        if(head == null)
            return null;
        return head.getData();
    }
}

public class DisplayTree {

    public static StringBuilder preOrderDisplay(Tree tree){
        StringBuilder string = new StringBuilder(tree.getData() + "").append(", ");
        if(tree.getLeft() != null)
            string.append(preOrderDisplay(tree.getLeft()));
        if(tree.getRight() != null)
            string.append(preOrderDisplay(tree.getRight()));
        return string;
    }

    public static StringBuilder preOrderDisplayWithOutRecursion(Tree tree){
        StringBuilder stringBuilder = new StringBuilder();
        StackOfTree stackOfTree = new StackOfTree();
        stackOfTree.push(tree);
        while (stackOfTree.peak() != null){
            Tree node = stackOfTree.pop();
            stringBuilder.append(node.getData()).append(", ");
            if(node.getRight() != null) stackOfTree.push(node.getRight());
            if(node.getLeft() != null) stackOfTree.push(node.getRight());
        }
        return stringBuilder;
    }

    public static StringBuilder inOrderDisplay(Tree tree){
        StringBuilder string = null;

        if(tree.getLeft() != null)
            string = inOrderDisplay(tree.getLeft());

        if (string == null)
            string = new StringBuilder();

        string.append(tree.getData() + "").append(", ");

        if(tree.getRight() != null)
            string.append(inOrderDisplay(tree.getRight()));

        return string;
    }

    public static StringBuilder inOrderDisplayWithOutRecursion(Tree tree) {
        StringBuilder stringBuilder = new StringBuilder();
        StackOfTree stackOfTree = new StackOfTree();
        Tree current = tree;
        boolean done = false;

        while (!done) {
            if (current != null) {
                stackOfTree.push(current);
                current = current.getLeft();
            } else {
                if (stackOfTree.peak() != null) {
                    current = stackOfTree.pop();
                    stringBuilder.append(current.getData()+", ");
                    current = current.getRight();
                } else
                    done = true;
            }
        }
        return stringBuilder;
    }

    public static StringBuilder postOrderDisplay(Tree tree){
        StringBuilder string = null;

        if(tree.getLeft() != null)
            string = postOrderDisplay(tree.getLeft());

        if(tree.getRight() != null)
            string.append(postOrderDisplay(tree.getRight()));

        if (string == null)
            string = new StringBuilder();

        string.append(tree.getData() + "").append(", ");

        return string;
    }


    public static StringBuilder postOrderDisplayWithOutRecursion(Tree tree) {
        StringBuilder stringBuilder = new StringBuilder();
        StackOfTree stackOfTree = new StackOfTree();
        Tree current = tree;
        Tree temp = null;
        boolean done = false;
        boolean left = true;

        while (!done) {
            if (current != null) {
                if(current.getRight() != null)
                    stackOfTree.push(current.getRight());
                stackOfTree.push(current);
                current = current.getLeft();
            } else if (current == null) {
                current = stackOfTree.pop();
                if(current == null){
                    done = true;
                }else if(current.getRight() == stackOfTree.peak()){
                    temp = stackOfTree.pop();
                    stackOfTree.push(current);
                    current = temp;
                } else {
                    stringBuilder.append(current.getData() + ", ");
                    current = null;
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder morrisTraversalPreorder(Tree node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {

            // If left child is null, print the current node data. Move to
            // right child.
            if (node.getLeft() == null) {
                stringBuilder.append(node.getData() + ", ");
                node = node.getRight();
            } else {

                // Find inorder predecessor
                Tree current = node.getLeft();
                while (current.getRight() != null && current.getRight() != node) {
                    current = current.getRight();
                }

                // If the right child of inorder predecessor already points to
                // this node
                if (current.getRight() == node) {
                    current.setRight(null);
                    node = node.getRight();
                }

                // If right child doesn't point to this node, then print this
                // node and make right child point to this node
                else {
                    stringBuilder.append(node.getData() + ", ");
                    current.setRight(node);
                    node = node.getLeft();
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder morrisTraversalInOrder(Tree node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {

            // If left child is null, print the current node data. Move to
            // right child.
            if (node.getLeft() == null) {
                stringBuilder.append(node.getData() + ", ");
                node = node.getRight();
            } else {

                // Find inorder predecessor
                Tree current = node.getLeft();
                while (current.getRight() != null && current.getRight() != node) {
                    current = current.getRight();
                }

                // If the right child of inorder predecessor already points to
                // this node
                if (current.getRight() == node) {
                    stringBuilder.append(node.getData() + ", ");
                    current.setRight(null);
                    node = node.getRight();
                }

                // If right child doesn't point to this node and make right child point to this node
                else {
                    current.setRight(node);
                    node = node.getLeft();
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder postOrderTraversalWitoutStack(Tree head) {

        StringBuilder stringBuilder = new StringBuilder();
        Tree temp = head;
        while (temp != null && temp.isVisited() == false) {

            // Visited left subtree
            if (temp.getLeft() != null && temp.getLeft().isVisited() == false)
                temp = temp.getLeft();

                // Visited right subtree
            else if (temp.getRight() != null && temp.getRight().isVisited() == false)
                temp = temp.getRight();

                // Print node
            else {
                stringBuilder.append( temp.getData() + ", ");
                temp.setVisited( true );
                temp = head;
            }
        }
        return  stringBuilder;
    }

    public static void main(String args[]){
        Tree tree = Tree.createLevel3Tree();
        System.out.println();

        System.out.println("[" + morrisTraversalPreorder(tree) + "\b\b ]");
        System.out.println("[" + preOrderDisplay(tree) + "\b\b ]");
        System.out.println("[" + preOrderDisplayWithOutRecursion(tree) + "\b\b ]\n");

        System.out.println("[" + inOrderDisplay(tree) + "\b\b ]");
        System.out.println("[" + morrisTraversalInOrder(tree) + "\b\b ]");
        System.out.println("[" + inOrderDisplayWithOutRecursion(tree) + "\b\b ]\n");

        System.out.println("[" + postOrderDisplay(tree) + "\b\b ]");
        System.out.println("[" + postOrderDisplayWithOutRecursion(tree) + "\b\b ]");
        System.out.println("[" + postOrderTraversalWitoutStack(tree) + "\b\b ]\n");
    }
}
