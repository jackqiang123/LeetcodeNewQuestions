// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
// Note: The input string may contain letters other than the parentheses ( and ).
//
// Examples:
//
// "()())()" -> ["()()()", "(())()"]
// "(a)())()" -> ["(a)()()", "(a())()"]
// ")(" -> [""]

// remark : StringBuilder is an object. equals() will be object equal
public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> res = new ArrayList<>();
    if (isValid(s)) {
      res.add(s); return res;
    }
    HashSet<String> set = new HashSet<>();
    HashSet<String> visit = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    int resLen = 0;
    queue.add(s);
    visit.add(s);
    while(queue.isEmpty()==false){
      String cur = queue.remove();
      if (nb.size() != 0 && cur.length() <= resLen) break;
      for (int i = 0; i < cur.length(); i++){
        if (cur.charAt(i).equals('(') || cur.charAt(i).equals(')')){
          StringBuilder sb = new StringBuilder(cur);
          sb.deleteCharAt(i);
          String nb = sb.toString();
          if (isValid(nb)) {set.add(nb); resLen = nb.length();}
          else queue.add(nb);
        }
      }
    }
    for (String ss : set)
      res.add(ss);
    return res;
  }

  private boolean isValid(String s){
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++){
      char cur = s.charAt(i);
      if (cur == '(' || cur == ')'){
        if (cur == '(') stack.push(cur);
        else if (stack.isEmpty()) return false;
        else if (cur == ')' && stack.peek() == ')') return false;
        else if (cur == ')' && stack.peek() == '(') stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
