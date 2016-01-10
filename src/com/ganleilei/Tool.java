package com.ganleilei;

public class Tool {
	public static void printArray(int[] nums) {
		System.out.print("[");
		for(int i = 0;i < nums.length - 1;i++){
			System.out.print(nums[i]+",");
		}
		System.out.print(nums[nums.length-1]);
		System.out.println("]");
	}
}
