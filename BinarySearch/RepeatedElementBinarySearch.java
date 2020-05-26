package BinarySearch;

// Find the start and end index of an element, which is repeated in a sorted array.
//Progress => //6
public class RepeatedElementBinarySearch {

    public static void main(String[] args) {
        int arr [] = {5,7,7,8,8,10};
        int first = binaryFirstSearch(arr, 8, 0, arr.length-1);
        int last = binaryLastSearch(arr, 8, 0, arr.length-1);

        System.out.println(first + " " + last);

    }

    private static int binaryFirstSearch(int [] arr, int target, int low, int high){
        int index = -1;
        if(high >= low){
            int mid = low + (high - low) / 2;
            if((mid == 0 || target > arr[mid - 1]) && target == arr[mid]){
                return mid;
            }else {
                if(target > arr[mid])
                    return binaryFirstSearch(arr, target, mid + 1, high);
                else
                    return binaryFirstSearch(arr, target, low, mid - 1);
            }
        }
        return index;
    }

    private static int binaryLastSearch(int [] arr, int target, int low, int high){
        int index = -1;
        if(high >= low){
            int mid = low + (high - low) / 2;
            if((mid == arr.length - 1 || target < arr[mid + 1]) && target == arr[mid]){
                return mid;
            }else {
                if(target >= arr[mid])
                    return binaryLastSearch(arr, target, mid + 1, high);
                else
                    return binaryLastSearch(arr, target, low, mid - 1);
            }
        }
        return index;
    }

}
