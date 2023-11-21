package ss11_dsa_stack_queue.excercise;

import java.util.*;

public class Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> stringIntegerMap = new TreeMap<>();
        System.out.println("Nhập vào chuỗi");
        String string = scanner.nextLine();
       String[] arrays = string.toUpperCase().split(" ");
       for (String str : arrays){
           if (!stringIntegerMap.containsKey(str)){
               stringIntegerMap.put(str,1);
           }else {
               int count = stringIntegerMap.get(str);
               stringIntegerMap.put(str,count+1);
           }
       }
        System.out.println(stringIntegerMap);


    }
}
