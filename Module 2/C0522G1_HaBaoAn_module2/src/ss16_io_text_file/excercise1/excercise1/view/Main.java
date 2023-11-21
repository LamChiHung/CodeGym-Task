package ss16_io_text_file.excercise1.excercise1.view;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tập tin nguồn");
        String str = scanner.nextLine();
        System.out.println("Mời bạn nhập vào tập tin đích");
        String str1 = scanner.nextLine();

        StringBuilder temp = new StringBuilder();
        String line = "";

        try {
            File file = new File(str);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                temp.append(line).append("\n");
            }

            temp.delete(temp.length()-1,temp.length());
            bufferedReader.close();

        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("File không tồn tại,vui lòng nhập lại đường dẫn");


        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter(str1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(temp.toString());
            System.out.println("Đã sao chép thành công");
            System.out.println("Số kí tự trong file là: " + temp.length());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File đích đã có vui lòng tạo lại");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


}

