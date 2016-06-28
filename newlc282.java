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
      for (int i = 1; i <= num.length(); i++){
        long lastValue = Long.parseInt(num.substring(0,i));
        helper(num, new StringBuilder(), 0, 0, 0, target);
      }
      return res;
    }
    private void helper(String num, StringBuilder cur, int start, long lastValue, long curNum, long curSum, char opear, int target){
      if (start == num.length()){
        if (currentSum + operate(lastValue, curNumm, oper) == target){
          res.add(cur.toString()+curNum);
        }
      }
      else{
        if (!(curNum == 0 && num.charAt(start) == '0')) helper(num, cur, start + 1, lastValue, curNum * 10 + num.charAt(start) - '0', opear, target);


      }
    }

    private long opearate(long n1, long n2, char op){
      if (op == '+') return n1 + n2;
      else if(op == '-') return n1-n2;
      return n1*n2;
    }
}
