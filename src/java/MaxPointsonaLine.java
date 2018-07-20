package java;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

/**
 * Created by haileyyin on 7/13/18.
 */
public class MaxPointsonaLine {
    /*
         [[0,0],[94911151,94911150],[94911152,94911151]]
         */
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<BigDecimal, Integer> hm = new HashMap<BigDecimal, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    BigDecimal k = getSlope(points[i], points[j]);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
    private BigDecimal getSlope(Point a, Point b){
        if(b.x == a.x){
            return BigDecimal.valueOf(Integer.MAX_VALUE);
        }
        return BigDecimal.valueOf(b.y -a.y).divide(BigDecimal.valueOf(b.x - a.x), new MathContext(20));
    }
    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
