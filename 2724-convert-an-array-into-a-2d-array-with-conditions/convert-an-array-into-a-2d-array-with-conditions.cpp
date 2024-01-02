class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int,int> freq;
        int maxi = 0;
        for(int num: nums) // o(n) always
        {
            freq[num]++;
            maxi = max(maxi, freq[num]);
        }
        vector<vector<int>> result(maxi);
        for(auto [key, value]: freq) // o(n) worst case
            for(int ind=0; ind<value; ind++)
                result[ind].push_back(key);
        return result;
    }
};