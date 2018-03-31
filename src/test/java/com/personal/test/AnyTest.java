package com.personal.test;

import java.util.Arrays;

public class AnyTest {
	public static void main(String[] args) {
		int[][] points = new int[][]{{1,0},{0,0},{2,0}};
		
		for(int[] arr: points) {
			for(int i: arr)
			System.out.println(i);
		}
//		
//		Arrays.sort(points);
//
//		for(int[] arr: points) {
//			for(int i: arr)
//			System.out.println(i);
//		}
	}
	

}
