package HowToCrackCodingInterview.chapter5BitManipulation;

import java.util.Arrays;

public class RightMostBit {
    //Write a one line C function to return position of first 1 from right to left, in binary representation of an Integer.


        public static void getBits(int input)
        {
            //int input = 15;

            boolean[] bits = new boolean[16];
            for (int i = 15; i >= 0; i--) {
                bits[i] = (input & (1 << i)) != 0;
            }

            System.out.println(input + " = " + Arrays.toString(bits));
        }

        public static int getFirstSetBitPos(int n)
        {
            System.out.println((n & -n) + "");
            System.out.println(Math.log10(n & -n) + "");
            System.out.println(Math.log10(2) + "");
            return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
        }

        // Drive code
        public static void main(String[] args)
        {
            int n = 8;
            getBits(n);
            getBits(-n);
            System.out.println(getFirstSetBitPos(n));

        }

}
