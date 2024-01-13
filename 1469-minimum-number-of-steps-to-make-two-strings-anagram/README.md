<h2><a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram">Minimum Number of Steps to Make Two Strings Anagram</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given two strings of the same length <code>s</code> and <code>t</code>. In one step you can choose <strong>any character</strong> of <code>t</code> and replace it with <strong>another character</strong>.</p>

<p>Return <em>the minimum number of steps</em> to make <code>t</code> an anagram of <code>s</code>.</p>

<p>An <strong>Anagram</strong> of a string is a string that contains the same characters with a different (or the same) ordering.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bab&quot;, t = &quot;aba&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> Replace the first &#39;a&#39; in t with b, t = &quot;bba&quot; which is anagram of s.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;leetcode&quot;, t = &quot;practice&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> Replace &#39;p&#39;, &#39;r&#39;, &#39;a&#39;, &#39;i&#39; and &#39;c&#39; from t with proper characters to make t anagram of s.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;anagram&quot;, t = &quot;mangaar&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> &quot;anagram&quot; and &quot;mangaar&quot; are anagrams. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s.length == t.length</code></li>
	<li><code>s</code> and <code>t</code> consist of lowercase English letters only.</li>
</ul>

<br/>

# Solution

# Intuition
The problem asks to find the minimum number of steps required to make two strings, `s` and `t`, anagrams of each other. An anagram of a string is a string that contains the same characters with a different (or the same) ordering. The algorithm uses a frequency array to count the occurrences of characters in both strings and then calculates the minimum number of steps needed to make them anagrams.

# Approach
The algorithm initializes a variable `res` to zero and a frequency array `freq` of size 26 to store the occurrences of characters. It then iterates through both strings `s` and `t`, incrementing the count for the characters in `s` and decrementing the count for the characters in `t`. After the iteration, it calculates the minimum number of steps needed by iterating through the `freq` array and summing the positive values.

This is because a positive value indicates that the character belongs only to string `s`, and a negative value indicates that the character belongs only to string `t`. The value of 0 indicates that the character is present in both strings with equal frequency, and no steps are needed for such characters.

Value | Belongs To
:---: | :---:
Positive | s
Negative | t
0 | Both

# Complexity
- Time complexity: $$O(N)$$, where N is the length of the strings `s` and `t`.
  - The algorithm iterates through both strings once.
- Space complexity: $$O(1)$$
  - The algorithm uses a constant amount of space for the frequency array.

# Code
```cpp
class Solution {
public:
    int minSteps(string s, string t) {
        int res = 0;
        int freq[26] = {0};
        int len = s.size();
        for (int i = 0; i < len; i++) {
            freq[s[i] - 'a']++;
            freq[t[i] - 'a']--;
        }
        for (int val : freq)
            res += max(0, val);
        return res;
    }
};
```
