class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer>gunjan=new HashSet<>();
        for(int i=0;i<arr.length;i++){
if(arr[i]%2==0 && gunjan.contains(arr[i]/2))return true;
else if(gunjan.contains(2*arr[i]))return true;
else{
    gunjan.add(arr[i]);
}
        }
      return false;  
    }
}