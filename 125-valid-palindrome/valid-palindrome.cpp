class Solution {
public:
    bool isPalindrome(string s) {
        int start = 0, end = s.size()-1;
        while(start < end) {
            char cs = tolower(s[start]);
            char ce = tolower(s[end]);
            if(!isalnum(cs))
                start++;
            if(!isalnum(ce))
                end--;
            if(isalnum(cs) && isalnum(ce)) {
                if(cs == ce)
                    start++, end--;
                else
                    return false;
            }
        }
        return true;
    }
};