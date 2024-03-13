class Solution {
public:
    int sum_of_n(int n) {
        return ( n * (n+1) )/2;
    }
    int pivotInteger(int n) {
        int total = sum_of_n(n);
        for(int i=1; i<=n; i++) {
            int sum_till_x = sum_of_n(i);
            if(sum_till_x == total - sum_till_x + i)
                return i;
        }
        return -1;
    }
};