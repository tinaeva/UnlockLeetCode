/*
 * 325. Maximum Size Subarray Sum Equals k
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/
package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class _325 {
	public static void main(String[] args) {
		int[] nums = {1, -1, 5, -2, 3};
		int[] nums2 = {-2,-1, 2, 1};
		int[] nums3 = {1, 0, -1};
		System.out.println(maxSubArrayLen(nums, 3) + " " + maxSubArrayLen(nums2, -1) + " " + maxSubArrayLen(nums3, -1));
	}
	
	static int maxSubArrayLen(int[] nums, int k) {
		// if there are duplicates, then need to have List<Integer> as value in map?? Nop, only record first encounter index.
		Map<Integer, Integer> map = new HashMap<>();
		int len = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if(!map.containsKey(sum))
				map.put(sum, i);
			if(sum == k) 
				len = i + 1;
			else if(map.containsKey(sum - k)) {
				len = Math.max(len, i - map.get(sum - k));
			}
		}
//		for(int key: map.keySet()) {
//			if(map.containsKey(key + k)) {
//				if(key == 0) len = Math.max(len,map.get(key + k) - map.get(key) + 2);
//				else len = Math.max(len,map.get(key + k) - map.get(key));				
//			}
//		}
		return len;
	}
}
