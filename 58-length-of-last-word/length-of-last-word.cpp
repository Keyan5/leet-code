class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = s.size();
        int res_size = 0;
        stringstream res;
        for(int i=len-1;i>=0;i--)
        {
            if(s[i]==' ')
            {
                res_size = res.str().size();
                if(res_size != 0)
                    return res_size;
                continue;
            }
            res << s[i];
        }
        return res.str().size();
    }
};