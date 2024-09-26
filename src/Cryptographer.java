import java.util.Scanner;

public class Cryptographer {
    public static void encrypt() {
        StringBuilder cryptedText = new StringBuilder();
        System.out.println("Введите ключ шифрования(от 0 до " + (Alphabet.alphabet_Map.size() - 1) + "):");
        int key = Validator.validateKey(new Scanner(System.in));


        try {
            cryptedText.append(charReplace(FIleManager.readFile().toCharArray(), key));
            System.out.println("Текст успешно зашифрован");
            FIleManager.writeFile(String.valueOf(cryptedText));
            System.out.println("Зашифрованный документ готов");
        } catch (Exception e) {
            System.out.println("Произошла ошибка - " + e.getMessage());
            encrypt();
        }
    }

    public static char[] charReplace(char[] array, int key) {
        char[] cryptedChar = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            char currentChar = Character.toLowerCase(array[i]);
            if (Alphabet.alphabet_Map.containsKey(currentChar)) {
                int position = Alphabet.alphabet_Map.get(currentChar);
                int newPosition = (position + key) % Alphabet.alphabet_Map.size();
                cryptedChar[i] = Alphabet.alphabet_RU[newPosition];
            } else{
                cryptedChar[i] = array[i];
            }
            }
        return cryptedChar;
    }
}


