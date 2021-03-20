package leetcode.graph;

import java.util.List;

/* https://leetcode.com/problems/keys-and-rooms/ */
public class KeysAndRooms {

    int totalVisited = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        canVisitAllRoomsHelper(rooms, visited, 0);
        return totalVisited == visited.length ? true : false;
    }

    void canVisitAllRoomsHelper(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room]) {
            return;
        }
        visited[room] = true;
        totalVisited++;
        for (int key : rooms.get(room)) {
            canVisitAllRoomsHelper(rooms, visited, key);
        }
    }
}
