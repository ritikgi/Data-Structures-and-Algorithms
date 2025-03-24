class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> occurrences = new HashSet<>(frequencyMap.values());
        return frequencyMap.size() == occurrences.size(); 
    }
}