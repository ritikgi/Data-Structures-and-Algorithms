<h2><a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a></h2><h3>Medium</h3><hr><p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty">subarray</span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>



# Intuition
The key idea is that we can maintain two variables:

- `currSum`: Keeps track of the current sum of the subarray we're considering.
- `maxSum`: Stores the maximum sum encountered so far.

As we iterate through the array, we continuously update the `currSum` by adding the current element. If at any point `currSum` becomes negative, it is reset to zero because a negative sum would reduce the value of any subsequent subarrays. We also update `maxSum` to keep track of the highest value of `currSum`.

# Approach
1. Initialize `maxSum` to the first element of the array and `currSum` to 0.
2. Iterate through the array:
   - Add the current element to `currSum`.
   - Update `maxSum` to be the larger of `currSum` and `maxSum`.
   - If `currSum` becomes negative, reset it to 0.
3. Return `maxSum` after the loop finishes.

This approach ensures that we find the maximum sum of a contiguous subarray in a single pass through the array.

# Complexity
- **Time complexity**: $$O(n)$$, where $$n$$ is the number of elements in the array. We are iterating through the array once.
- **Space complexity**: $$O(1)$$. We only use a constant amount of extra space to store the `currSum` and `maxSum`.

