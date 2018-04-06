package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 4/2/18.
 */
public class IntersectionofTwoArraysII {
    /*
        hashtable
        time:O(m+n)
        space:O(m)
        */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<nums1.length; i++){
            int count = hm.getOrDefault(nums1[i], 0);
            hm.put(nums1[i], count+1);
        }
        for(int i=0; i<nums2.length; i++){
            if(hm.containsKey(nums2[i])&&hm.get(nums2[i])>0){
                hm.put(nums2[i], hm.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    /*
    two pointers
    Time: O(mlogm+nlogn)
    Space: O(1)
    */
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while(i<nums1.length&&j<nums2.length) {
            if(nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]<nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int k=0; k<list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
    /*
    binary search
    Time: O(mlogm+nlogn+nlogm)
    Space: O(n)
    */
    public int[] intersect3(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0; i<nums2.length; i++){
            int lo=0, hi=nums1.length-1;
            while(lo<=hi&&lo>=0&&hi<=nums1.length-1){
                int mid = lo+(hi-lo)/2;
                if(nums1[mid]==nums2[i]){
                    while(mid>0&&nums1[mid-1]==nums1[mid]){
                        mid--;
                    }
                    list.add(nums1[mid]);
                    nums1[mid]--;
                    break;
                } else if(nums1[mid]<nums2[i]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }

        int[] res = new int[list.size()];
        for(int k=0; k<list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
