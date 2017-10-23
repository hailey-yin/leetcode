package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class ContainerWithMostWater {
    /*
    Initially we can assume the result is 0, then we scan from both sides with two pointers.
    If leftHeight < rightHeight, move the left pointer right and find a value that is greater than leftHeight.
    Similarly, if leftHeight > rightHeight, move the right pointer left and find a value that is greater than rightHeight.
    Additionally, keep tracking the max value.
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int n = height.length;
        int area = 0;
        int x1 = 0;
        int x2 = n-1;
        while(x1<x2){
            int areaTemp = Math.min(height[x1],height[x2])*(x2-x1);
            area = Math.max(area,areaTemp);
            if(height[x1]<height[x2]){
                x1++;
            } else {
                x2--;
            }
        }
        return area;
    }
}
