class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer,Integer> map=new HashMap<>();
        int n=nums.length/2;
        for(int arr:nums){
            map.put(arr,map.getOrDefault(arr,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

            if(entry.getValue()>n){
                return entry.getKey();
            }
        }
        return 0;
    }
}