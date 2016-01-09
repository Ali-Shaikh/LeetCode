package com.ganleilei;
import com.ganleilei.TwoNumber;
import com.ganleilei.SingleNumber;
import com.ganleilei.ReverseInteger;
import com.ganleilei.Solution;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,6};
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		Solution.swapPairs(head);
	}

}
