package chapter4;

public class MinimalBST {
    /**
     * 对于一个元素各不相同且按升序排列的有序序列，
     * 请编写一个算法，创建一棵高度最小的二叉查找树。
     * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
     */
    public int buildMinimalBST(int[] vals) {
        // write code here
        return buildBST(vals,0,vals.length-1).height;
    }

    private TreeResult buildBST(int[] vals, int start, int end) {
        if (start > end || vals == null || vals.length == 0) return new TreeResult(0);
        int mid = (end + start) / 2;
        TreeResult left = buildBST(vals, start, mid - 1);
        TreeResult right = buildBST(vals, mid + 1, end);
        TreeNode root = new TreeNode(vals[mid]);
        root.left = left.root;
        root.right = right.root;
        return new TreeResult(root,Math.max(left.height,right.height)+1);
    }


    private class TreeResult {
        TreeNode root;
        int height;

        public TreeResult(TreeNode root, int height) {
            this.root = root;
            this.height = height;
        }

        public TreeResult(int height) {
            this.height = height;
            this.root = null;
        }
    }
}
