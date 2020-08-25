package practice.selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new FileReader("src/test/resources/studentrecords-1.csv"));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(",");
                System.out.println("address - " + data[0] + ", firstName - " + data[1] + ", lastName - " + data[2]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
