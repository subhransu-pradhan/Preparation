package chapter1;//Implement an algorithm to determine if a string has all unique characters(not case sensitive). What if you can not use additional data structures?

import java.util.stream.Stream;

public class UniqueCharacters {

    public static void main(String args[]) {
        String string = "a A";
        System.out.println(isDuplicatePresent(string));
    }

    public static boolean isDuplicatePresent(String string) {
        char[] chars = string.toCharArray();
        boolean[] booleans = new boolean[256];

        for (char temp : chars){
            int asciiCode = (int)temp;
            asciiCode = asciiCode >= 'a' && asciiCode <= 'z'? asciiCode - 'a' + 'A' : asciiCode;
            if((asciiCode >= 'a' && asciiCode <= 'z' && booleans[asciiCode - 'a' + 'A'] == true) || booleans[asciiCode] == true){
                return true;
            } else {
                booleans[asciiCode] = true;
            }
        }
        return false;
    }
}
