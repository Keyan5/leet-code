class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> giftsHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer gift: gifts)
            giftsHeap.add(gift);
        while(k-->0) {
            Integer top = giftsHeap.poll();
            giftsHeap.add((int)Math.floor(Math.sqrt(top)));
        }
        long remainingGifts = 0l;
        while(!giftsHeap.isEmpty())
            remainingGifts += giftsHeap.poll();
        return remainingGifts;
    }
}