public class TargetSum {
    

    public static boolean targetSumSubset(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // i = items & j = target sum

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; 
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10};
        int target = 11;
        boolean result = targetSumSubset(nums, target);
        if (result) {
            System.out.println("Subset with the given target sum exists.");
        } else {
            System.out.println("No subset with the given target sum exists.");
        }
    }

}
