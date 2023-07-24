package dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

record Pair(int distance, int node) {
}

public class DijkstraAlgoImpl {
    public static void main(String[] args) {
        //Given weighted, undirected and connected graph of V vertices and E edges,
        // Find the shortest distance ol all the vertex's from the source vertex: source;
        //V- 5, E- 8;
        int nodesNum = 6;
        int edgesNum = 8;
        int sourceNode = 0;

        List<List<Integer>> node0 = new ArrayList<>(List.of(List.of(1, 4), List.of(2, 4)));
        List<List<Integer>> node1 = new ArrayList<>(List.of(List.of(0, 4), List.of(2, 2)));
        List<List<Integer>> node2 = new ArrayList<>(List.of(List.of(0, 4), List.of(1, 2),
                List.of(3, 3), List.of(4, 1), List.of(5, 6)));
        List<List<Integer>> node3 = new ArrayList<>(List.of(List.of(2, 3), List.of(5, 2)));
        List<List<Integer>> node4 = new ArrayList<>(List.of(List.of(2, 1), List.of(5, 3)));
        List<List<Integer>> node5 = new ArrayList<>(List.of(List.of(3, 2), List.of(2, 6), List.of(4, 3)));

        List<List<List<Integer>>> adjecencyList = new ArrayList<>();
        adjecencyList.add(node0);
        adjecencyList.add(node1);
        adjecencyList.add(node2);
        adjecencyList.add(node3);
        adjecencyList.add(node4);
        adjecencyList.add(node5);

        System.out.println(Arrays.toString(dijkstraFindShortestWay(nodesNum, sourceNode, adjecencyList)));
    }

    private static int[] dijkstraFindShortestWay(int nodesNum, int sourceNode, List<List<List<Integer>>> adjecencyList) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance() - y.distance());
        int[] dist = new int[nodesNum];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        System.out.println(Arrays.toString(dist));
        dist[sourceNode] = 0;
        pq.add(new Pair(0, sourceNode));

        while (pq.size() != 0) {
            int distance = pq.peek().distance();
            int node = pq.peek().node();
            pq.remove();

            for (int i = 0; i < adjecencyList.get(node).size(); i++) {
                int edgeWeight = adjecencyList.get(node).get(i).get(1);
                int adjNode = adjecencyList.get(node).get(i).get(0);

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
