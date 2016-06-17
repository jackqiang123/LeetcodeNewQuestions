// Given a string that contains only digits 0-9 and a target value,
// return all possibilities to add binary operators (not unary) +, -, or *
// between the digits so they evaluate to the target value.
//
// Examples:
//
// "123", 6 -> ["1+2+3", "1*2*3"]
// "232", 8 -> ["2*3+2", "2+3*2"]
// "105", 5 -> ["1*0+5","10-5"]
// "00", 0 -> ["0+0", "0-0", "0*0"]
// "3456237490", 9191 -> []
public class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
      res = new ArrayList<String>();
      helper(num, new StringBuilder(), 0, 0, 0, target);
      return res;
    }
    private void helper(String num, StringBuilder cur, int start, int lastValue, int currentSum, int target){
      if (start == num.length()){
        if (currentSum + lastValue == currentSum){
          res.add(cur.toString());
        }
      }
      else{
        for (int i = start + 1; i < num.length(); i++){
          int curNum = Integer.parseInt(num.substring(start, i));
          helper(num, cur, i, lastValue*curNum, last+"*"+curNum, currentSum);
          cur.append("+").append(curNum);
          helper(num, cur, i, curNum, "", currentSum - curNum);
          cur.setLength();
          cur.append("-").append(curNum);
          helper(num, cur, i, curNum, "", currentSum + curNum);
          cur.setLength();
        }
      }
    }
}
