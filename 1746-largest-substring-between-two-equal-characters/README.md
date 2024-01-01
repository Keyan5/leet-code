<h2><a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters">Largest Substring Between Two Equal Characters</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a string <code>s</code>, return <em>the length of the longest substring between two equal characters, excluding the two characters.</em> If there is no such substring return <code>-1</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> The optimal substring here is an empty substring between the two <code>&#39;a&#39;s</code>.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abca&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The optimal substring here is &quot;bc&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbzxy&quot;
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no characters that appear twice in s.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>

# Solution

# Intuition
When measuring the distance between two characters in a sequence, it's essential to keep track of the index of the first occurrence of the character. Upon encountering the same character again, calculate the difference between the current index and the initial index of that character. To find the maximum distance between occurrences of the same character, store the maximum difference obtained during the traversal of the sequence.


# Approach

The approach taken in this solution involves iterating through the given string, `s`, and maintaining an array `charWithInd` to store the index (1-based) of the first occurrence of each character encountered. The array has a size of 26,since input will have lowercase English letters. For each character, the code calculates the difference between the current index and the stored index of the same character. If the character has occurred before, the maximum difference encountered so far (`len`) is updated. If the character is encountered for the first time, its index is stored in the `charWithInd` array.

The strategy is to keep track of the earliest occurrence of each character and update the maximum distance whenever a character repeats. The final result, denoting the maximum distance between equal characters, is returned. This approach ensures an efficient way to find the maximum distance between repeated characters in the given string.


# Complexity

- Time complexity: $$O(n)$$

    The time complexity of the solution is linear with respect to the length of the input string, denoted as 'n'. The algorithm iterates through the string once, performing constant-time operations for each character. Therefore, the overall time complexity is O(n).

- Space complexity: $$O(1)$$

    The space complexity is constant since the size of the `charWithInd` array is fixed at 26, and it does not depend on the length of the input string. Hence, the space complexity is O(1). The algorithm uses a constant amount of extra space to store indices, making it efficient in terms of space utilization.

# Code
```
class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int len = -1;
        int charWithInd[26] = {0};
        for(int i=0; s[i]!='\0'; i++)
        {
            int mapInd = s[i]-'a';
            int existingCharInd = charWithInd[mapInd];
            if(existingCharInd)
                len = max(len, i-existingCharInd);
            else
                charWithInd[mapInd] = i+1;
        }
        return len;
    }
};
```
