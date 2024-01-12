class Solution {
public:
    bool isVowel(char c) {
        c = tolower(c);
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    bool halvesAreAlike(string s) {
        int count = 0;
        int len = s.size();
        for(int i=0; i<len; i++)
        {
            if( isVowel( s[i] ) )
                count += i<len/2 ? 1 : -1;
        }
        return count == 0;
    }
};