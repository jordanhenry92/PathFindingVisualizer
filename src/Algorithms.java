import java.util.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithms {

    public ArrayList<Node> get_neighbours(Node node, Grid grid) {

        ArrayList<Node> neighbours = new ArrayList<>();

        int R = grid.getRl();
        int C = grid.getCl();

        int[] dr = new int[]{-1, +1, 0, 0};
        int[] dc = new int[]{0, 0, +1, -1};

        for (int i=0; i<4; i++) {
            int rr = node.getR() + dr[i];
            int cc = node.getC() + dc[i];

            if (rr < 0 || cc < 0) continue;
            if (rr >= R || cc >= C) continue;

            if (grid.getNodes()[rr][cc].getVal() == "V") continue;
            if (grid.getNodes()[rr][cc].getVal() == "X") continue;

            Node neighbour = grid.getNodes()[rr][cc];
            neighbours.add(neighbour);
        }

        return neighbours;

    }

    public List<Node> find_path_bfs(Grid grid) {

        Queue<Node> queue = new LinkedList<>();
        List<Node> path = new ArrayList<>();

        Node start = grid.getStartNode();
        Node end = grid.getEndNode();

        queue.add(start);
        grid.mark_visited(start.getR(), start.getC());

        Map<Node, Node> parentMap = new HashMap<>();

        Node node = start;
        parentMap.put(start, null); // start node has no parent, so we end path reconstruction here
        while (!queue.isEmpty()) {
            node = queue.remove();

            if (node == end) break;

            ArrayList<Node> adj_nodes = get_neighbours(node, grid);
            for (Node n : adj_nodes) {
                if (!(n.getVal() == "V")) {
                    queue.add(n);
                    parentMap.put(n, node); // mark current node as parent to neighbor
                    n.setVal("V");
                }
            }
        }

        Node curr = node;
        while (curr != null) {
            path.add(0, curr);
            curr = parentMap.get(curr);
        }

        // Trace out path on grid
        for (Node n : path) {
            grid.mark_path(n.getR(), n.getC());
        }

        // Re-mark start and end
        grid.mark_start(start.getR(), start.getC());
        grid.mark_end(end.getR(), end.getC());

        return path;
    }
}

