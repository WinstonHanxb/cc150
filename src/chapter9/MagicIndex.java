package chapter9;

public class MagicIndex {
    /**
     * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。
     * 给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。
     * 请思考一种复杂度优于o(n)的方法。
     * <p>
     * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
     */
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndex(A,0,n-1);
    }

    public boolean findMagicIndex(int[] A, int start, int end) {
        if(start > end) return false;
        int mid = start / 2 + end / 2;
        if(A[mid] == mid) return true;
        if(A[mid] > mid) return findMagicIndex(A,start,mid-1);
        return findMagicIndex(A,mid+1,end);
    }
}