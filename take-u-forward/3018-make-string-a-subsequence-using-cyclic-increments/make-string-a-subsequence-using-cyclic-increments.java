class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str2Ind = 0, str2Len = str2.length();
        for(char currChar: str1.toCharArray()) {
            if(str2Ind < str2Len && (str2.charAt(str2Ind)-currChar+26)%26 <= 1)
                str2Ind++;
        }
        return str2Ind == str2Len;
    }
}