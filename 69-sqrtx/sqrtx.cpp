class Solution {
public:
    int mySqrt(int x) {
        if(x < 2) return x;
        int left = 0, right = x/2;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if((long)mid*mid <= x)
                left = mid+1;
            else
                right = mid-1;
        }
        return right;
    }
};