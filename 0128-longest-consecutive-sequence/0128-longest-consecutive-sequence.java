class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0){
            return 0;
        }

        Arrays.sort(nums);

        int maxCount=1;
        int count=1;
        int i=0,j=1;

        while(j<nums.length){
            if((nums[i]+1)==nums[j]){
                count++;
                
            } else if(nums[i]==nums[j]){
                
            }else {
                count=1;
            }
            i++;
            j++;
            maxCount=Math.max(maxCount,count);
            
        }   return maxCount; 
        
    }
    
}
