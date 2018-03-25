package chapter1;

import java.util.stream.Stream;

/*
    Design an algorithm and write code to remove the duplicate characters in a string
        without using any additional buffer. NOTE: One or two additional variables are fine.
        An extra copy of the array is not.
        FOLLOW UP
        Write the test cases for this method.
*/
public class removeDuplicates {

    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    public static void main(String args[]) {
        char[] chars = "Alll is well".toCharArray();
        removeDuplicates(chars);
        System.out.println(new String(chars));

    }
}
