class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProf = Math.max(maxProf, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProf;
    }
}
