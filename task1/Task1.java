public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt((args[1]));

        StringBuilder path = new StringBuilder();
        int current = 1;

        do {
            path.append(current);
            current = (current + m - 2) % n + 1;
        } while (current != 1);

        System.out.println(path);
    }
}