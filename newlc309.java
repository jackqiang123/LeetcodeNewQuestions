// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//
// Example:
//
// prices = [1, 2, 3, 0, 2]
// maxProfit = 3
// transactions = [buy, sell, cooldown, buy, sell]
public class Solution {
    public int maxProfit(int[] p) {
      if (p.length <= 1) return 0;
      int cooldown [] = new int[p.length];
      int sell [] = new int[p.length];
      for (int i = 0; i < p.length; i++){
        if (i == 0) {
          cooldown[i] = 0; sell[i] = 0;
        }
        else if (i == 1){
          cooldown[i] = 0;
          sell[i] = Math.max(0, p[i] - p[i-1]);
        }
        else {
          cooldown[i] = Math.max(sell[i-1], cooldown[i-1]);
          sell[i] = p[i] - p[0];
          for (int j = 0; j + 1 < i; j++){
            sell[i] = Math.max(sell[i], cooldown[j] + p[i] - p[j + 1]);
          }
        }
      }
      return Math.max(cooldown[p.length-1], sell[p.length - 1]);
    }
}
