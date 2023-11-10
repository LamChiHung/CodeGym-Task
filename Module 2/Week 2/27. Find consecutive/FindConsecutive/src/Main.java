import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String string = "abcdabcdgabxy";
        ArrayList <String> list = new ArrayList <>();
        ArrayList <String> listTemp = new ArrayList <>();
        for (int i = 0; i < string.length(); i++) {
            String stringChar = String.valueOf(string.charAt(i));
            if (listTemp.isEmpty()) {
                listTemp.add(stringChar);
            } else if (! stringChar.equals(listTemp.get(0))) {
                listTemp.add(stringChar);
            } else {
                if (listTemp.size() > list.size()) {
                    list = (ArrayList <String>) listTemp.clone();
                }
                listTemp.clear();
                listTemp.add(stringChar);
            }
        }
        System.out.println(list.toString());
    }
}