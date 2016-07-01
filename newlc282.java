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
	      helper(num, "", 0, 0, 0, 0, '+', target);
	      return res;
	    }
	    private void helper(String num, String cur, int start, long lastValue, long curNum, long curSum, char oper, int target){
	      if (start == num.length()){
	        if (curSum + opearate(lastValue, curNum, oper) == target){
	          res.add(cur);
	        }
	      }
	      else{
	        long nextLastValue = 0;
	        if (oper == '+') nextLastValue = curNum;
	        else if (oper == '-') nextLastValue = -curNum;
	        else nextLastValue = lastValue*curNum;
	        if (!(curNum == 0 && num.charAt(start) == '0' ) || start == num.length() - 1)
	        	helper(num, cur+num.charAt(start), start + 1, lastValue, curNum * 10 + num.charAt(start) - '0', curSum, oper, target);
	        else {
		        helper(num, cur + "0+", start+1, 0, 0, curSum + nextLastValue, '+', target);
		        helper(num, cur + "0-", start+1, 0, 0, curSum + nextLastValue, '-', target);
		        helper(num, cur + "0*", start+1, 0, 0, curSum , '*', target);
	        }
	        if (cur.length() >= 1 && cur.charAt(cur.length()-1) != '+' && cur.charAt(cur.length()-1) != '-' &&cur.charAt(cur.length()-1) != '*')
	        {
		        helper(num, cur + "+", start, 0, 0, curSum + nextLastValue, '+', target);
		        helper(num, cur + "-", start, 0, 0, curSum + nextLastValue, '-', target);
		        helper(num, cur + "*", start, nextLastValue, 0, curSum , '*', target);
	        }
	      }
	    }

	    private long opearate(long n1, long n2, char op){
	      if (op == '+') return n1 + n2;
	      else if(op == '-') return n1-n2;
	      return n1*n2;
	    }
	}
