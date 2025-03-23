class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int maxVowels = 0, currentVowels = 0;
        
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++; 
            }
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowels--; 
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}