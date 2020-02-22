package extra;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */


public class MergeSortedArray {

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};

        merge(nums1,3,nums2,3);
        System.out.println(String.valueOf(2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        int i = m-1, j = n-1;
        while ( i >=0 && j >= 0){
            if(nums2[j] > nums1[i]){
                nums1[lastIndex--] = nums2[j--];
            }else{
                nums1[lastIndex--] = nums1[i--];
            }
        }
        while(j>=0){
            nums1[lastIndex--] = nums2[j--];
        }

    }

}

//Time Complexity O(m+n)