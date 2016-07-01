// Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
//
// The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
//
// You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
//
// Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
//
// When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
//
// Example:
// Given width = 3, height = 2, and food = [[1,2],[0,1]].
//
// Snake snake = new Snake(width, height, food);
//
// Initially the snake appears at position (0,0) and the food at (1,2).
//
// |S| | |
// | | |F|
//
// snake.move("R"); -> Returns 0
//
// | |S| |
// | | |F|
//
// snake.move("D"); -> Returns 0
//
// | | | |
// | |S|F|
//
// snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
//
// | |F| |
// | |S|S|
//
// snake.move("U"); -> Returns 1
//
// | |F|S|
// | | |S|
//
// snake.move("L"); -> Returns 2 (Snake eats the second food)
//
// | |S|S|
// | | |S|
//
// snake.move("U"); -> Returns -1 (Game over because snake collides with border)
class Body{
   Body prev;
   int x;
   int y;
   public Body(Body prev, int x, int y){
     this.prev = prev; this.x = x; this.y = y;
   }
 }
public class SnakeGame {

     /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
     int [][]food;
     int foodCount;
     Set<Integer> set;
     Body head;
     Body tail;
     int width;
     int height;
     public SnakeGame(int width, int height, int[][] food) {
       this.width = width;
       this.height = height;
       foodCount = 0;
       this.food = food;
       head = new Body(null, 0, 0);
       tail = head;
       set = new HashSet<Integer>();
       set.add(0);
     }

     /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
     public int move(String direction) {
       int hx = head.x;
       int hy = head.y;
       if (direction.equals("U")){
         hx--;
       }
       else if (direction.equals("L")){
         hy--;
       }
       else if (direction.equals("R")){
         hy++;
       }
       else {
         hx++;
       }
       if (hx < 0 || hx >= height || hy < 0 || hy >= width) return -1;//boundary
       int fx = foodCount >= food.length?-1:food[foodCount][0];
       int fy = foodCount >= food.length?-1:food[foodCount][1];
       if (fx != hx || fy != hy){//does not hit the food
           Body newHead = new Body(null, hx, hy);
           set.remove(tail.x*width+tail.y);
           if (tail.prev == null){
             tail = newHead;
             head = newHead;
           }
           else {
             tail = tail.prev;
             head.prev = newHead;
             head = newHead;
           }
       }
       else { // hit the food
          foodCount++;
         Body newHead = new Body(null, hx, hy);
         if (tail.prev == null){
           tail.prev = newHead;
           head = newHead;
         }
         else {
           head.prev = newHead;
           head = newHead;
         }
       }

       if (set.contains(head.x*width + head.y)) return -1;
       set.add(head.x*width+head.y);
       return set.size() - 1;

     }
 }
