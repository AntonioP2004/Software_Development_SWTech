package Exercises21_7_9_11;

import java.util.*;

public class Ex21_7 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		HashMap<String, Integer> map = new HashMap<>();
		String key;
		int value;

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		entries.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()) == 0 ? entry1.getKey().compareTo(entry2.getKey()) : entry1.getValue().compareTo(entry2.getValue()));

		for (Map.Entry<String, Integer> entry: entries) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	static class WordOccurrence implements Comparable<WordOccurrence> {
		static int count;
		String[] word;
		
		WordOccurrence() {
			
		}
		
		@SuppressWarnings("static-access")
		@Override
		public int compareTo(WordOccurrence x) { 
				if (count > x.count) {
					return 1;
				} else if  (count == x.count) {
					return 0;
				} else {
					return -1;
				}
		}
		public static int setCount(int value) {
			return count = value;
		}
		public String[] setWord(String[] words) {
			return word = words;
		}
	}
}