public class Group {
    private final String name;
    private int n;
    private Student[] list = new Student[n];

    private int max_name_len = 0;

    public Group(int n, String[] data, String name) {
        this.n = n;
        this.name = name;
        list = new Student[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new Student(data[i]);
            max_name_len = Math.max(max_name_len, data[i].length());
        }
    }

    public Student getValue(int position) {
        return list[position];
    }

    public void setValue(int position, Student value) {
        list[position] = value;
    }

    public int getSize() {
        return n;
    }

    public void next_lesson() {
        for (int i = 0; i < n; ++i) {
            list[i].next_lesson();
        }
    }

    public void print() {
        System.out.printf("==========%s==========\n", name);
        for (int i = 0; i < n; ++i) {
            for (int j = list[i].getNameLength(); j < max_name_len; ++j) {
                System.out.print(" ");
            }
            list[i].print();
        }
    }
}
