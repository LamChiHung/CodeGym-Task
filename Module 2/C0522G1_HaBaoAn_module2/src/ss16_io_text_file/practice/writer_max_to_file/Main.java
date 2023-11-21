package ss16_io_text_file.practice.writer_max_to_file;

import java.util.List;

public class Main {

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

        List<Integer> numbers = readAndWriteFile.readFile("src/ss16_io_text_file/excercise/file/copy_file.txt");

        int maxValue = findMax(numbers);

        readAndWriteFile.writeFile("result.txt", maxValue);

    }
}
