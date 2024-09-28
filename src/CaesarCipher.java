import java.util.Scanner;

public class CaesarCipher {
    public static void encrypt() {
        StringBuilder cryptedText = new StringBuilder();
        System.out.println("Введите ключ шифрования(от 0 до " + (Alphabet.alphabet_Map.size() - 1) + "):");
        int key = Validator.validateKey(new Scanner(System.in));


        try {
            cryptedText.append(Encoder.encoder(FIleManager.readFile().toCharArray(), key));
            System.out.println("Текст успешно зашифрован");
            FIleManager.writeFile(String.valueOf(cryptedText));
            System.out.println("Зашифрованный документ готов");
        } catch (Exception e) {
            System.out.println("Произошла ошибка - " + e.getMessage());
            encrypt();
        }
    }
}


