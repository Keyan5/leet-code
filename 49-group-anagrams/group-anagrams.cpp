class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> group;
        for(string str: strs) {
            map<char, int> freq;
            for(char c: str)
                freq[c]++;
            string keyStr = "";
            for(auto [key, val]: freq)
                keyStr += key+to_string(val);
            group[keyStr].push_back(str);
        }
        vector<vector<string>> result;
        for(auto [_, group]: group)
            result.push_back(group);
        return result;
    }
};