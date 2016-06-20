// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
// The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically.
// Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that
// encloses all black pixels.
//
// For example, given the following image:
//
// [
//   "0010",
//   "0110",
//   "0100"
// ]
// and x = 0, y = 2,
// Return 6.
public class Solution{
   public int minArea(char[][] image, int x, int y) {
     int h = image.length;
     int w = image[0].length;
     int x1 = findLow(image, 0, x, true);
     int x2 = findHigh(image, x, h - 1, true);
     int y1 = findLow(image, 0, y, false);
     int y2 = findHigh(image, y, w - 1, false);
     return (x2 - x1 + 1) * (y2 - y1 + 1);
   }
   private int findLow(char[][]image, int lo, int hi, boolean alongx){
     while(lo < hi){
       int mid = lo + (hi - lo)/2;
       if (check(image, mid, alongx)) hi = mid;
       else lo = mid + 1;
     }
     return lo;
   }
   private int findHigh(char[][]image, int lo, int hi, boolean alongx){
     while(lo < hi){
       int mid = lo + (hi-lo)/2;
       if (check(image, mid, alongx)) lo = mid + 1;
       else hi = mid;
     }
     return check(image, lo, alongx) ? lo : lo - 1;
   }
   private boolena check(char[][]image, int i, boolean alongx){
     if (alongx){
       for (int j = 0; j < w; j++){
         if (image[i][j] == '1') return true;
       }
       return false;
     }
     else {
       for (int j = 0; j < h; j++){
         if (image[j][i] == '1') return true;
       }
       return false;
     }
   }
}
