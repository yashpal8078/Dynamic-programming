public class ClimbingStair {

    public static void main(String[] args) {
        int n = 4; 
        //using memorization
        System.out.println("Number of ways to climb " + n + " stairs is: " + climbStairs(n, new int[n + 1]));
        //using tabulation
        System.out.println("Number of ways to climb " + n + " stairs is: " + climbStairsTabulation(n));
    }

    //memorization approach
    public static int climbStairs(int n , int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }

    //tabulation approach
    public static int climbStairsTabulation(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
}
