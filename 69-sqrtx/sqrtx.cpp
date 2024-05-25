class Solution {
public:
    int mySqrt(int x) {
        if(x < 2)
            return x;
        int left = 0, right = x/2;
        while(left <= right) {
            long mid = (left + right)/2;
            long mid_square = mid * mid;
            if(mid_square <= x)
                left = mid+1;
            if(mid_square > x)
                right = mid-1;
        }
        return right;
    }
};