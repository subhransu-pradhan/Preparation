package HowToCrackCodingInterview.chapter5BitManipulation;

public class Problem2RealNoToBinary {

    public static void main(String[] args){
        String data = "2.625";
        String information = "";


        int beforeDecimal = Integer.parseInt(data.substring(0, data.indexOf('.')));
        double afterDecimal = Double.parseDouble(data) - beforeDecimal;

        while (beforeDecimal > 0){
            information = beforeDecimal%2 + information;
            beforeDecimal = beforeDecimal/2;
        }

        information = information + '.';

        while (afterDecimal > 0) {
            afterDecimal = afterDecimal * 2;
            if(afterDecimal >= 1)
            {
                information = information + "1";
                afterDecimal = afterDecimal - 1;
            } else {
                information = information + "0";
            }
        }

        System.out.println(information);
    }
}
