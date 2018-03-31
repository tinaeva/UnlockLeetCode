package com.leetcode.solutions;

import java.util.Arrays;

class _409 {
	public static void main(String[] args) {
		String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//		System.out.println(str);
//		char[] temp = str.toCharArray();
//		Arrays.sort(temp);
//		for(char c: temp) {
//			System.out.print(c);
//		}
		System.out.println(longestPalindrome(str));
	}
	private static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] arr = new int[256];
        for(char c: s.toCharArray()) {
            arr[c] += 1;
        }
        int res = 0;
        int odd = 0;
        for(int i = 0; i < 256; ++i) {
            res += arr[i] / 2 * 2;
            if(arr[i] % 2 == 1) odd = 1;
        }
        return res + odd;
    }
}
