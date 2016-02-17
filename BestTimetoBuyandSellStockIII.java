class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2){
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int minLeft = prices[0];
        for(int i = 1; i < left.length; i++){
            minLeft = Math.min(prices[i], minLeft);
            left[i] = Math.max(left[i-1], prices[i] - minLeft);
        }
        
        right[right.length - 1] = 0;
        int maxRight = prices[prices.length - 1];
        for(int i = right.length - 2; i >=0; i--){
            maxRight = Math.max(prices[i], maxRight);
            right[i] = Math.max(right[i+1], maxRight - prices[i]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(left[i]+right[i], maxProfit);
        }
        
        return maxProfit;
    }
};