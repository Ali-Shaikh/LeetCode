/**
 * 
 */
package com.ganleilei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author gump
 *
 */
public class SingleNumber {
	static public int singleNumber(int[] nums)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int returvalue = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], 2);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if (entry.getValue() == 1) {
				 returvalue = entry.getKey();
			}
		}
		
		return returvalue;
	}
}
