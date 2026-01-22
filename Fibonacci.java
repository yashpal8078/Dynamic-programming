class Fibonacci{
    public static void main(String[] args) {
        int n = 10; 
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n, new int[n + 1]));
    }

    public static int fibonacci(int n , int[] memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
    }
}