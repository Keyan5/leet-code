class Solution {
public:
    int maxDepth(string s) {
        stack<char> paran;
        int maxi = 0;
        for(char c: s)
            if(c == '(') {
                paran.push(c);
                maxi = max(maxi, (int)paran.size());
            }
            else if(c == ')' && paran.top() == '(')
                paran.pop();
        return maxi;
    }
};