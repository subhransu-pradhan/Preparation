package HowToCrackCodingInterview.chapter1ArrayAndString;

//Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)

public class ReverseCStyleString {

    public static String reverseCStyleString(String string){
        int length = string.length();
        char[] reverseString = string.toCharArray();
        char temp;
        for(int index = 0 ; index <= length/2 - 1; index++){
            temp = reverseString[index];
            reverseString[index] = reverseString[length-index-1];
            reverseString[length-index-1] = temp;
        }
        reverseString[5] = 0;
        return new String(reverseString);

    }

    public static void main(String a[]){
        String string = "abcdfmsd vmn vf";
        System.out.println(string);
        string = reverseCStyleString(string);
        System.out.println(string);
    }
}
