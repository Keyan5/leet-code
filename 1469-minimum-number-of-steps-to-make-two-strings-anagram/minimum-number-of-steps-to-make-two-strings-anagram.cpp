class Solution {
public:
    int minSteps(string s, string t) {
        int res = 0;
        int freq[26] = {0};
        for(char c: s)    // o(m)
            freq[c-'a']++;
        for(char c: t)    // o(n)
            freq[c-'a']--;
        for(int val: freq)
            if(val>0)
                res += val;
        return res;
    }
};

auto init = []() 
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();