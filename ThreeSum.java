import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {

        int arr[] = {1,1,1,0};
        int target = -100;

       int i =  threeSumClosest1(arr,target);

        System.out.println(i);
    }


    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min_space = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length - 2; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left]+nums[right];
                if(sum < target) left++;
                else{
                    right--;
                }
                if(Math.abs(target - sum) < min_space){
                    min_space = Math.abs(target - sum);
                    res = sum;
                }
            }
        }
        return res;
    }
}
