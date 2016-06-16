// Given a string of numbers and operators, return all possible results from
// computing all the different possible ways to group numbers and operators.
// The valid operators are +, - and *.
//
//
// Example 1
// Input: "2-1-1".
//
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]
//
//
// Example 2
// Input: "2*3-4*5"
//
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
      int len = input.length();
      List<Integer> res = new ArrayList();
      if (len == 0) return res;
      if (!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
        res.add(Integer.parseInt(input));
        return res;
      }
      for (int i = 1; i < len - 1; i++){
        if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
          List<Integer> left = diffWaysToCompute(input.substring(0, i));
          List<Integer> right = diffWaysToCompute(input.substring(i+1));
          for (int leftNum : left){
            for (int rightNum : right){
              if (input.charAt(i) == '+' ){
                res.add(leftNum + rightNum);
              }
              else if (input.charAt(i) == '-' ){
                res.add(leftNum - rightNum);
              }
              else {
                res.add(leftNum * rightNum);
              }
            }
          }
        }
      }
      return res;
   }

}
