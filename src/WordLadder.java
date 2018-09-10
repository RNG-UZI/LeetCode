public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) return 0;
		Set<String> startSet = new HashSet<String>(), endSet = new HashSet<String>(), dictSet = new HashSet<String>();
		startSet.add(beginWord);
		endSet.add(endWord);
		int len = 1;
		for (String temp : wordList) {dictSet.add(temp);}
		while (!startSet.isEmpty() && !endSet.isEmpty()) {
			if (startSet.size() > endSet.size()) {
				Set<String> tmpSet = startSet; startSet = endSet;
				endSet = tmpSet;
			}
			Set<String> tmp = new HashSet<String>();
			for (String word : startSet) {
				char[] charArr = word.toCharArray();
				for (int i = 0; i < word.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) { 
						char replace = charArr[i];
						charArr[i] = c;
						String s = new String(charArr);
						if (endSet.contains(s))
							return len + 1;
						if (dictSet.contains(s)) {
							tmp.add(s);
							dictSet.remove(s);
						}
						charArr[i] = replace;// change it back }
					}
				}
			}	
			startSet = tmp;
			len++;
		}
		return 0;
	}
}