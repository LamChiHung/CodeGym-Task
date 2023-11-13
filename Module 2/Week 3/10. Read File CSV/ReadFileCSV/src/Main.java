import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File fileCSV = new File(".\\countries.csv");
        File test = new File(".\\test.txt");
        System.out.println(fileCSV.exists());
        try (FileReader fileReader = new FileReader(fileCSV)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            ArrayList <Country> countries = new ArrayList <>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] countryInformation = line.split(",");
                Country country = new Country(Integer.parseInt(countryInformation[0]), countryInformation[1], countryInformation[2]);
                countries.add(country);
            }
            try (FileOutputStream fos = new FileOutputStream(test)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for (Country country : countries) {
                    oos.writeObject(country);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream(test)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Country country = null;
            while ((country = (Country) ois.readObject()) != null) {
                System.out.println(country.toString());
            }
        } catch (IOException ignored) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}