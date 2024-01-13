class Solution {
public:
    int minSteps(string s, string t) {
        int res = 0;
        unordered_map<char, int> freq;  // o(m+n)
        for(char c: s)    // o(m)
            freq[c]++;
        for(char c: t)    // o(n)
            freq[c]--;
        for(auto [key, val]: freq)  // o(m+n)
            if(val>0)
                res += val;
        return res;
    }
};