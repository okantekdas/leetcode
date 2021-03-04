package leetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* https://leetcode.com/problems/is-graph-bipartite/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 39.6 MB, less than 50.88% */
public class BipartiteGraph {

    static final BipartiteGraph bg = new BipartiteGraph();

    class Node {
        int number;
        boolean value;

        public Node(int number, boolean value) {
            this.number = number;
            this.value = value;
        }

    }

    /* Runtime: 4 ms, faster than 16.37% Memory Usage: 39 MB, less than 96.22% */
    public static boolean isBipartiteAlternate(int[][] graph) {

        Queue<Integer> queue = null;
        Set<Integer> black = new HashSet<>();
        Set<Integer> white = new HashSet<>();

        for (int curNode = 0; curNode < graph.length; curNode++) {

            if (!black.contains(curNode) && !white.contains(curNode)) {
                queue = new LinkedList<>();
                black.add(curNode);
                queue.add(curNode);

                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        int node = queue.poll();

                        for (int j = 0; j < graph[node].length; j++) {
                            int nextNode = graph[node][j];
                            if (black.contains(node)) {
                                if (black.contains(nextNode)) {
                                    return false;
                                } else {
                                    if (white.contains(nextNode)) {
                                        continue;
                                    } else {
                                        white.add(nextNode);
                                    }
                                }
                            } else {
                                if (white.contains(nextNode)) {
                                    return false;
                                } else {
                                    if (black.contains(nextNode)) {
                                        continue;
                                    } else {
                                        black.add(nextNode);
                                    }
                                }
                            }
                            queue.add(nextNode);
                        }

                    }
                }
            }

        }

        return true;
    }

    /* Runtime: 0 ms, faster than 100.00% Memory Usage: 39.6 MB, less than 50.88% */
    public static boolean isBipartite(int[][] graph) {

        Node[] visitedNodes = new Node[graph.length];

        for (int i = 0; i < visitedNodes.length; i++) {
            if (visitedNodes[i] == null) {
                boolean solution = isBipartite(i, graph, visitedNodes, false);
                if (!solution) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartite(int i, int[][] graph, Node[] visitedNodes, boolean prevValue) {

        if (i >= graph.length) {
            return true;
        }
        if (graph[i].length == 0) {
            return true;
        }

        if (visitedNodes[i] != null) {
            if (visitedNodes[i].value == prevValue) {
                return false;
            }

        } else {
            Node visitedNode = bg.new Node(i, !prevValue);
            visitedNodes[i] = visitedNode;
            for (int j = 0; j < graph[i].length; j++) {
                boolean result = isBipartite(graph[i][j], graph, visitedNodes, !prevValue);
                if (!result) {
                    return result;
                }

            }
        }
        return true;

    }

    public static void main(String[] args) {

        int[][] graph1 = new int[4][];

        graph1[0] = new int[2];
        graph1[0][0] = 1;
        graph1[0][1] = 3;

        graph1[1] = new int[2];
        graph1[1][0] = 0;
        graph1[1][1] = 2;

        graph1[2] = new int[2];
        graph1[2][0] = 1;
        graph1[2][1] = 3;

        graph1[3] = new int[2];
        graph1[3][0] = 0;
        graph1[3][1] = 2;

        // graph1[0] = new int[1];
        // graph1[0][0] = 1;

        // graph1[1] = new int[2];
        // graph1[1][0] = 0;
        // graph1[1][1] = 3;

        // graph1[2] = new int[1];
        // graph1[2][0] = 3;

        // graph1[3] = new int[2];
        // graph1[3][0] = 1;
        // graph1[3][1] = 2;

        // graph1[0] = new int[3];
        // graph1[0][0] = 1;
        // graph1[0][1] = 2;
        // graph1[0][2] = 3;

        // graph1[1] = new int[2];
        // graph1[1][0] = 0;
        // graph1[1][1] = 2;

        // graph1[2] = new int[3];
        // graph1[2][0] = 0;
        // graph1[2][0] = 1;
        // graph1[2][0] = 3;

        // graph1[3] = new int[2];
        // graph1[3][0] = 0;
        // graph1[3][1] = 2;

        // [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]

        // graph1[0] = new int[0];

        // graph1[1] = new int[3];
        // graph1[1][0] = 2;
        // graph1[1][1] = 4;
        // graph1[1][2] = 6;

        // graph1[2] = new int[4];
        // graph1[2][0] = 1;
        // graph1[2][1] = 4;
        // graph1[2][2] = 8;
        // graph1[2][3] = 9;

        // graph1[3] = new int[2];
        // graph1[3][0] = 7;
        // graph1[3][1] = 8;

        // graph1[4] = new int[4];
        // graph1[4][0] = 1;
        // graph1[4][1] = 2;
        // graph1[4][2] = 8;
        // graph1[4][3] = 9;

        // graph1[5] = new int[2];
        // graph1[5][0] = 6;
        // graph1[5][1] = 9;

        // graph1[6] = new int[5];
        // graph1[6][0] = 1;
        // graph1[6][1] = 5;
        // graph1[6][2] = 7;
        // graph1[6][3] = 8;
        // graph1[6][4] = 9;

        // graph1[7] = new int[3];
        // graph1[7][0] = 3;
        // graph1[7][1] = 6;
        // graph1[7][2] = 9;

        // graph1[8] = new int[5];
        // graph1[8][0] = 2;
        // graph1[8][1] = 3;
        // graph1[8][2] = 4;
        // graph1[8][3] = 6;
        // graph1[8][4] = 9;

        // graph1[9] = new int[6];
        // graph1[9][0] = 2;
        // graph1[9][1] = 4;
        // graph1[9][2] = 5;
        // graph1[9][3] = 6;
        // graph1[9][4] = 7;
        // graph1[9][5] = 8;

        System.out.println(Arrays.deepToString(graph1));

        System.out.println(isBipartiteAlternate(graph1));

    }
}