class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str2Ind = 0;
        for(char c: str1.toCharArray()) {
            if(c == str2.charAt(str2Ind) || getNextChar(c) == str2.charAt(str2Ind))
                str2Ind++;
            if(str2Ind == str2.length())
                return true;
        }
        return false;
    }

    public char getNextChar(char c) {
        return (char) ('a'+(c-'a'+1)%26);    // cyclic shift by 1
    }
}