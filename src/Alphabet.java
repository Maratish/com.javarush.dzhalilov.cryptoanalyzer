import java.util.HashMap;

public class Alphabet {
    public static final char[] alphabet_RU = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final HashMap<Character,Integer> alphabet_Map = new HashMap<>();

    static {
        for (int i = 0; i < alphabet_RU.length; i++) {
            alphabet_Map.put(alphabet_RU[i], i);
        }
    }
}