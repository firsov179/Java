public class Main {
    public static void main(String[] args) {
        boolean[] numbers = new boolean[101];
        for (int i = 2; i < 100; ++i) {
            if (!numbers[i]) {
                System.out.print(i + " ");
                for (int j = 1; i * j < numbers.length; ++j) {
                    numbers[i * j] = true;
                }
            }
        }
    }
}