class Solution {
    public boolean isPalindrome(String s) {
        var start = 0;
        var end = s.length() - 1;
        
        while (start < end) {
            if (isAlphaNumeric(s.charAt(start)) && isAlphaNumeric(s.charAt(end))) {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            } else {
                if (!isAlphaNumeric(s.charAt(start))) {
                    start++;
                }

                if (!isAlphaNumeric(s.charAt(end))) {
                    end--;
                }
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
