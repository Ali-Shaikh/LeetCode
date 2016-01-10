/**
 * 
 */
package com.ganleilei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.ganleilei.ListNode;
import com.ganleilei.TreeNode;

/**
 * @author gump
 *
 */
public class Solution {
	
	//UniqueBinarySearchTrees
	public static int numTrees(int n)
	{
		   //当根结点是i是，左子树是一个0~i-1的BST,并且右子树为i~n的BST  
	    	int[] t = new int[n + 1];
	    	t[0] = 1 ;
	    	t[1] = 1;
	    	for (int i = 2; i < t.length; i++) {
				for (int j = 1; j <= i; j++) {
					t[i] += t[j-1] * t[i - j];
				}
	    		
			}
	    	
	    	return t[n];
	    	  
	      
	}
	//LinkedListCycle  
	public static boolean hasCycle(ListNode head)
	{
		boolean flag = false;
		ListNode first = head;
		ListNode second = head;
		
		
		
		
		return flag;
	}
	
	//BinaryTreeInorderTraversal
	public static List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		if (root == null) {
			return list;
		}
		else {
			while(p != null || !stack.isEmpty())
			{
				while (p != null) {
					stack.push(p);
					p = p.left;
				}
				if (!stack.isEmpty()) {
					p = stack.pop();
					list.add(new Integer(p.val));
					p = p.right;
				}
				
			}
			
			return list;
		}
		

	}
	
	
	//BinaryTreePreorderTraversal
	public static List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode t = root;
		if (root == null) 
			return list;
		else {
			while (t != null || !s.isEmpty()) {
				while(t != null)
				{
				list.add(new Integer(t.val));
				s.push(t);
				t = t.left;
				}
				if (!s.isEmpty()) {
					t = s.pop();
					t = t.right;
				}
				
			}
			
			return list;
		}	
	}
	
	//Search Insert Position
	public static int searchInsertPosition(int[] nums , int target)
	{
		
		int position = 0;
		if (nums.length <= 0) {
			return position;
		}
		else {
			int mid = (int)(nums.length/2.0);
			int first = 0,last = nums.length;
			while (first != last ) {
				mid = (int)((first + last)/2.0);
				if (target == nums[mid]) {
					return mid;
				}
				else if (target > nums[mid]) {
					first = mid + 1;
					mid  = (int)((first + last)/2.0);
				}
				else {
					last = mid - 1;
					mid = (int)((first + last)/2.0);
				}
				
			}
			
			if (target > mid) {
				position = mid + 1;
			}
			
			else {
				position = mid;
			}
		
			
			return position;
		}
	
	}
	
	//Populating Next Right Pointers in Each Node
//	public static void connect(TreeLinkNode root)
//	{
//		if (root == null) {
//			return;
//		}
//		else {
//			root.next = null;
//			Stack<TreeLinkNode> stack = new Stack<>();
//			TreeLinkNode p = root;
//			stack.push(p);
//			while (p != null || !stack.isEmpty()) {
//				while (p != null) {
//					stack.push(p.right);
//					p = p.left;
//					stack.push(p);
//				}
//				
//				
//				
//			}
//			
//			
//			
//			
//		}
//}
	
	//Populating Next Right Pointers in Each Node :Queue
	//如果当前层的所有结点的next指针已经设置好了，下一层的所有节点的next指针也可以依次被设置
	public static void connect (TreeLinkNode root)
	{
		if (root == null) {
			return;
		} 
		else {
			root.next = null;
			if (root.left == null) {
				return;
			}
			else {
				
				TreeLinkNode p = root , q = root;
				root.next = null;
				while (p.left != null) {
					p.left.next = p.right;
					
					if (p.next != null) {
						p.right.next = p.next.left;
						p = p.next;
						
					}
					else {
						p.left.next = p.right;
						p.right.next = null;
						p = q.left;
						q = p;
					}
											
				}
					
			}
		}
	}
	
	//83.Remove Duplicates from Sorted List
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		
		else {
			
			//because this is a sorted linked list
			ListNode p = head,q = head;
			while (p.next != null) {
				q = p.next;
				if (q.val == p.val) {
					if (q.next != null) {
						p.next = q.next;
					}
					else {
						p.next = null;
					}
				}
				else {
					if (q.next == null) {
						p.next = null;
					}
				}
				
			}
			
			return head;
			}
		}
	
	//Climbing Stairs 这题主要是菲波那切数列的计算
	public static int ClimbStairs(int n) {
		 int[] f = new int[n+1];
	     f[0] = 1;
	     f[1] = 1;
	     if(n <= 1)
	        {
	            return f[n];
	        }
	        else
	        {
	        for(int i = 2;i < n+1;i++)
	        {
	            f[i] = f[i-1] + f[i-2];
	        }
	        
	        return f[n];
	        }
	}
	
	//Maximum Subarray
	public static int maxSubArray(int[] nums) {
		int total = 0;
		
		
		
		
		return total;
	}
	
	//Roman to Integer
	/*
	 * I（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
	 * DCXXI = 621
	 * 
	 */
	public static int romanToInt(String s) 
	{
		int answer = 0;
		int[] num = {1,10,100,1000,5,50,500};
		char[] strings = {'I','X','C','M','V','L','D'};
		ArrayList<Character> strList = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
			
		for (int i = 0; i < strings.length; i++) {
			map.put(strings[i], num[i]);
			if (i<3) {
				strList.add(strings[i]);
			}
		}
		
		char[] array = s.toCharArray();
		
		for (int i = 0; i < array.length ; i++) {
			if (i < array.length - 1) {
				if (strList.contains(array[i]) && (map.get(array[i]) < map.get(array[i+1]))) {
					answer += (map.get(array[i+1]) - map.get(array[i])); 
					i++;
				}
				else {
					answer += map.get(array[i]);
				}
			}
			
			else {
				answer += map.get(array[i]);
			}
			
		}
		
		System.out.println(answer);
		return answer;
		
	}
	
	//Integer to Roman 
		/*
		 * I（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
		 * DCXXI = 621
		 * 
		 * I can only be placed before V and X
		 * X can only be placed before L and C
		 * C can only be placed before D and M
		 */
	public static String intToRoman(int num) 
	{
		String answer = new String();
		//process num
		String numString = String.valueOf(num);
		ArrayList<String> tempList = new ArrayList<>();
		
		
		for (int i = 0; i < numString.length(); i++) {
			int a = (numString.charAt(i) - '0') * (int)Math.pow(10, (numString.length() - i -1));
			switch (a) {
			case 1000:
			{
				for (int j = 0; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("M");
				}
			}		
				break;
			case 900:
			{
				tempList.add("C");
				tempList.add("M");
			}
			break;
			
			case 500:
			{
				tempList.add("D");
			}
			break;
			case 600:
			case 700:
			case 800:
			{
				tempList.add("D");
				for (int j = 5; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("C");
				}
			
			}
			break;
			case 400:
			{
				tempList.add("C");
				tempList.add("D");
			}
			break;
			
			case 300:
			case 200:
			case 100:
			{
				for (int j = 0; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("C");
				}
			}
			break;
			
			case 90:
			{
				tempList.add("X");
				tempList.add("C");
			}
			break;
			
			case 50:
			{
				tempList.add("L");
			}
			break;
			case 60:
			case 70:
			case 80:
			{
				tempList.add("L");
				for (int j = 5; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("X");
				}
			
			}
			break;
			case 40:
			{
				tempList.add("X");
				tempList.add("L");
			}
			break;
			
			case 30:
			case 20:
			case 10:
			{
				for (int j = 0; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("X");
				}
			}
			break;
			
			case 9:
			{
				tempList.add("I");
				tempList.add("X");
			}
			break;
			
			case 5:
			{
				tempList.add("V");
			}
			break;
			case 6:
			case 7:
			case 8:
			{
				tempList.add("V");
				for (int j = 5; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("I");
				}
			
			}
			break;
			case 4:
			{
				tempList.add("I");
				tempList.add("V");
			}
			break;
			
			case 3:
			case 2:
			case 1:
			{
				for (int j = 0; j < (numString.charAt(i) - '0'); j++) {
					tempList.add("I");
				}
			}
			break;
			
			default:
				break;
			}
			
		}
		
		answer = String.join("", tempList);
		return answer;
		
	}
	
	
	//Merge Two Sorted Lists
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2 ) 
	{
		if (l1 == null) {
			
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		else 
		{
			ListNode head = null;
			//p,q为两条list的遍历指针
			ListNode p1 = l1;
			ListNode p2 = l2;
			if (l1.val >= l2.val) {
				 head = l2;
				 p2 = p2.next;
			}
			else {
				 head = l1;
				 p1 = p1.next;
			}
			ListNode q = head;
			
			while(p1.next!=null && p2.next!=null)
			{
				if (p1.val >= p2.val) {
					q.next = p2;
					p2 = p2.next;
				}
				else {
					q.next = p1;
					p1 = p1.next;
				}
				
			}
			
			while(p1.next != null)
			{
				q.next = p1;
				p1 = p1.next;
			}
			
			while (p2.next != null) {
				q.next = p2;
				p2 = p2.next;
			}
			
			return head;
		}
		
	}
	
	//Ugly Number 
	/*
	 * ugly numbers are positive numbers whose prime factors only include 2,3,5
	 */
	public static boolean isUgly(int num) 
	{
		if (num == 1) {
			return true;
		}
		
		int n = num;
		
		for (int i = 2; i <= n/i; i++) {
			while (n %i == 0) {
				
				if (i !=3 && i != 5 && i != 2) {
					
					return false;
				}
				n /= i;
			}
		}
		
		if (n > 1) {
			if (n != 2 && n != 3 && n != 5 ) {
				return false;
			}
		}
		
		return true;
	}
	
	
	//Single Number||
	/*
	 * given an array of integer,every element appears three times except for one
	 * find that single one
	 */
	
	public static int singleNumber(int[] nums) 
	{
		if (nums.length <= 0) {
			return 0;
		}
		else {
			HashMap<Integer, Integer> map = new HashMap<>();
			int anstwer = 0;
			for (int i = 0; i < nums.length; i++) 
			{
				if (map.containsKey(nums[i])) {
					int temp = map.get(nums[i]);
					map.put(nums[i], ++temp);
				}
				else {
					map.put(nums[i], 1);
				}
				
			}
			
			System.out.println(map);
			for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
				if (entry.getValue() == 1) {
					anstwer = entry.getKey();
				}
			}
			
			return anstwer;
		}
	
	}
	
	
	/*
	 * Given an array and a value, 
	 * remove all instances of that value in place and return the new length.
	 *
     * The order of elements can be changed. 
     * It doesn't matter what you leave beyond the new length.
	 */
	
	public static int removeElement(int[] nums,int val) 
	{
		int lenth = nums.length;
		for (int i = 0; i < lenth; i++) {
			
			if (nums[i] == val) {
				if (i == lenth - 1) {
					return --lenth;
				}
				for (int j = i; j < lenth - 1; j++) {
					
					nums[j] = nums[j + 1];
				}
				lenth--;
				i--;	
			}
		}
		
		return lenth;
	}
	
	/*
	 * Given an array where elements are sorted in ascending order, 
	 * convert it to a height balanced BST
	 */
	//思路：是否采取递归的思想
	public static TreeNode	sortedArrayToBST(int[] nums) 
	{
		TreeNode head = null;
		if (nums.length <= 0) {
			return head;
		}
		int first = 0,last = nums.length - 1;
		if(first == last)
		{
			head = new TreeNode(nums[first]);
			return head;
		}
		int mid = (first + last)/2;
		int[] left = new int[mid];
		int[] right = new int[nums.length - mid -1];
		for (int i = 0; i < left.length; i++) {
			left[i] = nums[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = nums[mid + 1];
		}
		
		head = new TreeNode(nums[mid]);
		
		head.left = sortedArrayToBST(left);
		head.right = sortedArrayToBST(right);
		
		return head;
	}
	
	/*110. Balanced Binary Tree
	 *Given a binary tree, determine if it is height-balanced.
	 *For this problem, a height-balanced binary tree is defined as a binary tree 
	 *in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public static boolean isBalanced(TreeNode root) 
	{
		
		if (root == null ||(root.left == null && root.right == null)) {
			return true;
		}
		int lheight = 0,rheight = 0;
		
		//计算左子树的高度，采用队列的方法
		if (root.left != null) {
			
		}
		
		//计算右子树的高度，采用队列的方法
		if (root.right != null) {
			
		}
		
		if (Math.abs(lheight - rheight) > 1) {
			return false;
		}
		return isBalanced(root.left)&&isBalanced(root.right);
		
	}
	
	
	/*24. Swap nodes in pairs,done
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * For example,
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * You algorithm should use only constant space,you may not modify the values
	 * in the list, only nodes itself can be changed
	 * 2016.01.09 
	 */
	public static ListNode swapPairs(ListNode head) 
	{
		if (head == null) {
			return head;
		}
		
		ListNode p = head,q = p.next;
		
		while ( q != null && p!= null) {
		
			int temp = p.val;
			p.val = q.val;
			q.val = temp;
			if (q.next == null){
				break;
			}else{
				p = q.next;
				if (p.next == null){
					break;
				}else{
					q = p.next;
				}
			}
		}
			
		return head;
	}
	
	
	/*26. Remove Duplicates from Sorted Array 
	 * Given a sorted Array,remove the duplicates in place such that element appear only once 
	 * and return the new length 
	 * Do not allocate extra space or another array,you must do this in place with constant memory
	 * For example,
	 * Given input array nums = [1,1,2],
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
     * It doesn't matter what you leave beyond the new length.
	 * 2016.01.09,undo
	 * 保存两个flag，一个遍历flag，一个赋值flag
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		} else {
			int j=0;
			for(int i = 0;i<nums.length-1;i++){
				if(nums[i]==nums[i+1]){	
					continue;
				}
				else{
				   	nums[++j] = nums[i+1];
				}
			}
			return j+1;
		}
	}
	
	/*
	 * 51.N-Queens 
	 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard 
	 * such that no two queens attack each other,同一行、同一列、同一斜线上的皇后都会主动攻击
	 * Given an integer n,return all distinct solutions to the n-queens puzzle
	 * Each solution contains a distinct board configuration of the n-queens' placement
	 * where 'Q' and '.' both indicate a queen and ab empty space respectively
	 * For example,
	 * There exist two distinct solutions to the 4-queens puzzle:
	 * [
	 *  [".Q..",//solution 1
	 *   "...Q",
	 *   "Q...",
	 *   "..Q."],
	 *   
	 *   ["..Q.",//solution 2
	 *    "Q...",
	 *    "...Q",
	 *    ".Q.."]
	 * ] 
	 */
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		
		
		return result;
	}
	
	/*
	 * 88. Merge Sorted Array
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	 * Note:
	 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
	 * to hold additional elements from nums2. 
	 * The number of elements initialized in nums1 and nums2 are m and n respectively
	 */
	public static void merge(int[] nums1,int m, int[] nums2,int n) {
//		int t = m + n, i = 0, j = 0;// j是nums2的迭代flag，i是nums1的插入位置,m是nums1的当前长度
//		while (i < m  && j < n) {
//			if (i == 0) {
//				if (nums2[j] < nums1[i]) {
//					for (int k = m; k > i; k--) {
//						nums1[k] = nums1[k - 1];
//					}
//					m++;
//					nums1[i] = nums2[j];
//					j++;
//				}
//			}
//			if (j < n ) {
//				if (nums2[j] >= nums1[i] && nums2[j] < nums1[i + 1]) {
//					for (int k = m; k > i+1; k--) {
//						nums1[k] = nums1[k - 1];
//					}
//					m++;
//					nums1[i+1] = nums2[j];
//					j++;
//				} else {
//					i++;
//				}
//			}
//		}
//
//		while (j < n && m < t) {
//			nums1[m++] = nums2[j++];
//		}
		
		/*还可以从后往前填充数组*/
		int total = m + n - 1, lenth1 = m - 1, lenth2 = n - 1;
		while (lenth1 >= 0 && lenth2 >= 0) {
			if (nums1[lenth1] >= nums2[lenth2]) {
				nums1[total--] = nums1[lenth1--];
			} else {
				nums1[total--] = nums2[lenth2--];
			}
		}

		while(lenth1 == -1 && lenth2 >= 0) {
			nums1[lenth2] = nums2[lenth2--];
		}
		Tool.printArray(nums1);
	}
	
	
}










