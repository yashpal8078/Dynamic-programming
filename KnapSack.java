public class KnapSack {


    public static int knapSack(int[] weights, int[] values, int capacity, int index) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }
          if(weights[index] <= capacity){
            return Math.max(
                values[index] + knapSack(weights, values, capacity - weights[index], index - 1),
                knapSack(weights, values, capacity, index - 1)
            );
          }else{
            return knapSack(weights, values, capacity, index - 1);
          }
    }
    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        //using memorization
        System.out.println("Maximum value in Knapsack is: " + knapSack(weights, values, capacity, weights.length - 1));
        //using tabulation
    }
    
}
