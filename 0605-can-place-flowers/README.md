<h2><a href="https://leetcode.com/problems/can-place-flowers">605. Can Place Flowers</a></h2><h3>Easy</h3><hr><p>You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in <strong>adjacent</strong> plots.</p>

<p>Given an integer array <code>flowerbed</code> containing <code>0</code>&#39;s and <code>1</code>&#39;s, where <code>0</code> means empty and <code>1</code> means not empty, and an integer <code>n</code>, return <code>true</code>&nbsp;<em>if</em> <code>n</code> <em>new flowers can be planted in the</em> <code>flowerbed</code> <em>without violating the no-adjacent-flowers rule and</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 1
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 2
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= flowerbed.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>flowerbed[i]</code> is <code>0</code> or <code>1</code>.</li>
	<li>There are no two adjacent flowers in <code>flowerbed</code>.</li>
	<li><code>0 &lt;= n &lt;= flowerbed.length</code></li>
</ul>
<br>

# Intuition
The problem requires determining whether we can plant `n` flowers in a given `flowerbed` without violating the rule that no two flowers can be adjacent. Since a flower can only be planted in an empty spot (`0`), we check whether both its left and right neighbors are also empty (or out of bounds). By greedily placing flowers whenever possible, we maximize the number of flowers planted efficiently.

# Approach
1. Initialize a `count` variable to track the number of flowers placed.
2. Iterate through the `flowerbed` array.
3. At each index `i`, check if the current spot is `0` and if both its previous and next spots are also `0` (or out of bounds).
4. If the conditions allow planting, place a flower (`flowerbed[i] = 1`), increment `count`, and move to the next non-adjacent position (`i++`).
5. If `count` reaches or exceeds `n`, return `true` early.
6. If the loop completes and `count < n`, return `false`.

# Complexity
- **Time complexity:**  
  - $$O(n)$$: We iterate through the `flowerbed` array once, modifying it in-place.
- **Space complexity:**  
  - $$O(1)$$: No extra space is used apart from a few integer variables.

# Code
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == length - 1 || flowerbed[i + 1] == 0);

                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    count++;

                    if (count >= n) {
                        return true; 
                    }

                    i++;
                }
            }
        }
        return count >= n; 
    }
}

