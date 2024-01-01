class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int contentChildren = 0;

        if(g.size() == 0 || s.size() == 0)
            return 0;

        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int sizeLen = s.size();
        int sizeInd = 0;
        for(int child: g)
        {
            while(s[sizeInd] < child)
            {
                sizeInd++;
                if(sizeInd >= sizeLen)
                    return contentChildren;
            }
            sizeInd++;
            contentChildren++;
            if(sizeInd >= sizeLen)
                return contentChildren;
        }
        return contentChildren;
    }
};