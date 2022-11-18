import java.util.Scanner;

public class Student {
    private int[] marks = new int[100];
    private String name;
    private boolean visiting;
    private int cur_lesson;

    public Student(String name) {
        this.name = name;
        cur_lesson = -1;
        next_lesson();
        visiting = false;
    }

    public void question(Scanner in) {
        if (marks[cur_lesson] != -1) {
            System.out.printf("Вы уже спрашивали %s%n\n", name);
        }
        else {
            System.out.printf("%s присутствует на паре? (Y/n)%n\n", name);
            String req = in.nextLine();
            if (req.equals("n")) {
                marks[cur_lesson] = 0;
            } else {
                System.out.print("Какую оченку получил?\n");
                while (marks[cur_lesson] < 0 || marks[cur_lesson] > 5) {
                    System.out.print("Оценка должна быть от 0 до 5.\n");
                    marks[cur_lesson] = in.nextInt();
                }
                in.nextLine();
            }
        }
    }

    public void print() {
        System.out.printf("%s: ", name);
        for (int i = 0; i <= cur_lesson; ++i) {
            if (marks[i] == 0) {
                System.out.print("н ");
            } else if (marks[i] != -1) {
                System.out.printf("%d ", marks[i]);
            } else {
                System.out.print("- ");
            }
        }
        System.out.print("\n");
    }

    public void next_lesson() {
        cur_lesson++;
        marks[cur_lesson] = -1;
    }

    public int getNameLength() {
        return name.length();
    }
}