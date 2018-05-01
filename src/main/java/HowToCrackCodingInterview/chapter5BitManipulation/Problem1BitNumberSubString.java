package HowToCrackCodingInterview.chapter5BitManipulation;

import HowToCrackCodingInterview.chapter5BitManipulation.util.BitCovertion;

import java.util.Arrays;

public class Problem1BitNumberSubString {

    public static void main(String args[]){

        String N = "1011010011010";
        String M = "10010";
        int i = 2, j = 6;

        int intN = BitCovertion.convertBinaryToDecimal(N, "N");
        int intM = BitCovertion.convertBinaryToDecimal(M, "M");

        int max = ~0;

        int left = max - ((1 << j) - 1);

        int right = ((1 << i) - 1);


        int data = left | right;

        data = data & intN;

        intM = intM<<i;

        data = data | intM;

        BitCovertion.convertToBitArray(data, "data");


    }
}
