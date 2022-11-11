import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a size: ");
        int size = in.nextInt();
        array = new int[size];
        int min = 1000;
        int max = -1000;
        int sum = 0;
        System.out.print("{");
        for (int i = 0; i < size; ++i) {
            array[i] = (int) ((Math.random() - 0.5) * 200);
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
            sum += array[i];
            if (i + 1 != size) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + "}\n");
            }
        }
        System.out.print("The minimum element is: " + min + "\n");
        System.out.print("The maximum element is: " + max + "\n");
        System.out.print("The average value is: " + (double)sum / size + "\n");
    }
}