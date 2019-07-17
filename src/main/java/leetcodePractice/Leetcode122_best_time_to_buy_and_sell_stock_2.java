public class Leetcode122_best_time_to_buy_and_sell_stock_2 {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                while(i < prices.length && prices[i] - min > max) {
                    max = prices[i] - min;
                    i++;
                }

                if (i < prices.length) {
                    result += max;
                    max = 0;
                    min = prices[i];
                }
            }
        }

        result += max;

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
