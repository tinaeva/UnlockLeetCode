/*
 * Two Sum III - Data structure design
 * Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/*
 * The trade off should be considered: 
 * In fact, there has to be one operation's time complexity is O(n) and the other is O(1), no matter add or find. 
 * So clearly there's trade off when solve this problem, prefer quick find or quick add.
*/
class _170 {
	Set<Integer> nums;
	Set<Integer> sums;
	_170() {
		nums = new HashSet<>();
		sums = new HashSet<>();
	}
	
	void add(int num) {
		nums.add(num);
		for(int i: nums) {
			sums.add(i + num);
		}
	}
	
	boolean find(int value) {
		return sums.contains(value);
	}
	
	/*
	Map<Integer, Integer> map;
	_170() {
		map = new HashMap<Integer, Integer>();
	}
	void add(int num) {
		map.put(num, map.getOrDefault(num, 0) + 1);
	}
	
	boolean find(int value) {
		for(int i: map.keySet()) {
			if(value - i == i && map.get(i) > 1) return true;
			else if(map.containsKey(value - i)) return true;
		}
		return false;
	}
	*/
}
