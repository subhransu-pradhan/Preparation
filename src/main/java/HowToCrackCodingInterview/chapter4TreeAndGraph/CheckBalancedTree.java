package HowToCrackCodingInterview.chapter4TreeAndGraph;

import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Node;
import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Tree;

public class CheckBalancedTree {

    static int highestDepth = -1;
    static int lowestDepth = -1;

    int count = 1;

    public boolean checkIsBalanced(Tree tree, int currentDepth){
        System.out.println(count++ +" ");
        if(tree.getLeft() == null && tree.getRight() == null){
            if(highestDepth < currentDepth){
                highestDepth = currentDepth;
            }
            if(lowestDepth > currentDepth || lowestDepth == -1){
                lowestDepth = currentDepth;
            }
            if(highestDepth - lowestDepth > 1){
                return false;
            }
        }
        if (tree.getLeft() != null){
            if(!checkIsBalanced(tree.getLeft(), currentDepth+1))
                return false;
        }
        if (tree.getRight() != null){
            if(!checkIsBalanced(tree.getRight(), currentDepth+1))
                return false;
        }
        return true;
    }

    public boolean checkIsBalancedUsingQueue(Tree tree){
        Node<Tree> current = new Node<>(null, tree);
        Node<Tree> next = null;

        int currentDepth = 0;
        int count = 1;

        while (current != null) {
            currentDepth++;
            if(lowestDepth != -1 && currentDepth - lowestDepth > 1) {
                return false;
            }

            while (current != null){
                if(current.getData().getLeft() == null && current.getData().getRight() == null){
                    if(lowestDepth == -1) {
                        lowestDepth = currentDepth;
                    }
                }
                if(current.getData().getLeft() != null) next = new Node<>(next, current.getData().getLeft());
                if(current.getData().getRight() != null) next = new Node<>(next, current.getData().getRight());
                current = current.getNext();
                System.out.println(count++ +" ");
            }
            current = next;
            next = null;
        }
        return true;
    }

    public static void main(String args[]){
        Tree tree = Tree.createTreeNew();
        System.out.println(new CheckBalancedTree().checkIsBalanced(tree, 1));
        //System.out.println(new CheckBalancedTree().checkIsBalancedUsingQueue(tree));
    }
}
