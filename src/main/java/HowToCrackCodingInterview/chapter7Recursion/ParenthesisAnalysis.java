package HowToCrackCodingInterview.chapter7Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Stack {
    Tree data;
    Stack next;

    public Stack(Tree data, Stack next) {
        this.data = data;
        this.next = next;
    }
}

class Tree{
    String data;
    int openedCount;
    int count;
    Tree left;
    Tree right;

    public Tree(String data, int openedCount, int count) {
        this.data = data;
        this.openedCount = openedCount;
        this.count = count;
    }

    @Override
    public String toString() {
        return  data +
                (left != null ? left: " ") +
                (right != null ? right: " ") ;
    }
}
public class ParenthesisAnalysis {

    public static void main(String[] args){
        int count = 4;

        Tree tree = new Tree("(", 1, count-1);
        Stack stack = new Stack(tree, null);
        List<String> dataCollection = new ArrayList<>();
        Set<String> dataCollection2 = new HashSet<>();
        while (stack != null){
            Tree data = stack.data;

            Stack current = stack;
            stack = stack.next;
            current.next = null;

            if(data.count == 0 && data.openedCount == 0)
            {
                dataCollection.add(data.data);
                dataCollection2.add(data.data);
            }
            if(data.count > 0)
            {
                data.left = new Tree(data.data + "(", data.openedCount + 1 , data.count - 1);
                stack = new Stack(data.left, stack);
            }
            if(data.openedCount > 0)
            {
                data.right = new Tree(data.data + ")", data.openedCount - 1 , data.count);
                stack = new Stack(data.right, stack);
            }
        }

        System.out.println(dataCollection);
        System.out.println(dataCollection2);

    }
}