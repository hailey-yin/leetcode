package java;

import java.util.*;

/**
 * Created by haileyyin on 6/27/18.
 */
public class GraphValidTree {
    /*
    is this graph is connected and acyclic
    union find
    time: O(n)
    space: O(n)
    */
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = quickFind(nums, edges[i][0]);
            int y = quickFind(nums, edges[i][1]);
            if (x != y) {
                nums[x] = y;
            } else {
                return false;  // find a cycle
            }
        }
        return edges.length == n-1;
    }

    private int quickFind(int[] nums, int i) {
        int root = nums[i];
        while (root != nums[root]) {
            root = nums[root];
        }
        while (i != nums[i]) {
            int temp = nums[i];
            nums[i] = root;
            i = temp;
        }
        return root;
    }
    /*
    DFS
     */
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i= 0 ; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adj, 0, visited, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int cur, boolean[] visited, int parent) {
        visited[cur] = true;
        List<Integer> list = adj.get(cur);
        for (int i:list) {
            if ((visited[i] && parent != i) || (!visited[i] && hasCycle(adj, i, visited, cur)))
                return true;
        }
        return false;
    }
    /*
    BFS
     */
    private boolean validTree2(int n, int[][] edges)
    {
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // no cycle
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node))
            {
                queue.offer(neighbor);
                graph.get(neighbor).remove((Integer)node);
            }
        }

        // fully connected
        for(boolean result : visited)
        {
            if(!result)
                return false;
        }

        return true;
    }
}
