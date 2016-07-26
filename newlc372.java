// Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
//
// Example1:
//
// a = 2
// b = [3]
//
// Result: 8
//
// Example2:
//
// a = 2
// b = [1,0]
//
// Result: 1024

public class Solution {
  public class Solution {
      private final int mod = 1337;
      public int superPow(int a, int[] b) {
        return superPower(a,b,b.length);
      }
      private int superPower(int a, int []b, int len){
        if (len == 1) return myPower(a,b[0]);
        return myPower(superPower(a,b,len-1),10)*myPower(a,b[len-1])%mod;
      }
      private int myPower(int a, int b){
        if(a >= mod) a%=mod;
        if (b == 0) return 1;
        if (b == 1) return a%mod;
        int res = myPower(a,b/2);
        int temp = res*res%mod;
        if (b%2==0) return temp;
        return temp*a%mod;
      }
  }

}
