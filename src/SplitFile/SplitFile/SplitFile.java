package SplitFile.SplitFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {
    static String filePath = "C:\\Users\\Adam\\Project\\MyApplicationsProject\\src\\SplitFile\\files";

    public static void main(String args[]) throws IOException {
        readFileAndSave("plik");

    }

    private static void readFileAndSave(String file) throws IOException {
        String fileName = filePath + "\\" + file;
        FileReader fileReader = new FileReader(fileName);
        File fileOut = new File(filePath + "\\podzielony");
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (fileOut.length() < 1000) {
                    fileOutputStream = new FileOutputStream(fileOut, true);
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } else {
                    fileOut = new File(filePath + "\\podzielony" + file.length());
                    fileOutputStream = new FileOutputStream(file);
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        }
    }
}
