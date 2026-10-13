class Solution {
    public void nextPermutation(int[] nums) {
     int pivot=-1, n=nums.length;
     for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            pivot=i;
            break;
        }
     } 
     if(pivot!=-1){
        for(int j=n-1;j>pivot;j--){
            if(nums[j]>nums[pivot]){
                int temp=nums[j];
                nums[j]=nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }
     }
     int left=pivot+1,right=n-1;
     while(left<right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
     }
    }

}