class Solution {
public:
    int climbStairs(int n) {
        int first = 1, second = 1, third;
        while(n-->1)
        {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
};