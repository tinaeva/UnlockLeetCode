package com.leetcode.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class _249 {
	public static void main(String[] args) {
		String[] str = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> res = groupStrings(str);
		for(List<String> list: res) {
			System.out.println(list);
		}
	}
	private static List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s: strings) {
        	int diff = 0;
        	List<String> list;
        	if(s.length() == 1) {
        		if(!map.containsKey("1")) {
        			list = new LinkedList<>();
        		} else {
        			list = map.get("1");
        		}
        		list.add(s);
        		map.put("1", list);
        	}
        	else {
        		for(int i = 1; i < s.length(); ++i) {
        			diff += (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
        		}
        		String str = String.valueOf(diff) + "|" + s.length();
        		if(!map.containsKey(str)) {
        			list = new LinkedList<>();
        		} else {
        			list = map.get(str);
        		}
        		list.add(s);
        		map.put(str, list);
        	}
        }
        List<List<String>> result = new LinkedList<>();
        for(List<String> list: map.values()) {
        	result.add(list);
        }
        return result;
    }
}
