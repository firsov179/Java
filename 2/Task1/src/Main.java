import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        String[] names = new String[] {"Gary Potter", "Ronald Weasley", "Hermione Granger", "Neville Longbottom", "Lavender Brown"};
        Random rand = new Random();

        try {
            java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:7007/mydatabase", "username", "password");
            String createStudentsTable = "CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(255), status BOOLEAN, grade INT)";
            conn.createStatement().execute(createStudentsTable);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (name) VALUES (?)");

            for (int i = 0; i < names.length; i++) {
                String name = names[rand.nextInt(names.length)];
                stmt.setString(1, name);
                stmt.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду, чтобы посмотреть список введите /help");
            String com = in.nextLine();
            switch (com) {
                case "/help" -> {
                    System.out.println("/help - вывести список команд");
                    System.out.println("/r - спросить случайного студента");
                    System.out.println("/l - вывести список студентов");
                    System.out.println("/end - закончить");
                }
                case "/r" -> {
                    String name = selectRandomStudent();
                    if (name == null) {
                        System.out.println("There are no students who haven't responded yet.");
                    } else {
                        System.out.println("The selected student is: " + name);
                        System.out.print("Did the student attend the seminar? (Y/N) ");
                        input = scanner.nextLine();
                        boolean status = input.equalsIgnoreCase("Y");
                        System.out.print("Enter the student's grade: ");
                        input = scanner.nextLine();
                        int grade = Integer.parseInt(input);
                        addGrade(name, status, grade);
                    }
                }
                case "/l" -> {
                    try {
                        java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:7007/mydatabase", "username", "password");

                        PreparedStatement stmt = conn.prepareStatement("SELECT name, grade FROM students");
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            String name = rs.getString("name");
                            int grade = rs.getInt("grade");
                            System.out.println(name + ": " + grade);
                        }

                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                case "/end" -> {
                   return;
                }
                default -> System.out.println("Вы ввели что-то не то");
            }
        }
    }

    public static String selectRandomStudent() {
        String name = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:7007/mydatabase", "username", "password");

            PreparedStatement stmt = conn.prepareStatement("SELECT name FROM students WHERE status = false ORDER BY RANDOM() LIMIT 1");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }

            stmt = conn.prepareStatement("UPDATE students SET status = true WHERE name = ?");
            stmt.setString(1, name);
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static void addGrade(String name, boolean status, int grade) {
        try {
            java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:7007/mydatabase", "username", "password");

            PreparedStatement stmt = conn.prepareStatement("UPDATE students SET grade = " + grade + ", status = " + status + " WHERE name = " + name);
            if (stmt.executeUpdate() > 0) {
                System.out.println(name + "получил свою оценку");
            } else {
                System.out.println("Нет ученика с именем " + name + ".");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}