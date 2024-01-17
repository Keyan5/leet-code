class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int,int> freq;
        for(auto ele: arr)
            freq[ele]++;
        set<int> unique;
        for(auto [key, val]: freq)
        {
            if(unique.find(val) != unique.end())
                return false;
            unique.insert(val);
        }
        return true;
    }
};