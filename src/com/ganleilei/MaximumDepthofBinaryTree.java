/**
 * 
 */
package com.ganleilei;

/**
 * @author gump
 *
 */

import com.ganleilei.TreeNode;


public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root != null) {
			int a = maxDepth(root.left);
			int b = maxDepth(root.right);
			
			return (a > b)? (a + 1): (b + 1);
		}
			
	return 0;
    }
}
