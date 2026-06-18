class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int i = 0;     
        int j = s.length() - 1;
        boolean b = true;
        while (i < j) {
            int ch = s.charAt(i);
            int ch1 = s.charAt(j);
            if (ch != ch1) {
                b = false;
                break;  
            }

            i++;   
             j--;

        } 
           return b;
    }
    
}