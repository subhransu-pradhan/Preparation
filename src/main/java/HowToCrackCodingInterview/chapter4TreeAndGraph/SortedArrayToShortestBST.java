package HowToCrackCodingInterview.chapter4TreeAndGraph;

import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Tree;

public class SortedArrayToShortestBST {

    public static Tree convertToBST(int[] array, int startPoint, int endPoint){

        int breakPoint = (startPoint + endPoint) / 2;
        Tree data = new Tree(array[breakPoint],
                (startPoint == breakPoint - 1) ?
                        new Tree(array[startPoint], null, null) :
                        (startPoint ==  breakPoint)? null:convertToBST(array, startPoint, breakPoint - 1),
                (endPoint == breakPoint + 1) ?
                        new Tree(array[endPoint], null, null) :
                        (endPoint == breakPoint)? null : convertToBST(array, breakPoint + 1, endPoint));
        return data;
    }

    public static void main(String args[]){
        int[] array = {1,2,3,4,5,6};
        Tree tree = convertToBST(array, 0, array.length-1);
        System.out.println(tree);
    }
}
