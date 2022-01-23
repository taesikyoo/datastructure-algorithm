package section7;

public class fib {

    public static void main(String[] args) {
        System.out.println(fib(4)); // 3
        System.out.println(fib(10)); // 55
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

}
