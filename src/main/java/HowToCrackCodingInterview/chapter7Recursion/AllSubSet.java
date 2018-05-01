package HowToCrackCodingInterview.chapter7Recursion;

import java.lang.reflect.Array;
import java.util.*;

public class AllSubSet {
    static ArrayList<ArrayList<Integer>> allSubSet = new ArrayList<>();


    public static ArrayList<ArrayList<Integer>> addCurrentElement(List<Integer> data, int index, ArrayList<ArrayList<Integer>> allSubSet){
        ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>();
        for(ArrayList<Integer> oldSubSet: allSubSet){
            ArrayList<Integer> newSubSet = ((ArrayList<Integer>)oldSubSet.clone());
            newSubSet.add(data.get(index));
            newSubsets.add(newSubSet);
        }
        return newSubsets;
    }

    public static ArrayList<ArrayList<Integer>> returnSubset(List<Integer> data, int index){
        ArrayList<ArrayList<Integer>> allSubSet;

        if(data.size() == index) {
            allSubSet = new ArrayList<>();
            allSubSet.add(new ArrayList<>());
        } else {
            allSubSet = returnSubset(data, index+1);
            allSubSet.addAll(addCurrentElement(data, index, allSubSet));
        }
        return allSubSet;
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4);
        allSubSet = returnSubset(data, 0);
        System.out.print(allSubSet);
    }
}
