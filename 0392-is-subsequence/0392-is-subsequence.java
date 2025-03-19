class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;  // Move pointer in s when characters match
            }
            j++;  // Always move pointer in t
        }
        return i == s.length();  // If i reaches end of s, it is a subsequence
    }
}