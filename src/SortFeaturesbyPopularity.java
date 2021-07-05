class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> freq = new HashMap<>();
        // initialize features
        for (String feature: features) {
        	freq.put(feature, 0);
        }
        for (String res: responses) {
        	Set<String> set = new HashSet<>();
        	Collections.addAll(set, res.split(" "));
        	for (String word: set) {
        		if (freq.containsKey(word)) {
        			freq.put(word, freq.get(word) + 1);
        		}
        	}
        }
        Arrays.sort(features, (a, b) -> (freq.get(b) - freq.get(a)));
        return features;
    }
}