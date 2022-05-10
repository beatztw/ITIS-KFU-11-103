package leetCodeHW;

class Stock {
    public int maxProfit(int[] prices) {
        int max = Integer.MAX_VALUE;
        int profitToday = 0;
        int profit = 0;


        for(int i = 0; i < prices.length; i++){
            if(prices[i] < max){
                max = prices[i];
            }
            profitToday = prices[i] - max;
            if(profit < profitToday){
                profit = profitToday;
            }
        }
        return profit;
    }
}