package java;

/**
 * Created by haileyyin on 7/6/18.
 */
public class IslandPerimeter {
    /*
    primitive way
    time: O(n^2)
    space: O(1)
    */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0 || grid[i-1][j] == 0) {
                    res++;
                }
                if (i == grid.length - 1 || grid[i+1][j] == 0) {
                    res++;
                }
                if (j == 0 || grid[i][j-1] == 0) {
                    res++;
                }
                if (j == grid[0].length - 1 || grid[i][j+1] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
    /*
    used a hashset to keep track of which island cells I have already visited. This uses O(N) space though.
     */
}
