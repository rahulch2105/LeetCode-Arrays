class Solution {
    public int[] rearrangeArray(int[] nums) {
        int arr[]=new int[nums.length];
        int i=0;
        int p=0,n=1;
        while(i<nums.length){
            if(nums[i]>=0){
                arr[p]=nums[i];
                p+=2;
                i++;
            }
            
            else{ 
                arr[n]=nums[i];
                n+=2;
                i++; 
            }
            
            
        }
       
       return arr;
    }
}