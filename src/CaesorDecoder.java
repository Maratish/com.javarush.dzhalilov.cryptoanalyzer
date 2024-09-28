import java.util.Scanner;

public class CaesorDecoder {
    public static void decrypt() {
        StringBuilder decryptedText = new StringBuilder();
        System.out.println("Введите ключ дешифрования(число от 0 до " + (Alphabet.alphabet_Map.size() - 1) + "):");
        int key = Validator.validateKey(new Scanner(System.in));

        try {
            decryptedText.append(Encoder.encoder(FIleManager.readFile().toCharArray(), -key));
            System.out.println("Текст успешно расшифрован");
            FIleManager.writeFile(String.valueOf(decryptedText));
            System.out.println("Расшифрованный документ готов");
        } catch (
                Exception e) {
            System.out.println("ОШИБКА" + e);
            decrypt();
        }
    }
    public static void decryptByBruteForce(){
        StringBuilder decryptedText = new StringBuilder();

        try {
            decryptedText.append(Encoder.byBruteForce(FIleManager.readFile().toCharArray()));
            System.out.println("Текст успешно расшифрован");
            FIleManager.writeFile(String.valueOf(decryptedText));
            System.out.println("Расшифрованный документ готов");
        } catch (
                Exception e) {
            System.out.println("ОШИБКА" + e);
            decryptByBruteForce();
        }
    }
}


