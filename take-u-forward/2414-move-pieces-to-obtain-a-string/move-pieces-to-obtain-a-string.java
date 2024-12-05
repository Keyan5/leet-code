class Solution {
    public boolean canChange(String start, String target) {
        int len = start.length();
        int startInd = 0, targetInd = 0; 
        while(startInd < len || targetInd < len) {
            while(startInd < len && start.charAt(startInd) == '_') startInd++;
            while(targetInd < len && target.charAt(targetInd) == '_') targetInd++;
            if(startInd == len || targetInd == len)
                return startInd == len && targetInd == len;
            if(
                start.charAt(startInd) != target.charAt(targetInd) ||
                (start.charAt(startInd) == 'L' && targetInd > startInd) ||
                (start.charAt(startInd) == 'R' && targetInd < startInd)
            )
                return false;
            startInd++;
            targetInd++;
        }
        return true;
    }
}