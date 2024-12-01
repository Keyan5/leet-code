class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Boolean> existency = new HashMap<>();
        for(int ele: arr) {
            if(existency.containsKey(ele*2) || ((ele&1) == 0 && existency.containsKey(ele/2))) {
                return true;
            } else {
                existency.put(ele, true);
            }
        }
        return false;
    }
}