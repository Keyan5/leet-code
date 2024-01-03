<h2><a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank">Number of Laser Beams in a Bank</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Anti-theft security devices are activated inside a bank. You are given a <strong>0-indexed</strong> binary string array <code>bank</code> representing the floor plan of the bank, which is an <code>m x n</code> 2D matrix. <code>bank[i]</code> represents the <code>i<sup>th</sup></code> row, consisting of <code>&#39;0&#39;</code>s and <code>&#39;1&#39;</code>s. <code>&#39;0&#39;</code> means the cell is empty, while<code>&#39;1&#39;</code> means the cell has a security device.</p>

<p>There is <strong>one</strong> laser beam between any <strong>two</strong> security devices <strong>if both</strong> conditions are met:</p>

<ul>
	<li>The two devices are located on two <strong>different rows</strong>: <code>r<sub>1</sub></code> and <code>r<sub>2</sub></code>, where <code>r<sub>1</sub> &lt; r<sub>2</sub></code>.</li>
	<li>For <strong>each</strong> row <code>i</code> where <code>r<sub>1</sub> &lt; i &lt; r<sub>2</sub></code>, there are <strong>no security devices</strong> in the <code>i<sup>th</sup></code> row.</li>
</ul>

<p>Laser beams are independent, i.e., one beam does not interfere nor join with another.</p>

<p>Return <em>the total number of laser beams in the bank</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser1.jpg" style="width: 400px; height: 368px;" />
<pre>
<strong>Input:</strong> bank = [&quot;011001&quot;,&quot;000000&quot;,&quot;010100&quot;,&quot;001000&quot;]
<strong>Output:</strong> 8
<strong>Explanation:</strong> Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0<sup>th</sup> row with any on the 3<sup>rd</sup> row.
This is because the 2<sup>nd</sup> row contains security devices, which breaks the second condition.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser2.jpg" style="width: 244px; height: 325px;" />
<pre>
<strong>Input:</strong> bank = [&quot;000&quot;,&quot;111&quot;,&quot;000&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There does not exist two devices located on two different rows.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == bank.length</code></li>
	<li><code>n == bank[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>bank[i][j]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>

<br/>

# Solution

### *While there may be more optimal solutions, this is my approach to answering the question at hand.*

---

# Intuition
The problem involves counting the number of laser beams between security devices in a bank. The algorithm uses a map (`indWithCount`) to store the count of security devices per row. It then iterates through the rows of the bank, counting the number of '1's in each row and updating the map accordingly.

To calculate the total number of laser beams, the algorithm iterates through the map and sums up the product of the count of security devices on the current row (`value`) and the count of security devices on all previous rows. This accounts for the conditions that there should be a laser beam between devices on different rows, and there should be no security devices in the rows between them.

The intuition behind this approach is to leverage the frequency of security devices per row to determine the number of laser beams. By considering each row independently and accumulating the total count, the algorithm efficiently calculates the desired result.

# Approach
1. Initialize a map `indWithCount` to store the count of security devices per row.
2. Iterate through the rows of the bank, counting the number of '1's in each row and updating the map accordingly.
3. Initialize variables `beams` and `prevKey` to calculate the total number of laser beams.
4. Iterate through the map and sum up the product of the count of security devices on the current row (`value`) and the count of security devices on all previous rows.

# Complexity
- Time complexity:
    - The first loop to count the number of security devices per row takes $$O(m \cdot n)$$ time, where `m` is the number of rows and `n` is the number of columns.
    - The second loop to calculate the total number of laser beams takes $$O(m)$$ time in the worst case.
    - Therefore, the overall time complexity is $$O(m \cdot n)$$.

- Space complexity:
    - The space complexity is $$O(m)$$, where `m` is the number of rows. This is due to the map `indWithCount`.

# Code
```cpp
class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        map<int,int> indWithCount; // security device per row
        int m = bank.size();
        for(int ind=0; ind<m; ind++)  // o(m*n)
            for(auto cell: bank[ind])
                if(cell == '1')
                    indWithCount[ind]++;
        int beams = 0, prevKey = 0;
        for(auto [key, value]: indWithCount) // o(m)
        {
            if(key != prevKey)
                beams += value * indWithCount[prevKey];
            prevKey = key;
        }
        return beams;
    }
};
```
