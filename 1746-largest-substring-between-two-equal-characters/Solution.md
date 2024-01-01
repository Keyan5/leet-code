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
