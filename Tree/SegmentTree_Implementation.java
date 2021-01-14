package Tree;

public class SegmentTree_Implementation {

    SegmentTree buildTree(int nums[], int start, int end){
        if(start > end) return null;

        SegmentTree st = new SegmentTree(start, end);
        if(start == end){
            st.sum = nums[start];
        }else{
            int mid = start + (end-start)/2;
            st.left = buildTree(nums, start, mid);
            st.right = buildTree(nums, mid+1, end);
            st.sum = st.left.sum + st.right.sum;
        }
        return st;
    }

    void update(SegmentTree root, int index, int value){
        if(root == null) return;
        if(root.left == root.right) {
            root.sum = value;
        }else{
            int mid = root.start + (root.end - root.start)/2;
            if(index <= mid){
                update(root.left, index, value);
            }else{
                update(root.right, index, value);
            }
            root.sum = root.left.sum + root.right.sum;
        }

    }

    int sumRange(SegmentTree root, int start, int end){
        if(root == null) return 0;
        if(root.start == start && root.end ==end ) return root.sum;
        int mid = root.start + (root.end - root.start)/2;

        if( end <= mid){
            return sumRange(root.left, start, end);
        }else if(start >= mid + 1){
            return sumRange(root.right, start, end);
        }else{
            return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
        }
    }
}

class SegmentTree{
    int start, end, sum;
    SegmentTree left, right;
    SegmentTree(int s, int e){
        this.start = s;
        this.end = e;
        sum = 0;
    }
}
