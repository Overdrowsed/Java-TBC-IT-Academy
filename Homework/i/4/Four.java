public class Four {
    public static void main(String[] args) {
        int x = 4, y = 5;

        int temp = y; y = x; x = temp;

        System.out.println(x + " " + y);
    }
}