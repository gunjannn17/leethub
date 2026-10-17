class Solution {
    int ans=0;
    public int findNumbers(int[] nums) {
    for(int i=0;i<nums.length;i++) {
        String str=String.valueOf(nums[i]);
        if((str.length())%2==0){
ans++;
        }
    }
    return ans;
    }
}