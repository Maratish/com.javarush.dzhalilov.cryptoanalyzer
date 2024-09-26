import java.util.InputMismatchException;
import java.util.Scanner;

public class Decryptor {
    public static  void decrypt (){
        StringBuilder decryptedText = new StringBuilder();
        int key = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ дешифрования(число от 0 до " + (Alphabet.alphabet_Map.size()-1) + "):");
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


        try {
            decryptedText.append(charReplace(FIleManager.readFile().toCharArray(), key));
            System.out.println("Текст успешно расшифрован");
            FIleManager.writeFile(String.valueOf(decryptedText));
            System.out.println("Расшифрованный документ готов");
        } catch (
                Exception e) {
            System.out.println("ОШИБКА" +e);
        }
    }

    public static char[] charReplace(char[] array, int key) {
        char[] cryptedChar = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            char currentChar = Character.toLowerCase(array[i]);
            if (Alphabet.alphabet_Map.containsKey(currentChar)) {
                int position = Alphabet.alphabet_Map.get(currentChar);
                int newPosition = ((position -key+Alphabet.alphabet_Map.size())) % Alphabet.alphabet_Map.size();
                cryptedChar[i] = Alphabet.alphabet_RU[newPosition];
            } else {
                cryptedChar[i] = array[i];
            }

            }
        return cryptedChar;
    }
}

