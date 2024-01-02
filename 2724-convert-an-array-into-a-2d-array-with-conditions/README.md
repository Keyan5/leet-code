<h2><a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions">Convert an Array Into a 2D Array With Conditions</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code>. You need to create a 2D array from <code>nums</code> satisfying the following conditions:</p>

<ul>
	<li>The 2D array should contain <strong>only</strong> the elements of the array <code>nums</code>.</li>
	<li>Each row in the 2D array contains <strong>distinct</strong> integers.</li>
	<li>The number of rows in the 2D array should be <strong>minimal</strong>.</li>
</ul>

<p>Return <em>the resulting array</em>. If there are multiple answers, return any of them.</p>

<p><strong>Note</strong> that the 2D array can have a different number of elements on each row.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,4,1,2,3,1]
<strong>Output:</strong> [[1,3,4,2],[1,3],[1]]
<strong>Explanation:</strong> We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [[4,3,2,1]]
<strong>Explanation:</strong> All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
</ul>

<br/>

# Solution

## Intuition
The problem involves creating a 2D array from an input array while satisfying certain conditions. To achieve this, the algorithm utilizes an unordered map (`freq`) to keep track of the frequency of each element in the input array `nums`. By determining the maximum frequency (`maxi`), the algorithm initializes the resulting 2D array with a number of rows equal to `maxi`. The intuition is to then iterate through the elements of `nums` and populate the unordered map `freq` based on their frequency.

This approach ensures that each row in the 2D array will contain distinct integers, as elements with the same value will be grouped together in the map. The algorithm leverages the frequency information to determine the number of rows needed and efficiently populates the resulting 2D array.

Overall, the intuition is to use frequency information to organize the elements into distinct rows in the 2D array, while minimizing the number of rows.

## Approach
1. Initialize an unordered map `freq` to keep track of the frequency of each element in `nums`.
2. Iterate through `nums` to count the frequency of each element and determine the maximum frequency `maxi`.
3. Initialize the resulting 2D array with a number of rows equal to `maxi`.
4. Iterate through the elements of `nums` and populate the unordered map `freq` based on their frequency.
5. Populate the resulting 2D array by grouping elements with the same value together in each row according to their frequency.

## Complexity
- Time complexity:
  - The loop to count the frequency of elements in `nums` takes $$O(n)$$ time, where $$n$$ is the size of the array.
  - The loop to populate the unordered map (`freq`) also takes $$O(n)$$ time in the worst case.
  - Therefore, the overall time complexity is $$O(n)$$.
- Space complexity:
  - The space complexity is $$O(n)$$, where $$n$$ is the size of the array. This is due to the unordered map (`freq`) and the resulting 2D array.

## Code
```cpp
class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int, int> freq;
        int maxi = 0;
        for (int num : nums) {
            freq[num]++;
            maxi = max(maxi, freq[num]);
        }
        vector<vector<int>> result(maxi);
        for (auto [key, value] : freq) {
            for (int ind = 0; ind < value; ind++) {
                result[ind].push_back(key);
            }
        }
        return result;
    }
};
```
