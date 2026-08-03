class Solution {
    public void sortColors(int[] nums) {
        int Count0=0;
        int Count1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                Count0+=1;
            }if(nums[i]==1){
                Count1+=1;
            }
        }
        for(int i=0;i<Count0;i++){
            nums[i]=0;
        }
         for(int i=Count0;i<Count1+Count0;i++){
            nums[i]=1;
        }
        for(int i=Count1+Count0;i<nums.length;i++){
            nums[i]=2;
        }

    }

}