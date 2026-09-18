import java.util.*;

class Solution {

    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int start, int end, int k) {

        if (end - start < k) {
            return 0;
        }

        int[] freq = new int[26];

        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {

            if (freq[s.charAt(i) - 'a'] < k) {

                int left = solve(s, start, i, k);
                int right = solve(s, i + 1, end, k);

                return Math.max(left, right);
            }
        }

        return end - start;
    }
}