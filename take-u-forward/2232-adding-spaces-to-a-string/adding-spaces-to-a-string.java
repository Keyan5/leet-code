class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spaceInd = 0, spacesLen = spaces.length;
        int sLen = s.length();
        for(int ind=0; ind<sLen; ind++) {
            if(spaceInd < spacesLen && ind == spaces[spaceInd]) {
                sb.append(' ');
                spaceInd++;
            }
            sb.append(s.charAt(ind));
        }
        return sb.toString();
    }
}