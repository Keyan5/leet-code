<h2><a href="https://leetcode.com/problems/assign-cookies">Assign Cookies</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.</p>

<p>Each child <code>i</code> has a greed factor <code>g[i]</code>, which is the minimum size of a cookie that the child will be content with; and each cookie <code>j</code> has a size <code>s[j]</code>. If <code>s[j] &gt;= g[i]</code>, we can assign the cookie <code>j</code> to the child <code>i</code>, and the child <code>i</code> will be content. Your goal is to maximize the number of your content children and output the maximum number.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> g = [1,2,3], s = [1,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> g = [1,2], s = [1,2,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= g.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= g[i], s[j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<br/>

# Solution

## Intuition
The goal of this problem is to distribute cookies to children in a way that maximizes the number of content children. To achieve this, it is essential to match each child with a cookie whose size meets or exceeds the child's greed factor. Sorting the arrays representing children's greed factors (`g`) and cookie sizes (`s`) allows for a straightforward traversal to find suitable matches.

## Approach
The provided solution sorts both the `g` and `s` arrays in ascending order. Then, it iterates through the greed factors, attempting to find a suitable cookie for each child. The `sizeInd` variable keeps track of the current index in the sorted cookie sizes array. The algorithm uses a while loop to find the smallest cookie that satisfies the current child's greed factor.

If a suitable cookie is found, the `contentChildren` count is incremented, and the index is moved to the next cookie size. The process continues until all children are considered or there are no more cookies available.

## Complexity
- Time complexity: $$O(n \log n)$$

    The dominant factor in the time complexity is the sorting of both the `g` and `s` arrays, which takes $$O(n \log n)$$ time, where $$n$$ is the size of the larger array. The subsequent iteration through the arrays is linear, resulting in a final time complexity of $$O(n \log n)$$. The while loop within the iteration ensures that each cookie is considered at most once.

- Space complexity: $$O(1)$$

    The space complexity is constant since the sorting is performed in-place, and no additional data structures are used. The algorithm uses a constant amount of extra space, making it efficient in terms of space utilization.

## Code
```cpp
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int contentChildren = 0;

        if (g.size() == 0 || s.size() == 0)
            return 0;

        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int sizeLen = s.size();
        int sizeInd = 0;

        for (int child : g) {
            while (sizeInd < sizeLen && s[sizeInd] < child) {
                sizeInd++;
            }
            if (sizeInd >= sizeLen)
                return contentChildren;
            sizeInd++;
            contentChildren++;
        }
        return contentChildren;
    }
};
```
