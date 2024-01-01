class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int len = -1;
        int charWithInd[26] = {0};
        for(int i=0; s[i]!='\0'; i++)
        {
            int mapInd = s[i]-'a';
            int existingCharInd = charWithInd[mapInd];
            if(existingCharInd)
                len = max(len, i-existingCharInd);
            else
                charWithInd[mapInd] = i+1;
        }
        return len;
    }
};