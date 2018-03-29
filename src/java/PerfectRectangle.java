package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 3/26/18.
 */
public class PerfectRectangle {
    /*
    The right answer must satisfy two conditions:
    1. the large rectangle area should be equal to the sum of small rectangles
    2. count of all the points should be even, and that of all the four corner points should be one

    Time: O(n)
    Space: O(n)
    */
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles.length==0||rectangles[0].length==0)
            return false;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        HashSet<String> hs = new HashSet<>();
        for(int[] rect:rectangles){
            x1 = Math.min(rect[0],x1);
            y1 = Math.min(rect[1],y1);
            x2 = Math.max(rect[2],x2);
            y2 = Math.max(rect[3],y2);
            area += (rect[2]-rect[0])*(rect[3]-rect[1]);
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            if(!hs.add(s1))
                hs.remove(s1);
            if(!hs.add(s2))
                hs.remove(s2);
            if(!hs.add(s3))
                hs.remove(s3);
            if(!hs.add(s4))
                hs.remove(s4);
        }
        if(hs.size()!=4||!hs.contains(x1+" "+y1)||!hs.contains(x1+" "+y2)||!hs.contains(x2+" "+y1)||!hs.contains(x2+" "+y2))
            return false;
        return (x2-x1)*(y2-y1)==area;
    }
}
