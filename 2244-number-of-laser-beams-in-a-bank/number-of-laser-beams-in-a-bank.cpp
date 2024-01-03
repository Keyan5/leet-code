class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        map<int,int> indWithCount; // security device per row
        int m = bank.size();
        for(int ind=0; ind<m; ind++)  // o(m*n)
            for(auto cell: bank[ind])
                if(cell == '1')
                    indWithCount[ind]++;
        int beams = 0, prevKey = 0;
        for(auto [key, value]: indWithCount) // o(m)
        {
            if(key != prevKey)
                beams += value * indWithCount[prevKey];
            prevKey = key;
        }
        return beams;
    }
};