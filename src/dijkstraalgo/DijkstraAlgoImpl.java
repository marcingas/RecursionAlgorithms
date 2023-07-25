package dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


record Pair(int node, int distance) {
}

public class DijkstraAlgoImpl {
    public static void main(String[] args) {
        //Given weighted, undirected and connected graph of V vertices and E edges,
        // Find the shortest distance ol all the vertex's from the source vertex: source;
        //V- 5, E- 8;
        int nodesNum = 6;
        int edgesNum = 8;
        int sourceNode = 0;
        List<Pair> node0 = new ArrayList<>(List.of(new Pair(1, 4), new Pair(2, 4)));
        List<Pair> node1 = new ArrayList<>(List.of(new Pair(0, 4), new Pair(2, 2)));
        List<Pair> node2 = new ArrayList<>(List.of(new Pair(0, 4), new Pair(1, 2),
                new Pair(3, 3), new Pair(4, 1), new Pair(5, 6)));
        List<Pair> node3 = new ArrayList<>(List.of(new Pair(2, 3), new Pair(5, 2)));
        List<Pair> node4 = new ArrayList<>(List.of(new Pair(2, 1), new Pair(5, 3)));
        List<Pair> node5 = new ArrayList<>(List.of(new Pair(3, 2), new Pair(2, 6),
                new Pair(4, 3)));

        List<List<Pair>> adjecencyList = new ArrayList<>();
        adjecencyList.add(node0);
        adjecencyList.add(node1);
        adjecencyList.add(node2);
        adjecencyList.add(node3);
        adjecencyList.add(node4);
        adjecencyList.add(node5);

        System.out.println(Arrays.toString(dijkstraFindShortestWay(nodesNum, sourceNode, adjecencyList)));
    }

    private static int[] dijkstraFindShortestWay(int nodesNum, int sourceNode, List<List<Pair>> adjecencyList) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance() - y.distance());
        int[] shortestDistanceAns = new int[nodesNum];
        for (int i = 0; i < shortestDistanceAns.length; i++) {
            shortestDistanceAns[i] = Integer.MAX_VALUE;
        }

        shortestDistanceAns[sourceNode] = 0;
        pq.add(new Pair(sourceNode, 0));

        while (pq.size() != 0) {

            int distance = pq.peek().distance();
            int node = pq.peek().node();
            pq.remove();

            for (int i = 0; i < adjecencyList.get(node).size(); i++) {
                int simpleEdgeDist = adjecencyList.get(node).get(i).distance();
                int adjNode = adjecencyList.get(node).get(i).node();

                if (distance + simpleEdgeDist < shortestDistanceAns[adjNode]) {
                    shortestDistanceAns[adjNode] = distance + simpleEdgeDist;
                    pq.add(new Pair(adjNode, shortestDistanceAns[adjNode]));
                }
            }
        }
        return shortestDistanceAns;
    }
}
