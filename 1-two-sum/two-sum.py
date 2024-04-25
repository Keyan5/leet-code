class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i,j in enumerate(nums):
           num = nums[:]
           num[i]=147655
           if (target - j) in num:
                return [i,num.index(target-j)]