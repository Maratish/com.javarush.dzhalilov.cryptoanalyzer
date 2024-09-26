import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class FIleManager {

    public static String readFile() {
        StringBuilder originalText = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String strInputFile = null;
        System.out.println("Введите путь к исходному документу:");
        while (strInputFile == null) {
            strInputFile = scanner.nextLine();
            Path path = Paths.get(strInputFile);
            if (!Files.exists(path)) {
                System.out.println("Файла не существует. Повторите ввод");
                strInputFile = null;
            } else {
                break;
            }
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(strInputFile))){
            String s;
            while ((s = bfr.readLine()) != null) {
                originalText.append(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return originalText.toString();
    }

    public static void writeFile(String writingText) {
        Scanner scanner = new Scanner(System.in);
        String strOutputFile = null;
        System.out.println("Куда сохранить результат?:");
        while (strOutputFile == null) {
            strOutputFile = scanner.nextLine();
            try {
                Path pathOutputFile = Paths.get(strOutputFile);
                if (Files.exists(pathOutputFile) && Files.isDirectory(pathOutputFile)) {
                    Path newPath = Paths.get(pathOutputFile.toString() +"\\newDocument.txt");
                    if (!Files.exists(newPath)) {
                        Files.createFile(newPath);
                        strOutputFile = newPath.toString();
                        break;
                    } else {
                        System.out.println("Файл уже существует");
                        strOutputFile=null;
                        continue;
                    }
                } if (Files.exists(pathOutputFile) && Files.isRegularFile(pathOutputFile)) {
                    break;
                } else {
                    System.out.println("Введите корректный путь");
                    strOutputFile=null;
                }
            } catch (InvalidPathException | IOException e) {
                strOutputFile = null;
                System.out.println("Введите корректный путь");
            }
        }

        try (BufferedWriter bfwr = new BufferedWriter(new FileWriter(strOutputFile))){
            bfwr.write(writingText);
        } catch (RuntimeException| IOException e) {
            System.out.println("Ошибка" + e);
        }
    }
}

