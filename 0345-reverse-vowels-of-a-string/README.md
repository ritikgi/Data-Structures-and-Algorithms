<h2><a href="https://leetcode.com/problems/reverse-vowels-of-a-string">345. Reverse Vowels of a String</a></h2><h3>Easy</h3><hr><p>Given a string <code>s</code>, reverse only all the vowels in the string and return it.</p>

<p>The vowels are <code>&#39;a&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;i&#39;</code>, <code>&#39;o&#39;</code>, and <code>&#39;u&#39;</code>, and they can appear in both lower and upper cases, more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;IceCreAm&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;AceCreIm&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>The vowels in <code>s</code> are <code>[&#39;I&#39;, &#39;e&#39;, &#39;e&#39;, &#39;A&#39;]</code>. On reversing the vowels, s becomes <code>&quot;AceCreIm&quot;</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;leetcode&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;leotcede&quot;</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consist of <strong>printable ASCII</strong> characters.</li>
</ul>
<br>

# Intuition
The problem requires us to reverse only the vowels in a string while keeping the order of other characters unchanged. Since we only need to swap vowels, we can use a two-pointer approach to efficiently reverse vowels without modifying other characters.

# Approach
1. Convert the string into a character array (`char[] ch`) since strings are immutable in Java.
2. Use two pointers (`left` and `right`):
   - `left` starts at the beginning of the string.
   - `right` starts at the end of the string.
3. Use a **HashSet** to store all vowels (`aeiouAEIOU`) for **faster lookups** (O(1) average time complexity).
4. Move `left` forward until it finds a vowel.
5. Move `right` backward until it finds a vowel.
6. Swap the vowels found at `left` and `right`.
7. Repeat until `left` crosses `right`.
8. Convert the modified character array back to a string and return it.

This approach ensures that each vowel is processed only once while avoiding unnecessary operations on non-vowel characters.

# Complexity
- **Time complexity:**  
  - Each character is processed at most **once** (either skipped or swapped).  
  - HashSet lookups for vowels are **O(1)** on average.  
  - Overall, the approach runs in **O(n)**, where `n` is the length of the string.  

- **Space complexity:**  
  - The extra space used includes:  
    - The **character array** (`O(n)`) for modifying the string.  
    - A **HashSet of vowels** (`O(1)`, since it only holds a small fixed set of 10 vowels).  
  - Overall, **O(n)** due to the character array.  

# Code
```java []
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
```
