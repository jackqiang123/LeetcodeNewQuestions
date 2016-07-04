// Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
//
// Example 1:
//
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// return [9, 8, 6, 5, 3]
//
// Example 2:
//
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// return [6, 7, 6, 0, 4]
//
// Example 3:
//
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// return [9, 8, 9]
public// Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
//
// Example 1:
//
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// return [9, 8, 6, 5, 3]
//
// Example 2:
//
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// return [6, 7, 6, 0, 4]
//
// Example 3:
//
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// return [9, 8, 9]
public  class Solution {
		  public int[] maxNumber(int[] nums1, int[] nums2, int k){
				int res[] = new int[k];
				int p1 = 0;
				int p2 = 0;
				int index = 0;
				for (int leftCount = 0; leftCount <= nums1.length; leftCount++){
					int rightCount = k - leftCount;
					if (rightCount < 0 || rightCount > nums2.length) continue;
					int []left = getMax(nums1, leftCount);
					int []right = getMax(nums2, k - leftCount);
					int []merge = merge(left, right);
					if (compareFun(res, 0, merge, 0)) res = merge;
				}
				return res;
      }
			private int[]getMax(int []nums, int len){
				int []res = new int[len];
				int index = 0;
				int max = index;
				while(index < len){
					for (int i = max; i + len - index <= nums.length; i++){
						if (nums[i] > nums[max]) max = i;
					}
					res[index++] = nums[max++];
				}
				return res;
			}

			private int[]merge(int []left, int []right){
				int res[] = new int[left.length+right.length];
				int p1 = 0;
				int p2 = 0;
				int index = 0;
				while(index < res.length){
					if (compareFun(left,p1,right,p2)) res[index++] = right[p2++];
					else res[index++] = left[p1++];
				}
				return res;
			}
			// nums1 <= nums2 return true
			private boolean compareFun(int[]nums1, int p1, int nums2[], int p2){
				while(p1 < nums1.length && p2 < nums2.length){
					if (nums1[p1] < nums2[p2]) return true;
					else if (nums1[p1] > nums2[p2]) return false;
					else {p1++;p2++;}
				}
				if (p1 >= nums1.length) return true;
				return false;
			}
}
