package java;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by haileyyin on 7/1/18.
 */
public class KthSmallestElementinaSortedMatrix {
    /*
    binary search
    time: O(nlogn)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0], right = matrix[matrix.length-1][matrix[0].length-1] + 1, mid;
        while(left <= right){
            mid = left + (right-left)/2;
            int count=0, j=matrix[0].length-1;
            for(int i=0; i<matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += j+1;
            }
            if(count < k)left = mid+1;
            else right = mid;
        }
        return left;
    }
    /*
        maintain a priority-queue.
        we keep expanding and generating elements.
        the k-th poped out element is the result.

        Solution:
        1.	Input[0][0]
        2.	Expand node[i][j]: generate node[i+1][j] and node[i][j+1]
        3.	Terminal condition: when the k-th element is popped out for expansion, then we return it.

        Time: O(klogk)
        Space: O(k + N*N)
        */
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Tuple> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        pq.add(new Tuple(0, 0, matrix[0][0]));
        visited[0][0] = true;
        while (k > 1) {
            Tuple cur = pq.poll();
            if (cur.x < m - 1 && !visited[cur.x + 1][cur.y]) {
                pq.add(new Tuple(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if (cur.y < n - 1 && !visited[cur.x][cur.y + 1]) {
                pq.add(new Tuple(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
            k--;
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
}
