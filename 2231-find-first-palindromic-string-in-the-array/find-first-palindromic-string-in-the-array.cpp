class Solution {
public:
    bool isPalindrome(string str) {
        int len = str.size();
        for(int i=0; i<len; i++)
            if(str[i] != str[len - i - 1])
                return false;
        return true;
    }

    string firstPalindrome(vector<string>& words) {
        for(string word: words)
            if( isPalindrome(word) )
                return word;
        return "";
    }
};