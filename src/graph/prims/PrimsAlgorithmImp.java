package graph.prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

record Pair(int distance, int node) {
}

record Edge(int rootNode, int neighbourNode, int distance) {
}

public class PrimsAlgorithmImp {
    public static void main(String[] args) {
        //TC O(numOfEdges * log numOfEdges) + O(numOfEdges * log numOfEdges) = O(numOfEdges * log numOfEdges);
        int numOfNodes = 5;
        List<List<Pair>> adjacencyList = new ArrayList<>();
        List<Pair> node0 = new ArrayList<>();
        List<Pair> node1 = new ArrayList<>();
        List<Pair> node2 = new ArrayList<>();
        List<Pair> node3 = new ArrayList<>();
        List<Pair> node4 = new ArrayList<>();
        node0.add(new Pair(2, 1));
        node0.add(new Pair(1, 2));

        node1.add(new Pair(2, 0));
        node1.add(new Pair(1, 2));

        node2.add(new Pair(1, 1));
        node2.add(new Pair(1, 0));
        node2.add(new Pair(2, 4));
        node2.add(new Pair(2, 3));

        node3.add(new Pair(2, 2));
        node3.add(new Pair(1, 4));

        node4.add(new Pair(1, 3));
        node4.add(new Pair(2, 2));

        adjacencyList.add(node0);
        adjacencyList.add(node1);
        adjacencyList.add(node2);
        adjacencyList.add(node3);
        adjacencyList.add(node4);

        System.out.println(primsAlgorithmMethod(adjacencyList, numOfNodes));

    }

    private static int primsAlgorithmMethod(List<List<Pair>> adjacencyList, int numOfNodes) {
        PriorityQueue<Pair> minDistanceQueue = new PriorityQueue<>((pair1, pair2) -> pair1.distance() - pair2.distance());
        int[] visited = new int[numOfNodes];
        minDistanceQueue.add(new Pair(0, 0));
        int minSum = 0;
        while (minDistanceQueue.size() > 0) {
            int dist = minDistanceQueue.peek().distance();
            int node = minDistanceQueue.peek().node();
            minDistanceQueue.remove();

            if (visited[node] == 1) continue;

            visited[node] = 1;
            minSum += dist;

            for (int neighbour = 0; neighbour < adjacencyList.get(node).size(); neighbour++) {
                int neighbourNodeDistance = adjacencyList.get(node).get(neighbour).distance();
                int neighbourNode = adjacencyList.get(node).get(neighbour).node();
                if (visited[neighbourNode] == 0) minDistanceQueue.add(new Pair(neighbourNodeDistance, neighbourNode));
            }
        }
        return minSum;
    }
}
