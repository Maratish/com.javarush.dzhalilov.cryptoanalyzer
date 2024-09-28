import java.util.Scanner;

public class MainMenu {
    public static final String greetings = "ШИФР ЦЕЗАРЯ!\nЧто вы хотите сделать?";
    public static final String inputDigit = "Введите цифру из списка:";
    public static final String mainMenu = "1.Шифруем \n2.Дешифруем \n3.Взламываем шифр (BruteForce)\n4.Выходим из программы";
    public static final String cipherBegin = "Начинаем шифровку...";
    public static final String decryptBegin = "Начинаем дешифровку...";
    public static final String bruteForceBegin = "Начинаем взлом шифра...";
    public static final String exit = "Выходим из программы...";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greetings);
        System.out.println(inputDigit);

        while (true) {
            System.out.println(mainMenu);
            String input = scanner.nextLine();
            if (input.trim().isEmpty() || input.isBlank()) {
                System.out.println(inputDigit);
                continue;
            }
            int userChoice;
            try {
                userChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(inputDigit);
                continue;
            }
            if (userChoice <= 4 && userChoice >= 1) {
                switch (userChoice) {
                    case 1:
                        System.out.println(cipherBegin);
                        CaesarCipher.encrypt();
                        break;
                    case 2:
                        System.out.println(decryptBegin);
                        CaesorDecoder.decrypt();
                        break;
                    case 3:
                        System.out.println(bruteForceBegin);
                        CaesorDecoder.decryptByBruteForce();
                        break;

                    case 4:
                        System.out.println(exit);
                        System.exit(0);

                }
            } else {
                System.out.println(inputDigit);
            }
        }
    }
}
