//1
public String replace(String s){
  StringBuilder res = new StringBuilder(s);
  int index = s.length() - 2;
  while(index >= 0){
    if (s.substring(index, index + 2).equals("\n"))
    {  res.insert(index+2, "\t"); index -= 2;}
    else index--;
  }
  return res.toString();
}


//2
public String removeSpace(String s){
  s = s.trim();
  StringBuilder res = new StringBuilder();
  int i = 0;
  while(i < s.length()){
    if (s.charAt(i) != ' ')
      res.append(s.charAt(i++));
    else {
      while(i < s.length() && s.charAt(i) == ' ')
        i++;
      if (i == s.length()) return res.toString();
      else res.append(' ');
    }
  }
  return res.toString();
}

//3 wiggle sort
public void wiggleSort(int []nums){
  int len = nums.length;
  for (int i = 1; i < len; i++){
    if (i%2 == 0){
      if (nums[i] > nums[i-1])  swap(nums, i-1,i);
      i++;
    }
    else {
      if (nums[i] < nums[i-1])  swap(nums, i-1,i);
      i++;
    }
  }
}

//4 clock angle
// hour hand move 0.5 degree, and minute hand more 6 degree per minute

// 5
public int height(TreeNode root){
  if (root == null) return 0;
  return 1 + Math.max(height(root.left), height(root.right));
}

// 6
public TreeNode getAncestor(TreeNode root, TreeNode p, TreeNode q){
  if (root == p || root == q) return root;
  if (root == null) return root;
  TreeNode leftRoot = getAncestor(root.left, p, q);
  TreeNode rightRoot = getAncestor(root.right, p, q);
  if (leftRoot == null) return rightRoot;
  if (rightRoot == null) return leftRoot;
  return root;
}

public TreeNode getAncestorBST(TreeNode root, TreeNode p, TreeNode q){
  if (root == null) return null;
  if (p == null || q == null) return p == null ? q : p;
  if (p.val < root.val && q.val < root.val) return getAncestorBST(root.left, p, q);
  if (p.val > root.val && q.val > root.val) return getAncestorBST(root.right, p, q);
  return root;
}

public TreeNode getAncestorWithParentPoint(TreeNode p, TreeNode q){
  if (p == null || q == null) return p == null ? q : p;
  int pheight = getDepth(p);
  int qheight = getDepth(q);
  TreeNode first = pheight > qheight ? p : q;
  TreeNode second = first == p ? q : p;
  int diff = Math.abs(pheight, qheight);
  for (int i = 0; i < diff; i++)  first = first.root;
  while(first != second) {
    first = first.root; second = second.root;
  }
  return first;
}

// 7 bit is panlindrome
public boolean isPanlindrome(int num){
  for (int i = 0; i < 16; i++){
    int lo = ((num>>i)&1);
    int hi = (num>>(31-i))&1;
    if (lo != hi) return false;
  }
  return true;
}
public boolean isPanlindromeIgnoreLeading0(int num){
  int bit = 0;
  while(num != 0){
    num = (num>>>1);
    bit++;
  }
  for (int i = 0; i < bit/2; i++){
    int lo = ((num>>i)&1);
    int hi = (num>>(bit-1-i))&1;
    if (lo != hi) return false;
  }
  return true;
}

// 8 merge two sorted a in array a
public void merge(int []a, int alen, int []b, int blen){
  int i = alen + blen - 1;
  int pa = alen - 1;
  int pb = blen - 1;
  while(pa >= 0 || pb >= 0){
    if (pa >= 0 && pb >= 0){

    }
    else if (pa >= 0){
      a[i--] = a[pa--];
    }
    else {
      a[i--] = b[pb--];
    }
  }
}

// 9 binary tree next pointer
public void generateNextPoint(TreeNode root){
  if (root == null) return;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  TreeNode dummy = new TreeNode(0);
  while(!queue.isEmpty()){
    int qsize = root.size();
    for (int i = 0; i < qsize; i++){
      TreeNode cur = queue.remove();
      dummy.next = cur;
      dummy = cur;
      if (cur.left != null) queue.add(cur.left);
      if (cur.right != null) queue.add(cur.right);
    }
    dummy = new TreeNode(0);
  }
}

// 10 bst successor
public int getSuccessor(TreeNode root, TreeNode p){
  if (p.right != null){
    p = p.right;
    while(p.left != null) p = p.left;
    return p;
  }
  else {
    TreeNode next = null;
    while(root != p){
      if (root.val < p.val){
        root = root.right;
      }
      else {
        next = root;
        root = root.left;
      }
    }
    return next;
  }
}

// 11 target sum subset
public List<List<Integer>> targetSumSubset(int [] nums, int target){
  List<List<>> res = new ArrayList<>();
  helper(nums, 0, 0, target, new ArrayList<Integer>());
  return res;
}
private void helper(int []nums, int start, int sum, int target, List<Integer> cur){
  if (start == nums.length){
    if (sum == target && cur.size() != 0) {
      res.add(new ArrayList<Integer>(cur));
    }
  }
  helper(nums, start + 1, sum, target, cur);
  cur.add(nums[start]);
  helper(nums, start + 1, sum + nums[start], target, cur);
  cur.remove(cur.size()-1);
}

//12
public int Josephus(int m, int n){
  Queue<Integer> queue = new LinkedList<>();
  for (int i = 1; i <= n; i++)
    queue.add(i);
  while(queue.size() > 1){
    for (int i = 0; i < m - 1; i++) queue.add(queue.remove());
    queue.remove();
  }
  return queue.remove();
}

// 13 find all neighbors. using bfs. not clear defintion of question

// 14 determine whether two rectangle is intersect or not
public boolean isIntersect(int A, int B, int C, int D, int E, int F, int G, int H){
  int sum = (C-A)*(D-B) + (H-F)*(G-E);
  if (C < E || D < F || G < A || H < B) return sum;
  int x1 = Math.max(A,E);
  int y1 = Math.max(F,B);
  int x2 = Math.min(C,G);
  int y2 = Math.min(H,D);
  int area = (y2-y1)*(x2-x1);
  return sum - area;
}

// 15 tic tac
// note that the anti diag is x + y == len - 1

// 16 find smallest node which is the right child of the root.
// call by (root, null, null)
public TreeNode findNodeInBST(TreeNode root, TreeNode parent, TreeNode target){
  if (target != null) return target;
  if (root == null) return null;
  target = findNodeInBST(root.left, root, target);
  if (target != null) return target;
  if (parent != null && parent.right == root) {
    return root;
  }
  return findNodeInBST(root.right, root, target);
}
// we can use a stack to run dfs. when an element is pop out of stack.
// use a global variable to track whether a right node has been find. break
// when we pop best from the stack

//17 check all combination of phone number display
// assume we already construct a map, from number to char List
Map<Integer, List<Character>> map;
public List<String> getCombination(String number){
  helper(number, 0, new StringBuilder());
  return res;
}
private void helper(String number, int start, StringBuilder sb){
  if (number.length() == start){
    res.add(sb.toString());
  }
  else {
    int slen = sb.length();
    int curNum = number.charAt(start) - '0';
    List<Character> ls = map.get(curNum);
    for (char next : ls){
      sb.append(next);
      helper(number, start + 1, sb);
      sb.setLength(slen);
    }
  }
}

//18 find whether 3 numbers form a triangle
public boolean formTriangle(int a, int b, int c){
  if (a <= 0 || b<= 0 || c<= 0) return false;
  if (a <= Math.abs(b-c) ||  b<= Math.abs(a-c) ||c <= Math.abs(a-b)) return false;
  return true;
}

//19 transform String
public String transformString(String s){
  StringBuilder sb = new StringBuilder(s);
  int i = s.length()-1;
  while(i >= 0){
    if (s.charAt(i) == 'b'){
      if (i - 1 >= 0 && s.charAt(i-1) == 'b'){
        sb.deleteCharAt(i); i -= 2;
      }
      else i--;
    }
    else if (s.charAt(i) == 'a'){
      sb.insert(i--, "aa");
    }
  }
  return sb.toString();
}

//20 get compress data
public String compression(String data){
  //assume all are lower case char
  int []count = new int[26];
  for (int i = 0; i < data.length(); i++) count[data.charAt(i)-'a']++;
  StringBuilder res = new StringBuilder();
  for (char c = 'a'; c <= 'z'; c++){
    if (count[c-'a']!=0){
      res.append(c).append(count[c-'a']);
    }
  }
  return res.toString();
}

// 21 check valid XML file
public boolean isValidXML(String xml){
  xml = xml.trim();
  Stack<String> stack = new Stack<>();
  int i = 0;
  while(i < xml.length()){
    int start = xml.indexOf("<", i);
    int end = xml.indexOf(">", i);
    if (start == -1 || end == -1 || start >= end) return false;
    String tag = xml.substring(start+1,end);
    if (tag.length() == 0) stack.push(tag);
    else {
      if (tag.charAt(0) == '/'){
        tag = tag.substring(1);
        if (stack.isEmpty()) return false;
        if (stack.peek().equals(tag)) stack.pop();
        else return false;
       }
      else {
        stack.push(tag);
       }
    }
    index = end + 1;
  }
  return stack.isEmpty();
}

// 22 parenthesis matcher using a stack will be easy

// 23 read a file and return the last n lines
public List<String> readLastNLines(String filename, int n){
  Queue<String> queue = new LinkedList<>();
  File file = new File("filename");
  while(file.hasNext()){
    String line = file.readLine();
    if(queue.size() >= n) queue.remove();
    queue.add(line);
  }
  List<String> res = new ArrayList<>(queue);
  return res;
}

// 24 get the most freq char in a string. easy

// 25 delete the word with given char leading in place
public String remove(char[]array, char c){
  int i = 0, j = 0;
  while(j < array.length){
    if (array[j] == ' ')  array[i++] = array[j++];
    else {
      if (array[j] == c){
        while(j < array.length && array[j] != ' ')
          j++;
      }
      else {
        while(j < array.length && array[j] != ' ')
          array[i++] = array[j++];
      }
    }
  }
}

// 26 sprial matrix
public List<Integer> spiralOrder(int [][]matrix){
  List<Integer> res = new ArrayList<>();
  int h = matrix.length;
  int w = matrix[0].length;
  int i = 0; int j = 0;
  while(true){
    while(j<w){
      res.add(matrix[i][j++]);
    }
    h--; j--;
    if (h <= 0) break;

    while(i<h){
      res.add(matrix[i++][j]);
    }
    w--; i--;
    if (w <= 0) break;

    while(j>=0){
      res.add(matrix[i][j--]);
    }
    h--; j++;
    if (h <= 0) break;

    while(i>=0){
      res.add(matrix[i--][j]);
    }
    w--; i++;
    if (w <= 0) break;
  }
  return res;
}

// 27 listNode last nth node
public ListNode lastNnode(ListNode head, int n){
  if (hasCycle(head)) return null;
  ListNode p2 = head;
  ListNode p1 = head;
  while(p2 != null && n > 0){
    p2 = p2.next; n--;
  }
  if (n != 0) return null;
  while(p2 != null){
    p1 = p1.next; p2 = p2.next;
  }
   return p1;
}
private boolean hasCycle(ListNode head){
  ListNode p1 = head;
  ListNode p2 = head;
  while(true){
    if (p2 == null || p2.next == null || p2.next.next == null) return false;
    p2 = p2.next.next;
    p1 = p1.next;
    if (p2 == p1) return true;
  }
  return false;
}


// 28 longest consective seq
public int longestConsectSeq(int []nums){
  Map<Integer, Integer> map = new HashMap<>();
  int best = 0;
  for (int i : nums){
    if (map.get(i) != null) continue;
    int len = 1 + (map.get(i-1) == null ? 0 : map.get(i-1)) + (map.get(i+1) == null ? 0 : map.get(i+1));
    best = Math.max(best, len);
    if (map.get(i-1) != null){
      int leftBound = i - map.get(i-1);
      map.put(leftBound, len);
    }

    if (map.get(i+1) != null){
      int rightBound = i + map.get(i+1);
      map.put(rightBound, len);
    }
    map.put(i,len);
  }
  return best;
}
/* a faster solution using hashset */
public int longestConsectSeq(int []nums){
  Set<Integer> set = new HashSet<>();
  for (int n : nums) set.add(n);
  int max = 0;
  for (int i = 0; i < nums.length; i++){
    int count = 1;
    int n = nums[i];
    while(set.contains(n-1)){
      count++; n--; set.remove(n);
    }
    n = nums[i];
    while(set.contains(n+1)){
      count++; n++; set.remove(n);
    }
    max = Math.max(max, count);
  }
  return max;
}

// max subarray sum
public int maxSubArray(int []nums){
  int len = nums.length;
  if (len == 0) return 0;
  int curBest = Integer.MIN_VALUE;
  int tail = 0;
  for (int i = 0; i < nums.length; i++){
    tail = Math.max(tail + nums[i], nums[i]);
    curBest = Math.max(curBest,tail);
  }
  return curBest;
}

// 31
// course schedule  see below topolocal sorting
public List<Integer> getSchedule(int[][] courses){

}

// graph with cycle
//directed Graph
class GraphNode{
    int val;
    List<GraphNode> nb;
    public GraphNode(int val){
      this.val = val;
      nb = new ArrayList<>();
    }
}
// recrusively find all cycles on the graph dfs
Set<GraphNode> visit;
Set<GraphNode> onstack;
List<GraphNode> cur;
List<List<GraphNode>> res;
//call this following over all nodes.
public boolean hasCycleDirectedGraph(GraphNode node){
  if (visit.contains(node)) return false;
  if (node == null) return false;
  visit.add(node);
  onstack.add(node);
  cur.add(node);
  List<GraphNode> nb = node.nb;
  for (GraphNode next : nb){
    if (onstack.contains(next)) {res.add(new ArrayList<Integer>(cur)); return true;}
    if (hasCycleDirectedGraph(next)) return true;
  }
  onstack.remove(node);
  cur.remove(res.size()-1);
  return false;
}
// bfs to detect whether there is a cycle or not.
public boolean hasCycleDirectedGraph(List<GraphNode> nodes){
  List<GraphNode> noIndegreeNodes = findNoIndegreeNodes(nodes);//easy to be done.
  Queue<GraphNode> queue = new LinkedList<>();
  Map<GraphNode, Integer> prefixCount = getPreFixCount(nodes);
  for (GraphNode gn : noIndegreeNodes){
    queue.add(gn);
  }
  int N = 0;
  while(!queue.isEmpty()){
    GraphNode gn = queue.remove();
    N++;
    for (GraphNode next : gn.nb){
      if (prefixCount.get(next) == 1){
        queue.add(next);prefixCount.put(next, 0);
      }
      else prefixCount.put(next, prefixCount.get(next)-1);
    }
  }
  return N == nodes.length();
}


// recrusively
Set<GraphNode>visit;// assume there is only one zone. otherwises, we iterate
public boolean hasCycleUnDirectedGraph(List<GraphNode> nodes){
  visit = new HashSet<>();
  for (GraphNode n : nodes){
    if (!visit.contains(n))
      if (helper(n, null)) return true;
  }
  return false;
}
private boolean helper(GraphNode node, GraphNode parent){
  visit.add(node);
  List<GraphNode> ls = node.nb;
  for (GraphNode n : ls){// once meeting a node seen before, unless it is from source, we know we have a loop
    if (!visit.contains(n)){
      if (helper(n, node)) return true;
    }
    else if (node != parent){
      return true;
    }
  }
  return false;
}

//union-find. when connect two nodes, check whether they already in the same cluster or not.
public boolean hasCycleUnDirectedGraph(List<GraphNode> nodes){
  List<Edge> edgeLists = getEdgeList(nodes);// no duplicate edge
  for (Edge e : edgeLists){
      if (connect(e[0],e[1])) return true;
  }
  return false;
}


// 31 start to end, jump by horse step. min step
// this is a word-ladder styple shortest path search problem.
// using bfs to find the shortest path length, while using dfs+bfs to find the path.
Map<Integer, Integer> map;
Map<Integer, List<Integer>> prev;

// the dim is d*d
public List<List<Integer>> getPath(int start, int end){
  helper(start, end);
  return res;
}
private void helper(int start, int end){
  Queue<Integer> queue = new LinkedList<>();
  if (start == end){
    List<Integer> cur = new ArrayList<>();
    cur.add(start);
    res.add(cur);
    return;
  }
  queue.add(start);
  map.put(start, 0);
  int step = 1;
  while(!queue.isEmpty()){
    int qsize = queue.size();
    for (int i = 0; i < qsize; i++){
      int cur = queue.remove();
      List<Integer> nextHop = getNext(cur);
      for (int next : nextHop){
        if (map.get(next) == null) map.put(next, step);
        if (prev.get(next) == null) prev.put(next, new ArrayList<Integer>());
        if (map.get(next) == step) prev.get(next).add(cur);
      }
    }
    step++;
    if (map.get(end) != null) break;
  }
  getResult(start, end, new ArrayList<Integer>());
}

private void getResult(int start, int end, List<Integer> cur){
  if (start == end) {
    List temp = new ArrayList(cur);
    temp.add(0, start);
    res.add(temp);
  }
  else {
    cur.add(0, end);
    List<Integer> pre = prev.get(end);
    for (int n : pre) {
      getResult(start, n, cur);
    }
    cur.remove(0);
  }
}

// 32 find shortest path in a maze. same as 31

// 33 clone graph. clone List
Map<GraphNode, GraphNode> map;
public GraphNode clone(GraphNode node){
  if (node == null) return null;
  if (map.get(node) != null) return map.get(node);
  GraphNode cloneNode = new GraphNode(node.val);
  map.put(node, cloneNode);
  for (GraphNode nb : node.nb){
    cloneNode.nb.add(nb);
  }
  return cloneNode;
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 // do not use HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) return null;
      RandomListNode dummy = head;
      while(dummy != null){
        RandomListNode copy = new RandomListNode(dummy.label);
        copy.next = dummy.next;
        dummy.next = copy;
        dummy = copy.next;
      }
      dummy = head;
      while(dummy != null){
          if (dummy.random != null)
           dummy.next.random = dummy.random.next;
        dummy = dummy.next.next;
      }
      RandomListNode newList = new RandomListNode(0);
      RandomListNode p = newList;
      dummy = head;
      while(dummy != null){
        newList.next = dummy.next;
        newList = newList.next;
        if (dummy.next != null)
        dummy.next = dummy.next.next;
        dummy = dummy.next;
      }
      return p.next;
    }
}

// 34 list plus. number start from hi to lo
public ListNode plus(ListNode n1, ListNode n2){
  n1 = reverse(n1);
  n2 = reverse(n2);
  return reverse(sum(n1,n2));
}
private ListNode reverse(ListNode head){
  if (head == null) return head;
  ListNode res = new ListNode(0);
  while(head != null){
    ListNode t = head.next;
    head.next = res.next;
    res.next = head;
    head = t;
  }
  return res.next;
}
private ListNode sum(ListNode n1, ListNode n2){
  int carry = 0;
  ListNode res = new ListNode(0);
  ListNode p = res;
  while(n1 != null || n2 != null){
    if (n1 != null && n2 != null){
      int sum = n1.val + n2.val + carry;
      res.next = new ListNode(sum%10);
      carry = sum/10;
      res = res.next; p1 = p1.next; p2 = p2.next;
    }
    else if (n1 != null){
      int sum = n1.val + carry;
      res.next = new ListNode(sum%10);
      carry = sum/10;
      res = res.next; p1 = p1.next;
    }
    else {
      int sum = n2.val + carry;
      res.next = new ListNode(sum%10);
      carry = sum/10;
      res = res.next; p2 = p2.next;
    }
  }
  if (carry != null) res.next = ListNode(carry);
  return p.next;
}

//35
public String removeChar(String target, String toRemove){
  StringBuilder sb = new StringBuilder();
  Set<Character> set = getDictoray(toRemove);
  for (int i = 0; i < target.length(); i++){
    if (!set.contains(sb.charAt(i))) sb.append(sb.charAt(i));
  }
  return sb.toString();
}


// 36 sort stack
public void sortStack(Stack<Integer> stack){
  if (stack.isEmpty()) return;
  int top = stack.pop();
  sortStack(stack);
  insert(stack, top);
}
private void insert(Stack<Integer> stack, int top){
  if (stack.isEmpty()) stack.push(top);
  if (stack.peek() < top) stack.push(top);
  int peek = stack.pop();
  insert(stack, top);
  stack.push(peek);
}

// 37 opearation of a LinkedList

// 39 implementation of a min stack
public class MinStack{
  Stack<Integer> stack;
  Stack<Integer> mstack;
  public void push(int x){
    stack.push(x);
    if (mstack.isEmpty() || mstack.peek() >= x) // must contain equal
      mstack.push(x);
  }
  public void pop(){
    int top = stack.pop();
    if (top == mStack.peek()) mstack.pop();
  }
  public int min(){
    return mstack.peek();
  }
}

//40 construct a bst from poster order traveral
// think about we can defitionaly construct first right tree and then left.
// this idea apply to the LinkedList model.
int end;
public TreeNode constructBSTfromPosterOrder(int []nums){
  end =  nums.length - 1;
  return help(nums, Integer.MIN_VALUE, Integer.MAX_VALUE, end);
}
private TreeNode helper(int []nums, int lower, int upper, int end){
  if (end < 0) return null;
  if (nums[end] < upper && nums[end] > lower){
    TreeNode root = new TreeNode(nums[end]);
    end--;
    root.right = helper(nums, lower, root.val, end);
    root.left = helper(nums, root.val, upper, end);
    return root;
  }else {
    return null;
  }
}

// 41 hashtable implementation




// 42 quick sort
// for an array
public void quicksort(int []nums, int start, int end){
  if (start > end) return;
  int pivot = partition(nums, start, end, (start+end)/2);
  quicksort(nums, start, pivot - 1);
  quicksort(nums, pivot + 1, end);
}
//parition return the ranked index of the picked pivotIndex
private int partition(int []nums, int start, int end, int pivotIndex){
  swap(nums, start, pivotIndex);
  int pivotValue = nums[start];
  int j = start + 1;
  for (int i = start + 1; i <= end; i++){
    if (nums[i] < pivotValue) swap(nums, i, j++);
  }
  swap(nums, start, j-1);
  return j-1;
}
public int quickSelection(int []nums, int start, int end, int k){
  if (start == end || k == 0) return nums[start];
  int pivotIndex = (start + end)/2;
  int pivot = partition(nums, start, end, pivotIndex);
  if (pivot == k) return nums[pivot];
  else if (pivot < k) return quickSelection(nums, pivot + 1, end, k);
  return quickSelection(nums, start, pivot - 1, k);

}

// 43 merge sort
// for an array
public void mergeSort(int []nums, int start, int end){
  int mid = (start + end)/2;
  mergeSort(nums, start, mid);
  mergeSort(nums, mid + 1, end);
  merge(nums, start, mid, end);// ingore the implementation
}
// for a list
public ListNode mergeSort(ListNode head){
  if (head == null || head.next == null) return head;
  ListNode mid = findMedian(head);
  ListNode right = mid.next;
  mid.next = null;
  return merge(mergeSort(head), mergeSort(right));
}
private ListNode findMedian(ListNode head){// this ia the node before middle.
  //therefore, we let faster pointer go one step first.
  ListNode tail = head.next;
  while(tail != null && tail.next != null){
    head = head.next;
    tail = tail.next.next;
  }
  return head;
}
private ListNdoe merge(ListNode left, ListNode right){
  ListNode dummy = new ListNode(0);
  ListNode res = dummy;
  while(left != null || right != null){
    if (left != null && right != null){
      addSmallerForwardPointer(dummy,left,right);
    }
    else if (left != null) {
      dummy.next = left; break;
    }
    else {dummy.next = right; break;}
  }
  return res.next;
}
//Another idea is get length of list and do opearation
// len is the length of sorted list, can be get in O(n)
ListNode p = head;
public ListNode sortList(ListNode head, int len){
  if (len <= 1) {return head;}
  ListNode newHead = forwardHeadByDistanceAndBreak(head, len/2);
  ListNode left = sortList(head, len/2);
  ListNode right = sortList(head, len - len/2);
  return merge(left, right);
}
// 44 search element in an sorted matrix
// column and row are sorted in ascending
public boolean search(int[][]matrix, int target){
  int h = matrix.length;
  int w = matrix[0].length;
  int i = 0;
  int j = w - 1;
  while(i < h && j >= 0){
    int cur = matrix[i][j];
    if (cur == target) return true;
    if (cur < target) i++;
    else j--;
  }
  return false;
}

//45 meeting rooms
public boolean canSchedule(Interval[] intervals){
  Arrays.sort(intervals, new Comparator<Interval>(){
    public int compare(Interval i1, Interval i2){
      return i1.start - i2.start;
    }
  });
  for (int i = 1; i < intervals.length; i++){
    Interval lastend = intervals.[i-1].end;
    Interval thisstart = intervals[i].start;
    if (lastend > thisstart) return false;
  }
  return true;
}
// or we can think about it as whether we can sechedule the meeting in k rooms
// compare k and the obtained number.
public int minSchedule(Interval [] intervals){
  Arrays.sort(intervals, new Comparator<Interval>(){
    public int compare(Interval i1, Interval i2){
      return i1.start - i2.start;
    }
  });
  PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length+1, new Comparator<Interval>(){
    public int compare(Interval i1, Interval i2){
      return i1.end - i2.end;
    }
  });
  for (Interval interval : intervals){
    if (pq.isEmpty()) pq.add(interval);
    else if (pq.peek().end <= interval.start){
      Interval newInterval = pq.remove();
      newInterval.end = interval.end;
      pq.add(newInterval);
    }
    else pq.add(interval);
  }
  return pq.size();
}

// 46 fill the distance of a matrix
boolean [][]visit;
public void fillDistance(int [][]matrix){
  //Integer.MAX_VALUE is to be filled.
  //0 is the door, -1 is the wall
  int h = matrix.length;
  int w = matrix[0].length;
  for (int i = 0; i < h; i++){
    for (int j = 0; j < w; j++)
    visit = new int[h][w];
    if (matrix[i][j] == Integer.MAX_VALUE) // bfs starting from the door
      bfs(matrix, i, j, 0);
  }
}
private void bfs(int [][]matrix, int i, int j, int distance){
  Queue<int[]> queue = new LinkedList<>();
  int [][]d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  queue.add(new int[]{i,j});
  int dis = 1;
  while(!queue.isEmpty()){
    int qsize = queue.size();
    for (int k = 0; k < qsize; k++){
      int []cur = queue.remove();
      int x = cur[0]; int y = cur[1];
      for (int[] dv : d){
          int nx = dv[0] + x;
          int ny = dv[1] + y;
          if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny] || matrix[nx][ny] == -1) continue;
          visit[nx][ny] = true;
          if (matrix[nx][ny] == 0) {
            matrix[i][j] = dis;
            return;
          }
          else {
            queue.add(new int[]{nx,ny});
          }
      }
    }
    dis++;
  }
}

// we can start from multiple sources at the same time
public void fillDistance(int [][]matrix){
     Queue<int[]> queue = new LinkedList<>();
     int h = matrix.length;
     int w = matrix[0].length;
     for (int i = 0; i < matrix.length; i++){
       for (int j = 0; j < matrix.length; j++)
         if (matrix[i][j] == 0){ queue.add(new int[]{i,j});}
     }
     int dis = 1;
     int [][]d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
     while(!queue.isEmpty()){
       int qsize = queue.size();
       for (int i = 0; i < qsize; i++){
         int []cur = queue.remove();
         for (int[] dv : d){
             int nx = dv[0] + cur[0];
             int ny = dv[1] + cur[1];
             if (nx < 0 || nx >= h || ny < 0 || ny >= w || matrix[nx][ny] == -1) continue;
             if (matrix[nx][ny] == Integer.MAX_VALUE) {
               matrix[nx][ny] = dis;queue.add(new int[]{nx,ny});
             }
         }
       }
       dis++;
     }
   }

// 47 path sum return path
public class Solution {
List<List<Integer>> res;
public List<List<Integer>> pathSum(TreeNode root, int target){
  res = new ArrayList<>();
  helper(root, new ArrayList<Integer>(), target);
  return res;
}
private void helper(TreeNode root, List<Integer> cur, int target){
  if (root == null) return;
  cur.add(root.val);
  if (root.left == null && root.right == null){
    if (target == root.val){
      res.add(new ArrayList<Integer>(cur));
    }
  }
  else{
    for (TreeNode child : root.childSet)
    if (child != null) helper(child, cur, target - root.val);
  }
  cur.remove(cur.size()-1);
}
}

// 48 diff between maxheight and minheight
public int diffMinMax(TreeNode root){
  if (root == null) return 0;
  return maxHeight(root) - minHeight(root)
}
private int maxHeight(TreeNode root){
  if (root == null) return 0;
  return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
}
private int minHeight(TreeNode root){
  if (root == null) return 0;
  if (root.left == null && root.right == null) return 1;
  int left = root.left == nul ? Integer.MAX_VALUE, minHeight(root.left);
  int right = root.right == nul ? Integer.MAX_VALUE, minHeight(root.right);
  return Math.min(left,right);
}

//whether a binary tree has a cycle
Set<TreeNode> set = new HashSet<>();
public boolean hasCycle(TreeNode root){
  if (root == null) return false;
  if (set.contains(root)) return true;
  set.add(root);
  if (hasCycle(root.left)) return true;
  if (hasCycle(root.right)) return true;
  return false;
}

// 50 skyline
public class Solution {
class Edge{
  int x;
  int y;
  public Edge(int x, int y){
      this.x = x;
      this.y = y;
  }
}
public List<int[]> getSkyline(int[][] buildings) {
  List<Edge> edge = new ArrayList<>();
  for(int []build : buildings){
    edge.add(new Edge(build[0], build[2]));
    edge.add(new Edge(build[1], -build[2]));
  }
  Collections.sort(edge, new Comparator<Edge>(){
    public int compare(Edge e1, Edge e2){
      if (e1.x != e2.x) return e1.x - e2.x;
      return e2.y - e1.y;
    }
  });
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(edge.size() + 1, Collections.reverseOrder());
  List<int[]> res = new ArrayList<>();
  int height = 0;
  for (Edge e : edge){
    if (e.y > 0) {
      pq.add(e.y);
    }
    else {
      pq.remove(-e.y);
    }
    if (pq.isEmpty() || pq.peek() != height){
      height = pq.isEmpty()?0:pq.peek();
      res.add(new int[]{e.x, height});
    }
  }
  return res;
}

}
// 51 biggest bst subtree (must contains all leafs on that branch) on a binary tree
public class Solution {
        int max;
    public int largestBSTSubtree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    class Cell{
        boolean isBST;
        int lower;
        int upper;
        int size;
        public Cell(int size, boolean isBST, int lower, int upper){
            this.size = size; this.isBST = isBST; this.lower = lower; this.upper = upper;
        }
    }
    private Cell helper(TreeNode root){
        if (root == null) return new Cell(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Cell left = helper(root.left);
        Cell right = helper(root.right);
        if (left.isBST && right.isBST && root.val > left.upper && root.val < right.lower){
            max = Math.max(max, 1 + left.size + right.size);
            return new Cell(1 + left.size + right.size, true, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
        return new Cell(0, false, 0, 0);
    }
}

// 52 evalPRN easy to be done
// we'd better do something like basic calculator

// 53 singleton pattern
// wait to be done.

// 54 integer to roman and roman to Integer
public int romanToInteger(){

}
public String IntegerToRoman(){

}

// 55 count and say
public String countAndSay(int n){
  if (n == 1) return "1";
  String number = countAndSay(n-1);
  StringBuilder res = new StringBuilder();
  int i = 0;
  int count = 0;
  while(i < number.length()){
    char value = number.charAt(i);
    count = 0;
    while(i < number.length() && number.charAt(i) == value)
    {count++;  i++;}
    res.append(count).append(value);
  }
  return res.toString();
}
// 56 cloest node to double
public int closestValue(TreeNode root, double target){
  if (root.left == null && root.right == null) return root.val;
  if (root.val < target){
    if (root.right == null) return root.val;
    int right = closestValue(root.right, target);
    return (target - root.val) < (right - target) ? root.val : right;
  }
  else {
    if (root.left == null) return root.val;
    int left = closestValue(root.left, target);
    return (- target + root.val) < (-left + target) ? root.val : left;
  }
}

// cloest k valeus to target. Ingore this! This is for gougou
public List<Integer> closestKValues(TreeNode root, double target, int k) {

}

// integer to binary
public String integerToBinary(int num){
  if (num == 0) return "0";
  if (num == 1) return "1";
  if (num%2 == 0){
    return integerToBinary(num/2)+"0";
  }
  else return integerToBinary(num/2)+"1";
}

//59 find the range sum in a matrix in O(1)
// get range sum prestored in a matrix

//60 3 point forms a triangle
public boolean formTriangle(Point p1, Point p2, Point p3){
  if (isSamPoint(p1,p2) || isSamPoint(p2,p3) ||isSamPoint(p3,p1)) return false;
  if (isVectical(p1,p2) return !isVectical(p1,p3);
  if (isVectical(p2,p3) return !isVectical(p1,p3);
  if (isVectical(p3,p1) return !isVectical(p1,p2);
  return slope(p2,p1) != slope(p3,p2);
}


// 61 fattern tree to a doulbe linkedlist
// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//
// The flattened tree should look like:
//
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
// assume each node has a parent node
TreeNode last = null;
public void flatten(TreeNode root) {
  if (root == null) return;
  last = root;
  TreeNode right = root.right;
  TreeNode left = root.left;
  flatten(left);
  root.left = null;
  root.right = left;
  if (left != null) left.parent = root;
  TreeNode t = last;
  flatten(right);
  t.right = right;
  if (right != null) right.parent = last;
}


TreeNode last = null;
public void flatten(TreeNode root) {
  if (root == null) return;
  last = root;
  TreeNode right = root.right;
  TreeNode left = root.left;
  flatten(left);
  root.left = null;
  root.right = left;
  TreeNode t = last;
  flatten(right);
  t.right = right;
}

// string (1(7((2)(3)))(5(6))) to a tree
// recrusion
public String buildTree(String s){
  if (s.length() == 0 || s.charAt(0) != '(') return null;
  int i = 1;
  while(s.charAt(i) != '(' && s.charAt(i) != ')') i++;
  TreeNode root = new findRoot(Integer.parseInt(s.substring(1, i)));
  if (s.charAt(i) == ')') return root; // this is the end a point
  int nextPairEnd = findNextPair(s, i);
  root.left = buildTree(s.substring(i, nextPairEnd));
  if (s.charAt(nextPairEnd) == ')') return root;
  int j = findNextPair(s, nextPairEnd);
  root.right = buildTree(s.substring(nextPairEnd, j));
  return root;
}
private int findNextPair(String s, int start){
  int j = start + 1;
  Stack<Integer> stack = new Stack<>();
  stack.push('(');
  while(true){
    if (s.charAt(j) == '(') stack.push('(');
    else if (s.charat(j) == ')') stack.pop();
    if (stack.isEmpty()) return j;
    j++;
  }
  return j;
}

// deduction
public TreeNode buildTree(String s){
   Stack<TreeNode> stack = new Stack<>(); // inorder traversal of the TreeNode
   Stack<Character> pstack = new Stack<>();
   int n = 0;
   TreeNode root = null;
   for (int i = 0; i < s.length(); i++){
     char c = s.charAt(i);
     if (c != '(' && c!=')'){
       n = n*10+(c-'0');
     }
     else if (c == '('){
       if (pstack.isEmpty()){ // i == 0
         pstack.push(c);
       }
       else { // i != 0,
         pstack.push(c);
         if (s.charAt(i-1) == ')') continue;
         TreeNode node = new TreeNode(n);
         if (!stack.isEmpty()){
           if (stack.peek().left == null) stack.peek().left = node;
           else stack.peek().right = node;
         }
         stack.push(node);
         n = 0;
       } // it is impossible to have last bit to be (, must be digit
     }
     else {//c == ')'
     TreeNode node = new TreeNode(n);
     n = 0;
       if (s.charAt(i-1) == ')')
       {
           pstack.pop();
           root = stack.pop();
       }
       else {
         TreeNode r = stack.peek();
         if (r.left == null) r.left = node;
         else r.right = node;
         pstack.pop();
       }
     }
   }
   return root;
 }


// 64 evaluator
// 65 files system

// 66 dna seq with length 10
public List<String> subStringWithLength(String s, int k){
  helper(s, 0, k, new StringBuilder());
  return res;
}
private void helper(String s, int start, int k, StringBuilder cur){
  if (start == s.length()){
    if (cur.length() == k) res.add(cur.toString());
  }
  else {
    helper(s, start + 1, k, cur);
    if (cur.length() < k){
    cur.append(s.charAt(start));
    helper(s, start + 1, k, cur);
    cur.deleteCharAt(cur.length - 1);}
  }
}

//67 24 rule 4 numbers add +-*/()to make it 24
public boolean canCompute(int []nums, int target){
  List<int[]> allpermutatin = getPermutation(nums);
  for (int[]n : allpermutatin){
    if(computeNum(n).contains(target))
      return true;
  }
  return false;
}
private List<int[]> getPermutation(int []nums){
  List<int[]> res = new ArrayList<>();
  Arrays.sort(nums);
  helper(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
  return res;
}
private void helper(List<int[]> res, int []nums, List<Integer> cur, boolean[]visit){
  if (cur.size() == nums.length){
    res.add(getArrayFromList(cur));
  }
  else {
    for (int i = 0; i < nums.length; i++){
      if (visit[i]) continue;
      if (i != 0 && nums[i] == nums[i-1] && !visit[i-1])  continue;
      cur.add(nums[i]);
      visit[i] = true;
      helper(res, nums, cur, visit);
      cur.remove(cur.size()-1);
      visit[i] = false;
    }
  }
}

private List<Integer> compute(int[] num, int start, int end){
  List<Integer> res = new ArrayList<>();
  if (start > end) {return res;}
  if (start == end) {
    res.add(num[start]); return res;
  }
  int mid = (start+end)/2;
  List<Integer> left = compute(num, start, mid);
  List<Integer> right = compute(num, mid + 1, end);
  for (int l : left){
    for (int r : right){
      res.add(l+r);
      res.add(l*r);
      res.add(l-r);
      if (r != 0) res.add(l/r);
    }
  }
  return res;
}


// desgin a evelator
public class Elevator{
  private int currentFloor;
  private int targetFloor;
  private int status;
  private static volatile Elevator instance = null;

  private Elevator() {
    this.currentFloor = 0;
    this.targetFloor = 0;
    this.status = 0;
  }

  public static Elevator getInstance() {
    if (instance == null) {
      Synchronized(this.class) {
        if (instance == null) {
          instance = new Elevator();
        }
      }
    }

    return instance;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }


  public int getStatus() {
    return status;
  }

  public void moveToFloor(int targetFloor) {
    while (currentFloor < targetFloor) {
      moveUp();
    }
    while (currentFloor > targetFloor) {
      moveDown();
    }

    status = 0;
  }

  private void moveUp() {
    status = 1;
    currentFloor += 1;
  }

  private void moveDown() {
    status = -1;
    currentFloor -= 1;
  }
}


public class RequestHandler {
  List<Request> requests;
  private static volatile RequestHandler instance = null;

  public static RequestHandler getInstance() {
    if (instance == null) {
      Synchronized(RequestHandler.class) {
        if (instance == null) {
          instance = new RequestHandler();
        }
      }
    }

    return instance;
  }

  private RequestHandler() {
    requests = new ArrayList<>();
  }


  public addRequest(Request req) {
    Synchronized(req) {
      requests.add(req);
    }
  }

  private Requst getNextRequest() {
    int curentFloor = Elevator.getInstance().getCurrentFloor();
    int shortestdistance = Integer.MAX_VALUE;
    Request next = null;

    for (Request req: requests) {
      if (Math.abs(req.floor - currentFLoor) < shortestdistance) {
        next = req;
      }
    }

    return next;
  }

  public void processRequest() {

    while (true) {
      Request req = getNextRequest();
      if (req != null) {
        while (Elevator.getInstance().getStatus() != 0);
        Elevator.getInstance().moveToFloor(req.getTargetFloor());
        request.remove(req);
      }
    }

  }
}


public class Request {

  private int targetFloor;
  Requst (int targetFloor) {
    this.targetFloor = targetFloor;
  }

  public int getTargetFloor() {
    return targetFloor;
  }
}


public class User{
  public void generateRequset(int targetFloor) {
    RequestHandler.getInstance().addRequest(new Request(targetFloor));
  }
}



// parking longestpublic class ParkingLot
public class ParkingLot
{
    Vector<ParkingSpace> vacantParkingSpaces = null;
    Vector<ParkingSpace> fullParkingSpaces = null;

    int parkingSpaceCount = 0;

    boolean isFull;
    boolean isEmpty;

    ParkingSpace findNearestVacant(ParkingType type)
    {
        Iterator<ParkingSpace> itr = vacantParkingSpaces.iterator();

        while(itr.hasNext())
        {
            ParkingSpace parkingSpace = itr.next();

            if(parkingSpace.parkingType == type)
            {
                return parkingSpace;
            }
        }
        return null;
    }

    void parkVehicle(ParkingType type, Vehicle vehicle)
    {
        if(!isFull())
        {
            ParkingSpace parkingSpace = findNearestVacant(type);

            if(parkingSpace != null)
            {
                parkingSpace.vehicle = vehicle;
                parkingSpace.isVacant = false;

                vacantParkingSpaces.remove(parkingSpace);
                fullParkingSpaces.add(parkingSpace);

                if(fullParkingSpaces.size() == parkingSpaceCount)
                    isFull = true;

                isEmpty = false;
            }
        }
    }

    void releaseVehicle(Vehicle vehicle)
    {
        if(!isEmpty())
        {
            Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

            while(itr.hasNext())
            {
                ParkingSpace parkingSpace = itr.next();

                if(parkingSpace.vehicle.equals(vehicle))
                {
                    fullParkingSpaces.remove(parkingSpace);
                    vacantParkingSpaces.add(parkingSpace);

                    parkingSpace.isVacant = true;
                    parkingSpace.vehicle = null;

                    if(vacantParkingSpaces.size() == parkingSpaceCount)
                        isEmpty = true;

                    isFull = false;
                }
            }
        }
    }

    boolean isFull()
    {
        return isFull;
    }

    boolean isEmpty()
    {
        return isEmpty;
    }
}

public class ParkingSpace
{
    boolean isVacant;
    Vehicle vehicle;
    ParkingType parkingType;
    int distance;
}

public class Vehicle
{
    int num;
}

public enum ParkingType
{
    REGULAR,
    HANDICAPPED,
    COMPACT,
    MAX_PARKING_TYPE,
}
