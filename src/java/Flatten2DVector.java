package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 3/29/18.
 */
public class Flatten2DVector {
    List<List<Integer>> vec2d = new LinkedList<>();
    int i;
    int j;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i=0;
        j=0;
    }

    public Integer next() {
        return vec2d.get(i).get(j++);
    }

    public boolean hasNext() {
        while(i<vec2d.size()){
            if(j<vec2d.get(i).size()){
                return true;
            } else {
                j=0;
                i++;
            }
        }
        return false;
    }

    /*
    iterator

        public class Vector2D implements Iterator<Integer> {

        Iterator<List<Integer>> input_vec2d = null;
        Iterator<Integer> current = null;
        public Vector2D(List<List<Integer>> vec2d) {
            input_vec2d = vec2d.iterator();
            if(input_vec2d.hasNext()) current = input_vec2d.next().iterator();
        }

        @Override
        public Integer next() {
            return current==null? null:current.next();
        }

        @Override
        public boolean hasNext() {
            if(current==null) return false;
            while(!current.hasNext()) {
                if(!input_vec2d.hasNext()) return false;
                current = input_vec2d.next().iterator();
            }
            return true;
        }
    }
     */

}
