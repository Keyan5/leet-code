class Solution {
public:
    int minSteps(string s, string t) {
        int res = 0;
        unordered_map<char, int> freq;
        for(char c: s)
            freq[c]++;
        for(char c: t)
            freq[c]--;
        for(auto [key, val]: freq)
            if(val>0)
                res += val;
        return res;
    }
};