class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int ind=0; ind<temperatures.length; ind++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[ind]) {
                int topInd = stack.pop();
                answer[topInd] = ind - topInd;
            }
            stack.push(ind);
        }
        return answer;
    }
}