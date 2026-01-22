class Fibonacci{
    public static void main(String[] args) {
        int n = 10; 
        //using memorization
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n, new int[n + 1]));
        //using tabulation
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacciTabulation(n));
    }


    //memorization approach
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

    //tabulation approach
    public static int fibonacciTabulation(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}