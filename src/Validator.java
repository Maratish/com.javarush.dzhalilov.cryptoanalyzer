import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int validateKey(Scanner scanner) {
        int key = -1;
        while (true) {
            try {
                key = scanner.nextInt();
                if (!(key <= 0 || key > (Alphabet.alphabet_Map.size() - 1))) {
                    break;
                } else {
                    System.out.println("Введите число от 0 до " + (Alphabet.alphabet_Map.size() - 1));
                }
            } catch (InputMismatchException | NumberFormatException e) {
                scanner.nextLine();
                System.out.println("Введите число от 0 до " + (Alphabet.alphabet_Map.size() - 1));
            }
        }
        return key;
    }

    public static String validateInputPath(Scanner scanner) {
        String strInputFile = null;
        while (strInputFile == null) {
            try {
                strInputFile = scanner.nextLine();
                Path path = Paths.get(strInputFile);
                if (!Files.isRegularFile(path)) {
                    System.out.println("Файла не существует. Повторите ввод");
                    strInputFile = null;
                } else {
                    break;
                }
            } catch (Exception e) {
                strInputFile=null;
                System.out.println("Ошибка "+e.getMessage()+" .Введите корректный путь");

            }
        }
        return strInputFile;
    }

    public static String validateOutputPath(Scanner scanner) {
        String strOutputFile = null;
        while (strOutputFile == null) {
            strOutputFile = scanner.nextLine();
            try {
                Path pathOutputFile = Paths.get(strOutputFile);
                if (Files.exists(pathOutputFile) && Files.isDirectory(pathOutputFile)) {
                    System.out.println("Придумайте название нового файла:");
                    String newName = scanner.nextLine();
                    Path newPath = Paths.get(pathOutputFile + newName+".txt");
                    if (!Files.exists(newPath)) {
                        Files.createFile(newPath);
                        strOutputFile = newPath.toString();
                        break;
                    } else {
                        System.out.println("Файл уже существует");
                        strOutputFile = null;
                        continue;
                    }
                }
                if (Files.exists(pathOutputFile) && Files.isRegularFile(pathOutputFile)) {
                    break;
                } else {
                    System.out.println("Введите корректный путь");
                    strOutputFile = null;
                }
            } catch (InvalidPathException | IOException e) {
                strOutputFile = null;
                System.out.println("Ошибка "+e.getMessage()+" .Введите корректный путь");
            }
        }
        return strOutputFile;
    }
}

