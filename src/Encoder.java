import java.util.Arrays;

public class Encoder {
    public static char[] encoder(char[] array, int key) {
        int newPosition = 0;
        char[] cryptedChar = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            char currentChar = Character.toLowerCase(array[i]);
            if (Alphabet.alphabet_Map.containsKey(currentChar)) {
                int position = Alphabet.alphabet_Map.get(currentChar);
                if (key > 0) {
                    newPosition = (position + key) % Alphabet.alphabet_Map.size();
                } else {
                    newPosition = (position + key + Alphabet.alphabet_Map.size()) % Alphabet.alphabet_Map.size();
                }
                cryptedChar[i] = Alphabet.alphabet_RU[newPosition];
            } else {
                cryptedChar[i] = array[i];
            }
        }
        return cryptedChar;
    }


    public static StringBuilder byBruteForce(char[] array) {
        int newPos;
        StringBuilder decrypted = new StringBuilder();
        int key;
        for (int i = 1; i < Alphabet.alphabet_Map.size(); i++) {
            key = i;
            char[] newChar = new char[array.length];
            for (int j = 0; j < array.length; j++) {
                char currentChar = Character.toLowerCase(array[j]);
                if (Alphabet.alphabet_Map.containsKey(currentChar)) {
                    int currentPos = (Alphabet.alphabet_Map.get(currentChar));
                    newPos = (currentPos + key) % Alphabet.alphabet_Map.size();
                    newChar[j] = Alphabet.alphabet_RU[newPos];
                } else {
                    newChar[j] = array[j];
                }
            }
            for (int d = 0; d < 50; d++)
                if (' ' == (newChar[d])) {
                    decrypted.append(newChar);
                    decrypted.append("\n\n\n-----------" + key + "---------------\n\n\n");
                    break;
                }
        }
        return decrypted;
    }
}

