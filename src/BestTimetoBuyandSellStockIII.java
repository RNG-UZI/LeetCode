class Solution {
//You may complete at most two transactions.
//And you must sell the stock before you buy again
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price: prices) {
        	buy1 = Math.min(buy1, price);//first buy price, the less the better
        	sell1 = Math.max(sell1, price - buy1);
        	buy2 = Math.max(buy2, sell1 - price);
        	sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}