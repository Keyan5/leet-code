class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int,int> freq;
        for(int ele: nums) {
            if(freq[ele])
                return true;
            freq[ele]++;
        }
        return false;
    }
};