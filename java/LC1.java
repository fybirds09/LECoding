// 2016-2-12

package com.chris.leetcode;

import java.util.*;

public class LC1 {
	public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])){
				ret[0] = map.get(target - nums[i]);
				ret[1] = i+1;
				return ret;
			} else {
				map.put(nums[i], i+1);
			}
		}
        return ret;
    }
	
	public static void main(String[] args) {
		LC1 lc1 = new LC1();
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] ret = lc1.twoSum(nums, target);
		System.out.println(Arrays.toString(ret));
	}
}
