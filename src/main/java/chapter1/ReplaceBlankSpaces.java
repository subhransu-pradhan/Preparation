package chapter1;

public class ReplaceBlankSpaces {

    public static String replaceBlankSpaces(String string){
        char[] chars = string.toCharArray();
        int count = 0;
        for (char temp:chars){
            if(temp == ' ')
                count++;
        }
        char[] replaced = new char[chars.length + count*2];
        int index = 0;
        for(char temp: chars){
            if(temp==' '){
                replaced[index++] = '%';
                replaced[index++] = '2';
                replaced[index++] = '0';
            } else {
                System.out.println(temp);
                replaced[index++] = temp;
            }
        }
        return new String(replaced);
    }

    public static void main(String args[]) {
        char a = ' ';
        System.out.println(a == ' ');
       // System.out.println(' '.equals(' '));
        System.out.println(replaceBlankSpaces("All is well . "));
    }
}
