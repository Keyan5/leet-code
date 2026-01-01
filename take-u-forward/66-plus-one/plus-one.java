class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int ind=digits.length-1; ind>=0; ind--) {
            int sum = digits[ind] + carry + (digits.length-1 == ind ? 1 : 0);
            digits[ind] =  sum % 10;
            carry = getCarry(sum);
        }
        if(carry != 0)
        {
            int res[] = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }

    private int getCarry(int sum)
    {
        return sum == 10 ? 1 : 0;
    }
}