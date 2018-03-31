package com.leetcode.solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class _692 {
	public static void main(String[] args) {
		String[] word1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		String[] word2 = {"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println(topKFrequent2(word1, 4));
		System.out.println(topKFrequent2(word2, 1));
	}
	
	private static List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new TreeMap<>();
		Map<String, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            maxCnt = Math.max(maxCnt, map.get(word));
        }
        List<String>[] bucket = new List[maxCnt];
        for(String key: map.keySet()) {
            if(bucket[map.get(key) - 1] == null) bucket[map.get(key) - 1] = new LinkedList<String>();
            bucket[map.get(key) - 1].add(key);
        }
        List<String> res = new LinkedList<>();
        for(int i = maxCnt - 1; i >= 0; --i) {
        	if(bucket[i] == null) continue;
        	if(k <= 0) return res;
        	Collections.sort(bucket[i]);
        	for(String str: bucket[i]) {
        		if(k > 0) {
        			res.add(str);
        			k--;
        		}
        	}        	
//        	System.out.println("k is " + k + " and arr[i] is"+ bucket[i]);
//        	if(bucket[i].size() > k) bucket[i] = bucket[i].subList(0, k);
//        	res.addAll(bucket[i]);
//        	k -= bucket[i].size();
        }
        return res;
    }
	/*Utilize created Class and and defined PriorityQueue*/
	private static List<String> topKFrequent2(String[] words, int k) {
		if(words == null || words.length == 0 || k == 0) return null;
		Map<String, Word2> map = new HashMap<>();
		
//		Queue<Word> queue = new PriorityQueue<>(k, new Comparator<Word>(){
//			public int compare(Word a, Word b) {
//				if(a.count == b.count) return a.word.compareTo(b.word);
//				else return b.count - a.count;
//			}
//		});
		
		Queue<Word2> queue2 = new PriorityQueue<Word2>(k);
		
		for(String s: words) {
			Word2 word;
			if(!map.containsKey(s)) {
				word = new Word2(s, 1);
			} else {
				word = map.get(s);
				word.count += 1;
			}
			map.put(s, word);
		}
		
		for(Map.Entry<String, Word2> entry: map.entrySet()) {
			queue2.offer(entry.getValue());
		}
		
		List<String> res = new LinkedList<>();
		for(int i = 0; i < queue2.size(); ++i) {
//			res.add(queue.poll().word);
			System.out.println(queue2.poll().word);
		}
		return res;
	}
}
class Word {
	public String word;
	public int count;
	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
}

class Word2 implements Comparable<Word2> {
	public String word;
	public int count;
	public Word2(String word, int count) {
		this.word = word;
		this.count = count;
	}
	public int compareTo(Word2 other) {
		if(this.count == other.count) return this.word.compareTo(other.word);
		else if(this.count < other.count) return 1;
		else return -1;
	}
}
