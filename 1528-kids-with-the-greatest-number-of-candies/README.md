<h2><a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies">1528. Kids With the Greatest Number of Candies</a></h2><h3>Easy</h3><hr><p>There are <code>n</code> kids with candies. You are given an integer array <code>candies</code>, where each <code>candies[i]</code> represents the number of candies the <code>i<sup>th</sup></code> kid has, and an integer <code>extraCandies</code>, denoting the number of extra candies that you have.</p>

<p>Return <em>a boolean array </em><code>result</code><em> of length </em><code>n</code><em>, where </em><code>result[i]</code><em> is </em><code>true</code><em> if, after giving the </em><code>i<sup>th</sup></code><em> kid all the </em><code>extraCandies</code><em>, they will have the <strong>greatest</strong> number of candies among all the kids</em><em>, or </em><code>false</code><em> otherwise</em>.</p>

<p>Note that <strong>multiple</strong> kids can have the <strong>greatest</strong> number of candies.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candies = [2,3,5,1,3], extraCandies = 3
<strong>Output:</strong> [true,true,true,false,true] 
<strong>Explanation:</strong> If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candies = [4,2,1,1,2], extraCandies = 1
<strong>Output:</strong> [true,false,false,false,false] 
<strong>Explanation:</strong> There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> candies = [12,1,12], extraCandies = 10
<strong>Output:</strong> [true,false,true]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == candies.length</code></li>
	<li><code>2 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= candies[i] &lt;= 100</code></li>
	<li><code>1 &lt;= extraCandies &lt;= 50</code></li>
</ul>
<br><br>

# Intuition
The problem requires us to determine if a child, after receiving extra candies, can have the greatest number of candies among all kids.  
The key observation is that the child only needs to meet or exceed the **maximum** number of candies initially present.

# Approach
1. **Find the Maximum Candies**  
   - First, determine the maximum number of candies any child currently has.  
   - This can be done in **one pass** through the `candies` array.  

2. **Check Each Kid's Potential**  
   - Iterate through the `candies` array again.  
   - For each child, check if their current candies **plus** the extra candies is **greater than or equal to** the previously found maximum.  
   - If so, mark them as `true` in the result list; otherwise, mark them as `false`.

3. **Optimizations Used**  
   - Using `Math.max()` to simplify the maximum-finding loop.  
   - Using `res.add(candies[i] + extraCandies >= max);` instead of an explicit `if-else`, making the code cleaner and more efficient.

# Complexity
- **Time complexity:**  
  - Finding the maximum takes **O(n)**.  
  - Iterating again to check conditions takes **O(n)**.  
  - Hence, the overall complexity is **O(n) + O(n) = O(n)**.

- **Space complexity:**  
  - The output list `res` requires **O(n)** space, as we store a Boolean value for each child.  
  - No additional data structures are used apart from a few variables.  
  - Thus, the space complexity is **O(n)**.

# Code
```java
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int n = candies.length;
        List<Boolean> res = new ArrayList<>(n);

        // Step 1: Find the maximum candies any kid currently has
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        // Step 2: Check if each kid can have the max candies
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }

        return res;
    }
}

