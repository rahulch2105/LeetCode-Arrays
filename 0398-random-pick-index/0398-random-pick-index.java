import java.util.*;

class Solution {

    int[] nums;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                indexes.add(i);
            }
        }

        return indexes.get(random.nextInt(indexes.size()));
    }
}