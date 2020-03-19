package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FlowerPlantingWithNoAdjacent
 */
public class FlowerPlantingWithNoAdjacent {

    static final Set<Integer> colors = new HashSet<>(Arrays.asList(1, 2, 3, 4));

    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, List<Integer>> nodeToNodes = new HashMap<>(N);

        for (int[] path : paths) {
            List<Integer> nodes1 = nodeToNodes.get(path[0] - 1);
            if (nodes1 == null) {
                nodes1 = new ArrayList<>();
            }
            nodes1.add(path[1] - 1);
            nodeToNodes.put(path[0] - 1, nodes1);

            List<Integer> nodes2 = nodeToNodes.get(path[1] - 1);
            if (nodes2 == null) {
                nodes2 = new ArrayList<>();
            }
            nodes2.add(path[0] - 1);
            nodeToNodes.put(path[1] - 1, nodes2);

        }

        int[] assignedColors = new int[N];

        for (int currentNode = 0; currentNode < N; currentNode++) {

            List<Integer> colorsNotInUse = new ArrayList<>(colors);

            if (nodeToNodes.get(currentNode) != null) {
                for (int neighborNode : nodeToNodes.get(currentNode)) {
                    colorsNotInUse.remove(new Integer(assignedColors[neighborNode]));
                }
            }

            assignedColors[currentNode] = colorsNotInUse.get(0);

        }

        return assignedColors;

    }

    public static void main(String[] args) {
        int[][] sample = new int[6][2];
        sample[0][0] = 4;
        sample[0][1] = 1;

        sample[1][0] = 4;
        sample[1][1] = 2;

        sample[2][0] = 4;
        sample[2][1] = 3;

        sample[3][0] = 2;
        sample[3][1] = 5;

        sample[4][0] = 1;
        sample[4][1] = 2;

        sample[5][0] = 1;
        sample[5][1] = 5;

        System.out.println("Result: " + Arrays.toString(new FlowerPlantingWithNoAdjacent().gardenNoAdj(5, sample)));
    }
}