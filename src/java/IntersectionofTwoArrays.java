package java;

import java.util.*;

/**
 * Created by haileyyin on 1/26/18.
 */
public class IntersectionofTwoArrays {
    /*
    hashset
    Time complexity: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums1[i]);
        }
        for(int i=0; i<m; i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }

        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++)
            res[i] = list.get(i);
        return res;
    }
    /*
    two pointers
    Time complexity: O(nlogn)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    /*
    binary search
    Time complexity: O(nlogn)
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
