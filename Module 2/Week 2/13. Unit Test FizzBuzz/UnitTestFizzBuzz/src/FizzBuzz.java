public class FizzBuzz {
    public static String fizzBuzz(int number) {
        String result = "";
        if (number < 1 || number > 99) {
            return "Input number smaller than 100 and greater than 0";
        }
        String numberString = String.valueOf(number);
        int length = numberString.length();
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(numberString.charAt(i));
        }
        String[] text = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};
        for (String string : strings) {
            result += text[Integer.valueOf(string)] + " ";
        }

        return result.trim();
    }
}
