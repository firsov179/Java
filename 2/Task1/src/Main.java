import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        Group sample_group = new Group(n,
                new String[]{"Gary Potter", "Ronald Weasley", "Hermione Granger", "Neville Longbottom", "Lavender Brown"},
                "Gryffindor");
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        while (true) {
            System.out.println("Введите команду, чтобы посмотреть список введите /help");
            String com = in.nextLine();
            switch (com) {
                case "/help" -> {
                    System.out.println("/help - вывести список команд");
                    System.out.println("/r - спросить случайного студента");
                    System.out.println("/l - вывести список студентов");
                    System.out.println("/h - начать новый урок");
                    System.out.println("/end - закончить");
                }
                case "/r" -> {
                    int ind = rnd.nextInt(n);
                    sample_group.getValue(ind).question(in);
                }
                case "/l" -> {
                    sample_group.print();
                }
                case "/end" -> {
                    break;
                }
                case "/h" -> {
                    sample_group.next_lesson();
                }
                default -> System.out.println("Вы ввели что-то не то");
            }
        }
    }
}