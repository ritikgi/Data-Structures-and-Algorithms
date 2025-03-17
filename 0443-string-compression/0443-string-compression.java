class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int i = 0;
        int n = chars.length;
        while(i < n){
            char ch = chars[i];
            int count = 1;
            while(i + 1 < n && chars[i+1] == ch){
                count++;
                i++;
            }
            chars[write++] = ch;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
            i++;
        }
        return write;
    }
}