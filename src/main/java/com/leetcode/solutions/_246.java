/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class _246 {
	static final Map<Character, Character> map = new HashMap<>();
	static{
		map.put('6', '9');
	    map.put('9', '6');
	    map.put('0', '0');
	    map.put('1', '1');
	    map.put('8', '8');
	}   
    
	public boolean isStrobogrammatic(String num) {
		/*int len = num.length();
		for(int i = 0; i < len/2 + 1; ++i) {
			char c = num.charAt(i);
			if(!map.containsKey(c)) return false;
			if(map.get(c) != num.charAt(len - i - 1)) return false;
		}
		return true;
		*/
		for(int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			if(!"00 11 88 696".contains(num.charAt(i)+""+num.charAt(j))) return false;
		}
		return true;
    }
}
