import java.util.Scanner;

public class CaesorDecoder {
    public static  void decrypt (){
        StringBuilder decryptedText = new StringBuilder();
        System.out.println("Введите ключ дешифрования(число от 0 до " + (Alphabet.alphabet_Map.size()-1) + "):");
        int key = Validator.validateKey(new Scanner(System.in));

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

