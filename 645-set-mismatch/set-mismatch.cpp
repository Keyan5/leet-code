class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int len = nums.size();
        vector<int> numsTest(len, 0);
        vector<int> res;
        for(int ele: nums)
            numsTest[ele-1]++;
        for(int ind=0; ind<len; ind++)
        {
            if(numsTest[ind]==2)
                res.insert(res.begin(), ind+1);
            if(!numsTest[ind])
                res.push_back(ind+1);
        }
        return res;
    }
};