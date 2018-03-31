package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class _525 {
	public static void main(String[] args) {
		int[] test = {0,0,1,0,0,0,1,1};
		System.out.println(findMaxLength(test));
	}
	private static int findMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        /* Method 1: use Array*/
        // int len = nums.length;
        // int[] arr = new int[len*2 + 1];
        // Arrays.fill(arr, -2);
        // arr[len] = -1; // TODO: KEY POINT - value start from 0, maxLen = index - 0 + 1
        // int sum = len;
        // int maxCnt = 0;
        // for(int i = 0; i < len; ++i) {
        //     if(nums[i] == 0) sum--;
        //     else sum++;
        //     if(arr[sum] == -2) arr[sum] = i;
        //     maxCnt = Math.max(maxCnt, i - arr[sum]);
        // }
        // return maxCnt;
        
        /* Method 2: use Map */
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; ++i) {
            sum += (nums[i] == 0? -1: 1);
            if(!map.containsKey(sum)) map.put(sum, i);
            else maxLen = Math.max(maxLen, i - map.get(sum));
        }
        return maxLen;
    }
}
