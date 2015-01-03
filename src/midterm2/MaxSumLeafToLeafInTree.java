/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm2;

/**
 *
 * @author Muzhi
 */
public class MaxSumLeafToLeafInTree {
    /******* This two methods still have some problems with the results, still need to be check ***********/
    private int maxGlobalSum;
    
        public static class Tree {
            Tree left, right, root;
            int value;
            public Tree(Tree left, Tree right, int value, Tree root) {
                this.value = value;
                this.left = left;
                this.right = right;
                this.root = root;
            }
        }
        
        /****** This is correct method? *********/
        public int maxSum2(Tree root) {
            assert root != null;
            //static int maxGlobalSum;
            maxSum2Helper(root);
            return this.maxGlobalSum;
            
        }
        
        private int maxSum2Helper(Tree cur) {
            if (cur == null) {
                return 0;
            }
            
            int left = maxSum2Helper(cur.left);
            int right = maxSum2Helper(cur.right);
            if (this.maxGlobalSum < left + right + cur.value) {
                this.maxGlobalSum = left + right + cur.value;
            }
            return (left > right) ? left + cur.value : right + cur.value;
            
        }
        
        
        /****** This method has some problem. Still need to fix it. *******/
	public int maxSum(Tree root) {
		assert root != null;
		int sum = 0;
		int[] globalSum = new int[2];
		int nodeSum = 0;
		maxSumHelper(root, nodeSum, globalSum);
		return globalSum[0];
	}

	private int maxSumHelper(Tree tree, int nodeSum, int[] globalSum) {
		
		if (tree.left == null && tree.right == null) {
			nodeSum = nodeSum + tree.value;
			return nodeSum;
		}
		
 		int sum1, sum2;
		sum1 = maxSumHelper(tree.left, nodeSum, globalSum);
		sum2 = maxSumHelper(tree.right, nodeSum, globalSum);
		int leafSum = sum1 + sum2;
		if (globalSum[0] < leafSum) {
			globalSum[0] = leafSum;
		}
		nodeSum = max(sum1, sum2) + tree.value;
		return nodeSum;

	}
	
	private int max(int sum1, int sum2) {
		return (sum1 > sum2) ? sum1 : sum2;
	}
        
        public static void main(String[] args) {
                Tree tree15 = new Tree(null, null, 15, null);
                Tree tree14 = new Tree(null, null, 14, null);
                Tree tree13 = new Tree(null, null, 13, null);
                Tree tree12 = new Tree(null, null, 12, null);
                Tree tree11 = new Tree(null, null, 11, null);
                Tree tree10 = new Tree(null, null, 10, null);
                Tree tree9 = new Tree(null, null, 9, null);
                Tree tree8 = new Tree(null, null, 8, null);
                Tree tree7 = new Tree(tree14, tree15, 7, null);
                Tree tree6 = new Tree(tree12, tree13, 6, null);
                Tree tree5 = new Tree(tree10, tree11, 5, null);
                Tree tree4 = new Tree(tree8, tree9, 4, null);
                Tree tree3 = new Tree(tree6, tree7, 3, null);
                Tree tree2 = new Tree(tree4, tree5, 2, null);
                Tree tree1 = new Tree(tree2, tree3, 1, null);
                
                MaxSumLeafToLeafInTree maxLeafSum = new MaxSumLeafToLeafInTree();
                System.out.println(maxLeafSum.maxSum(tree1));
                System.out.println(maxLeafSum.maxSum2(tree1));

        }
}

    

