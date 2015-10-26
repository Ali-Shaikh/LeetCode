/**
 * 
 */
package com.ganleilei;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author gump
 *
 */
public class TwoNumber {
	public static int[] twoSum(int[] number,int target)
	{
		int[] twoSum = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < number.length;i++)
		{
			map.put(target - number[i], i);
		}
		
		for (int i = 0; i < number.length; i++) {
			Integer v = map.get(number[i]);
			if (v!= null && v!= i) {
				if (i > v) {
				twoSum[0] = v + 1;
				twoSum[1] = i + 1;
				}
				else {
					twoSum[0] = i + 1;
					twoSum[1] = v + 1;
				}
				
			}
		}
		
		return twoSum;
	}
}
