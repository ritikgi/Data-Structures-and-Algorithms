class Solution {
    // Not the best Way
    /*
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left=0, right=ch.length-1;
        String vowels = "AEIOUaeiou";
        while(left < right){
            while(left < right && vowels.indexOf(ch[left]) == -1){
                left++;
            }
            while(left < right && vowels.indexOf(ch[right]) == -1){
                right--;
            }
            char swap = ch[left];
            ch[left] = ch[right];
            ch[right] = swap;
            left++;
            right--;
        }
        return new String(ch);
    }
    */
    //Optimized using HashSet for faster lookups
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left=0, right=ch.length-1;

        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        while(left < right){
            while(left < right && !vowels.contains(ch[left])){
                left++;
            }
            while(left < right && !vowels.contains(ch[right])){
                right--;
            }
            char swap = ch[left];
            ch[left] = ch[right];
            ch[right] = swap;
            left++;
            right--;
        }
        return new String(ch);
    }
}