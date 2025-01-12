class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 == 1)
            return false;
        int unlocked = 0, lockedOpen = 0;
        for(int ind=0; ind<s.length(); ind++) {
            if(locked.charAt(ind) == '0')
                unlocked++;
            else if(s.charAt(ind) == '(')
                lockedOpen++;
            else if(lockedOpen > 0)
                lockedOpen--;
            else if(unlocked > 0)
                unlocked--;
            else
                return false;
        }
        int balance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                lockedOpen--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance > 0) {
                return false;
            }
            if (unlocked == 0 && lockedOpen == 0) {
                break;
            }
        }
        return lockedOpen > 0 ? false : true;
    }
}