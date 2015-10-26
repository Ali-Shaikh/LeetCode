/**
 * 
 */
package com.ganleilei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
	
	//Remove Duplicates from Sorted List
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
	public static boolean isUgly(int num) 
	{
		boolean result = false;
		
		
		
		
		return result;
	}
	
}













