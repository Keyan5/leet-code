class Solution {
    public void sortColors(int[] nums) {
        int zeroPos = 0, onePos = 0, twoPos = nums.length - 1;
        while(onePos <= twoPos) {
            if(nums[onePos] == 2)
                swap(nums, onePos, twoPos--);
            else if(nums[onePos] == 0) {
                swap(nums, onePos, zeroPos++);
                onePos++;
            }
            else 
                onePos++;
        }
    }

    private void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}