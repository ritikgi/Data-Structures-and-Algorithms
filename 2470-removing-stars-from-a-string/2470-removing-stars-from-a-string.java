class Solution {
    public String removeStars(String s) {
        // StringBuilder sb = new StringBuilder();
        // for(int i =0; i < s.length(); i++){
        //     char c = s.charAt(i);
        //     if(c == '*'){
        //         sb.deleteCharAt(sb.length()-1);
        //     }
        //     else{
        //         sb.append(c);
        //     }
        // }
        // return sb.toString();

        /*
        Above 
        Time Complexity (Worst case):
        append() is O(1) (amortized).
        deleteCharAt(sb.length() - 1) is O(1) in most implementations, but actually:

        - Internally, this might involve shifting elements, or at least adjusting 
        size, depending on JVM optimizations.

        - However, the key issue is memory copying and shifting in StringBuilder when 
        We deleteCharAt.

        - Also, the StringBuilder may resize its internal array dynamically, which
        can cause occasional performance hits.
        */

        char[] arr = new char[s.length()];
        int i = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(c == '*'){
                i--;
            } else{
                arr[i++] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j =0; j < i; j++){
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}
