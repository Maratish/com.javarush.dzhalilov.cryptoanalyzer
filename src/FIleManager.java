import java.io.*;
import java.util.Scanner;

public class FIleManager {

    public static String readFile() {
        StringBuilder originalText = new StringBuilder();
        System.out.println("Введите путь к исходному документу:");
        String strInputFile = Validator.validateInputPath(new Scanner(System.in));
        try (BufferedReader bfr = new BufferedReader(new FileReader(strInputFile))) {
            String s;
            while ((s = bfr.readLine()) != null) {
                originalText.append(s);
            }
        } catch (Exception e) {
            System.out.println("Ошибка"+e);;
        }
        return originalText.toString();
    }


    public static void writeFile(String writingText) {

        System.out.println("Куда сохранить результат?:");
        String strOutputFile = Validator.validateOutputPath(new Scanner(System.in));

        try (BufferedWriter bfwr = new BufferedWriter(new FileWriter(strOutputFile))) {
            bfwr.write(writingText);
        } catch (RuntimeException | IOException e) {
            System.out.println("Ошибка" + e);
        }
    }
}

