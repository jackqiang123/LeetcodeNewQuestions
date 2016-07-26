// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
// Example 1:
//
// Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
//
// Return: [1,2],[1,4],[1,6]
//
// The first 3 pairs are returned from the sequence:
// [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//
// Example 2:
//
// Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
//
// Return: [1,1],[1,1]
//
// The first 2 pairs are returned from the sequence:
// [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//
// Example 3:
//
// Given nums1 = [1,2], nums2 = [3],  k = 3
//
// Return: [1,3],[2,3]
//
// All possible pairs are returned from the sequence:
// [1,3],[2,3]

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[]a,int[]b)->(-a[0]-a[1]+b[0]+b[1]));
        for (int i = 0; i < nums1.length; i++){
          for (int j = 0; j < nums2.length; j++){
            if (pq.size() < k) pq.add(new int[]{nums1[i],nums2[j]});
            else {
              int top[] = pq.peek();
              int topSum = top[0] + top[1];
              int curSum = nums1[i] + nums2[j];
              if (topSum < curSum) break;
              else {
                pq.remove();
                pq.add(new int[]{nums1[i],nums2[j]});
              }
            }
          }
        }
        return new ArrayList<int[]>(pq);
      }
}
