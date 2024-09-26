import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int validateKey (Scanner scanner){
        int key = -1;
        while (true) {
            try {
                key=scanner.nextInt();
                if (!(key <= 0 || key > (Alphabet.alphabet_Map.size()-1))) {
                    break;
                } else {
                    System.out.println("Введите число от 0 до " + (Alphabet.alphabet_Map.size()-1));
                }
            } catch (InputMismatchException | NumberFormatException e) {
                scanner.nextLine();
                System.out.println("Введите число от 0 до " + (Alphabet.alphabet_Map.size()-1));
            }
        }
        return key;
    }
}
