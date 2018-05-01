package HowToCrackCodingInterview.chapter5BitManipulation.util;

public class BitCovertion {
    public static String convertToBitArray(int input, String string){
        String data = "";
        for (int i = 31; i >= 0; i--) {
            if( (input & (1 << i)) != 0)
                data = data + "1";
            else
                data = data + "0";
        }

        System.out.println( data + " -> " + string);
        return data;
    }

    public static int convertBinaryToDecimal(String input, String string){
        int data = 0;
        char[] chars = input.toCharArray();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if(chars[length - i - 1] == '1'){
                data = data + (int)(Math.pow(2,i));
            }
        }

        System.out.println(data + " -> " + string);
        return data;
    }
}
