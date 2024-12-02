class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s");
        int prefixHash = searchWord.hashCode();
        for(int i=0; i<words.length; i++) {
            if(words[i].length() < searchWord.length())
                continue;
            String wordPrefix = words[i].substring(0, searchWord.length());
            if(wordPrefix.hashCode() == prefixHash)
                return i+1;
        }
        return -1;
    }
}