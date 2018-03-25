package chapter1;
//Write a method to decide if two strings are anagrams or not.

public class AnagramsTest {

    public static boolean isAnagram(String string1, String string2){
        if (string1.length() != string2.length())
            return false;
        int[] letters = new int[256];
        for(char temp: string1.toCharArray()){
            letters[temp] ++;
        }
        for(char temp: string2.toCharArray()){
            if(letters[temp] == 0)
                return false;
            letters[temp]--;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isAnagram("aAhg","ahAj"));
    }
}