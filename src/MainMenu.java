import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ШИФР ЦЕЗАРЯ!\nЧто вы хотите сделать?");
        System.out.println("Введите цифру:");

        while (true) {
            System.out.println("1.Шифруем \n2.Дешифруем \n3.Выйти из программы");
            String input = scanner.nextLine();
            if (input.trim().isEmpty() || input.isBlank()) {
                System.out.println("Введите цифру из списка");
                continue;
            }
            int userChoice = 0;
            try {
                userChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите цифру!");
                continue;
            }
            if (userChoice <= 3 && userChoice >= 1) {
                switch (userChoice) {
                    case 1:
                        System.out.println("Начинаем шифровку...");
                        CaesarCipher.encrypt();
                        break;
                    case 2:
                        System.out.println("Начинаем дешифровку...");
                        CaesorDecoder.decrypt();
                        break;
                    case 3:
                        System.out.println("Выходим из программы...");
                        System.exit(0);

                }
            } else {
                System.out.println("Введите цифру из списка");
            }
        }
    }
}
