class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int,int> freq;
        for(int num: nums)  
            freq[num]++;
        int opCount = 0;
        for(auto [key, value]: freq)
        {
            if(value==1)
                return -1;
            // speaking of positive numbers, except 1 we can construct any number using 2, 3
            else if((value-2)%3 == 0)
                opCount += (value-2)/3 + 1;
            else if((value-4)%3 == 0)
                opCount += (value-4)/3 + 2;
            else
                opCount += value/3;
        }
        return opCount;
    }
};