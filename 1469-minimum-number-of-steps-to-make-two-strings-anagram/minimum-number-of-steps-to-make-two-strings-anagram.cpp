class Solution {
public:
    int minSteps(string s, string t) {
        int res = 0;
        int freq[26] = {0};
        int len = s.size();
        for(int i=0; i<len; i++)
        {
            freq[s[i]-'a']++;
            freq[t[i]-'a']--;
        }
        for(int val: freq)
            res += max(0, val);
        return res;
    }
};