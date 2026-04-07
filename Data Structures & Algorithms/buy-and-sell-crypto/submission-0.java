class Solution {
    public int maxProfit(int[] prices) {
        int[] tops = new int[prices.length];        
        int high = prices[prices.length-1];
        tops[prices.length-1] = high;
        int result = 0;
        for(int i=prices.length-2; i>=0; i--){
            if(prices[i] > high) high = prices[i];
            tops[i] = high;
        }
        for(int i=0;i<prices.length;i++){
            // System.out.println("tops[i] : " + tops[i] + ", prices[i]  : " + prices[i]);
            if(tops[i]-prices[i] > result) result = tops[i]-prices[i];
        }
        return result;
    }
}
