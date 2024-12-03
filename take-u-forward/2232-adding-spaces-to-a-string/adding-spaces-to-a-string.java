class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        // since we know how much mem required, we can pre allocate it for efficency
        sb.ensureCapacity(s.length() + spaces.length);
        int spaceInd = 0;
        for(int ind=0; ind<s.length(); ind++) {
            if(spaceInd < spaces.length && ind == spaces[spaceInd]) {
                sb.append(' ');
                spaceInd++;
            }
            sb.append(s.charAt(ind));
        }
        return sb.toString();
    }
}