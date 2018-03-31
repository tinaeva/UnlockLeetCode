/**
 * 726. Number of Atoms
 * Given a chemical formula (given as a string), return the count of each atom.
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 */
package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class _726 {
	public static void main(String[] args) {
		String[] formulas = {"H2O", "Mg(OH)2", "K4(ON(SO3)2)2","K4(ON(SO3)2K)2"}; 
		for(String s: formulas) {
			System.out.println(countOfAtoms(s));
		}
	}
	private static String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        int currLev = 0;
        int i = 0;
        String elem;
        while(i < formula.length() - 1) {
        	if(formula.charAt(i) == '(') {
        		currLev++;
        	} else if(formula.charAt(i) == ')') {
        		int j = i + 1;
        		while(j < formula.length() && formula.charAt(j) >= '0' && formula.charAt(j) <= '9') ++j;
        		Stack<String> temp = new Stack<>();
        		while(level.peek() == currLev) {
	        		level.pop();
	        		elem = stack.pop();
	        		elem = updateElem(elem, formula.substring(i+1, j));
	        		temp.add(elem);
        		}
        		currLev--;
        		for(String e: temp) {
        			level.push(currLev);
        			stack.push(e);
        		}
        		i = j;
        	} else {
	        	elem = findAtom(formula,i);
	        	stack.push(elem);
	        	level.push(currLev);
	        	i += elem.length();
        	}
        }
        Map<String, String> map = new HashMap<>();
        while(!stack.isEmpty()){
        	stack.pop();
//        	TODO: To Be Done.....
        }
        return null;
    }
	private static String updateElem(String elem, String num) {
		if(num.length() == 0) return elem;
		if(elem.length() == 1) return elem + num;
		int i = 1;
		while(elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z') ++i;
		int prod = Integer.valueOf(num) * Integer.valueOf(elem.substring(i));
		return elem.substring(0, i) + prod;
	}
	private static String findAtom(String formula, int start) {
		char[] arr = formula.toCharArray();
		int end = start + 1;
		while(arr[end] >= 'a' && arr[end] <= 'z') ++end;
    	while(arr[end] >= '0' && arr[end] <= '9') ++end;
    	return formula.substring(start, end);
	}
}