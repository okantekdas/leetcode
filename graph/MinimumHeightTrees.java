package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* https://leetcode.com/problems/minimum-height-trees */
/* Runtime: 23 ms, faster than 31.10% */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> leaves = new LinkedList<>();

        if (n < 2) {
            for (int i = 0; i < n; i++) {
                leaves.add(i);
            }
            return leaves;
        }
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();

        // construct graph
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];

            Set<Integer> srcToDst = graph.get(src);
            if (srcToDst == null) {
                srcToDst = new HashSet<>();
            }
            srcToDst.add(dst);
            graph.put(src, srcToDst);
            Set<Integer> dstToSrc = graph.get(dst);

            if (dstToSrc == null) {
                dstToSrc = new HashSet<>();
            }
            dstToSrc.add(src);
            graph.put(dst, dstToSrc);

        }

        // Initialize the first layer of leaves
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {

            remainingNodes -= leaves.size();

            ArrayList<Integer> nextLeaves = new ArrayList<>();
            // remove the current leaves along with the edges
            for (int leaf : leaves) {
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        nextLeaves.add(neighbor);
                    }
                }

            }
            // prepare for the next round
            leaves = nextLeaves;

        }

        return leaves;
    }

    public static void main(String[] args) {
        // int n = 3;

        // int[][] edges = { { 0, 1 }, { 0, 2 } };

        int n = 2;

        int[][] edges = { { 0, 1 } };

        System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
    }

}
