package module_2_final.util;

import module_2_final.model.Cars;
import module_2_final.service.impl.LicenseService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

    class WriteFileUtil {
        private static void writeFile(String path, String data) throws IOException {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
            bufferedWriter.close();
        }


        public static void writeStudentFile(String path, Map<Cars, LicenseService> students) throws IOException {
            StringBuilder data = new StringBuilder();

            Set<Cars> studentSet = students.keySet();

            for (Cars student : studentSet) {
                data.append(student.getInfo()).append(",").append(students.get(student)).append("\n");
            }
            writeFile(path, data.substring(0, data.length() - 1));
        }

    }

