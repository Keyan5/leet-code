class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b)->{
            return a[1] == b[1] ? Integer.compare(a[0], b[0]):Integer.compare(a[1], b[1]);
        });
        for(int i=0; i<nums.length; i++)
            minHeap.offer(new int[] {i, nums[i]});

        while(k-->0) {
            int[] smallest = minHeap.poll();
            int index = smallest[0];
            nums[index] *= multiplier;
            minHeap.offer(new int[]{index, nums[index]});
        }
        return nums;
    }
}