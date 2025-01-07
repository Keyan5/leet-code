class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length; j++) {
                if(i != j && words[i].indexOf(words[j]) != -1)
                    result.add(words[j]);
            }
        }
        return new ArrayList<String>(result);
    }
}