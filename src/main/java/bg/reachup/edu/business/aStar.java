package bg.reachup.edu.business;
import org.hibernate.graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class aStar {
    /**
     * opisvane na metoda - izpolzvan go za da obqsnq kakvo pravq vatre
     * @param graph
     * @param start
     * @param goal
     * @return end
     */
}
    /*
    public static List<Node> aStarSearch(Graph graph, Node start, Node goal) {
        // The set of nodes already evaluated
        List<Node> closedSet = new ArrayList<Node>();

        // The set of currently discovered nodes still to be evaluated
        PriorityQueue<Node> openSet = new PriorityQueue<Node>();
        openSet.add(start);

        // For each node, the cost of getting from the start node to that node
        // This value is partially known, partially heuristic
        start.setGScore(0);
        start.setFScore(start.getHeuristicCost(goal));

        while (!openSet.isEmpty()) {
            // Get the node with the lowest fScore value
            Node current = openSet.poll();

            // Check if we've reached the goal node
            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            // Add the current node to the closed set
            closedSet.add(current);

            // Check all neighbors of the current node
            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getTo();

                // Ignore the neighbor if it's already in the closed set
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                // Calculate the tentative gScore value for this neighbor
                double tentativeGScore = current.getGScore() + edge.getCost();

                // Check if we've already evaluated this neighbor
                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tentativeGScore >= neighbor.getGScore()) {
                    // This is not a better path.
                    continue;
                }

                // This path is the best until now. Record it!
                neighbor.setCameFrom(current);
                neighbor.setGScore(tentativeGScore);
                neighbor.setFScore(tentativeGScore + neighbor.getHeuristicCost(goal));
            }
        }

        // No path was found
        return null;
    }

    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<Node>();
        path.add(current);
        while (current.getCameFrom() != null) {
            current = current.getCameFrom();
            path.add(current);
        }
        Collections.reverse(path);
        return path;
    }

}



public class Node implements Comparable<Node> {
    private int id;
    private double x;
    private double y;
    private List<Edge> edges;
    private Node cameFrom;
    private double gScore;
    private double fScore;

    public Node(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<Edge>();
    }

    // Implement the necessary getters and setters

    public double getHeuristicCost(Node goal) {
        // Calculate the Euclidean distance between this node and the goal node
        double dx = this.x - goal.getX();
        double dy = this.y - goal.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void setGScore(int i) {
        
    }

    public void setFScore(double heuristicCost) {
        
    }

    public double getGScore() {
        int i = 0;
        return i;
    }

    public Edge[] getEdges() {
    }

    public void setCameFrom(Node current) {
    }

    public Node getCameFrom() {
    }
}
     */


