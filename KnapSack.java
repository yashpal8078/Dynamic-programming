public class KnapSack {

    public static int KnapSackTabulation(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }



   // memorization approach
    public static int knapSack(int[] weights, int[] values, int capacity, int index,Integer[][] dp) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        if(dp[index][capacity] != null){
            return dp[index][capacity];
        }
          if(weights[index] <= capacity){
            return dp[index][capacity] =  Math.max(
                values[index] + knapSack(weights, values, capacity - weights[index], index - 1,dp),
                knapSack(weights, values, capacity, index - 1,dp)
            );
          }else{
            return dp[index][capacity] = knapSack(weights, values, capacity, index - 1,dp);
          }
    }
    public static void main(String[] args) {
        Integer [][] dp = new Integer[1001][1001];
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        //using memorization
        System.out.println("Maximum value in Knapsack is: " + knapSack(weights, values, capacity, weights.length - 1, dp));
        //using tabulation
        System.out.println("Maximum value in Knapsack is: " + KnapSackTabulation(weights, values, capacity));
    }
    
}
