class Solution {
    public int maxProfit(int[] prices) {
      int minPrice=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice)
            minPrice=prices[i];
            
            int Calculation=prices[i]-minPrice;
            if(Calculation>profit) {
                profit = Calculation;
                
            }
            
        }
        return profit;
    }
}