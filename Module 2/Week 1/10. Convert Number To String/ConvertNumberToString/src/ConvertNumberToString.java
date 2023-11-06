import java.util.Scanner;

public class ConvertNumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: 0 < 'number' < 1000");
        int number = sc.nextInt();
        int unit = 0;
        int ten = 0;
        int hundred = 0;
        String unitString = null;
        String tenString = null;
        String hundredString = null;
        String convert = null;

        if (number > 0 && number < 11) {
            unit = number;


        } else if (number > 10 && number < 100) {
            unit = number % 10;
            ten = number / 10;

        } else if (number > 99 && number < 1000) {
            unit = number % 10;
            ten = (number % 100) / 10;
            hundred = number / 100;
        }
        switch (unit) {
            case 0:
                unitString = "";
                break;
            case 1:
                unitString = "one";
                break;
            case 2:
                unitString = "two";
                break;
            case 3:
                unitString = "three";
                break;
            case 4:
                unitString = "four";
                break;
            case 5:
                unitString = "five";
                break;
            case 6:
                unitString = "six";
                break;
            case 7:
                unitString = "seven";
                break;
            case 8:
                unitString = "eight";
                break;
            case 9:
                unitString = "nine";
                break;
            case 10:
                unitString = "ten";
                break;
        }
        switch (ten) {
            case 0:
                tenString = "";
                break;
            case 1:
                if (unit == 1) {
                    convert = "eleven";
                }
                if (unit == 2) {
                    convert = "twelve";
                }
                if (unit == 3) {
                    convert = "thirteen";
                }
                if (unit == 4) {
                    convert = "fourteen";
                }
                if (unit == 5) {
                    convert = "fifteen";
                }
                if (unit == 6) {
                    convert = "sixteen";
                }
                if (unit == 7) {
                    convert = "seventeen";
                }
                if (unit == 8) {
                    convert = "eighteen";
                }
                if (unit == 9) {
                    convert = "nineteen";
                }
                break;
            case 2:
                tenString = "twenty";
                break;
            case 3:
                tenString = "thirty";
                break;
            case 4:
                tenString = "forty";
                break;
            case 5:
                tenString = "fifty";
                break;
            case 6:
                tenString = "sixty";
                break;
            case 7:
                tenString = "seventy";
                break;
            case 8:
                tenString = "eighty";
                break;
            case 9:
                tenString = "ninety";
                break;
        }
        switch (hundred) {
            case 0:
                hundredString = "";
                break;
            case 1:
                hundredString = "one hundred";
                break;
            case 2:
                hundredString = "two hundred";
                break;
            case 3:
                hundredString = "three hundred";
                break;
            case 4:
                hundredString = "four hundred";
                break;
            case 5:
                hundredString = "five hundred";
                break;
            case 6:
                hundredString = "six hundred";
                break;
            case 7:
                hundredString = "seven hundred";
                break;
            case 8:
                hundredString = "eight hundred";
                break;
            case 9:
                hundredString = "nine hundred";
                break;
        }
        if (convert == null) {
            convert = hundredString + " " + tenString + " " + unitString;
        }
        System.out.println(convert);
    }
}
