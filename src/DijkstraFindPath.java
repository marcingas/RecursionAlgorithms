import sortingmethods.Pair1;

import java.util.*;

public class DijkstraFindPath {
    public static void main(String[] args) {
        List<Pair1> node0 = new ArrayList<>(List.of(new Pair1(1, 2), new Pair1(2, 3)));
        List<Pair1> node1 = new ArrayList<>(List.of(new Pair1(0, 2), new Pair1(2, 4),
                new Pair1(4, 3), new Pair1(5, 4)));
        List<Pair1> node2 = new ArrayList<>(List.of(new Pair1(0, 3), new Pair1(1, 4),
                new Pair1(3, 2), new Pair1(4, 2)));
        List<Pair1> node3 = new ArrayList<>(List.of(new Pair1(2, 2), new Pair1(6, 1)));
        List<Pair1> node4 = new ArrayList<>(List.of(new Pair1(2, 2), new Pair1(6, 1),
                new Pair1(5, 1), new Pair1(1, 3)));
        List<Pair1> node5 = new ArrayList<>(List.of(new Pair1(1, 4), new Pair1(6, 2),
                new Pair1(4, 1)));
        List<Pair1> node6 = new ArrayList<>(List.of(new Pair1(3, 1), new Pair1(4, 1),
                new Pair1(5, 2), new Pair1(2, 3)));

        List<List<Pair1>> adjecencyList = new ArrayList<>();
        adjecencyList.add(node0);
        adjecencyList.add(node1);
        adjecencyList.add(node2);
        adjecencyList.add(node3);
        adjecencyList.add(node4);
        adjecencyList.add(node5);
        adjecencyList.add(node6);
        int sourceNode = 6;
        int destinationNode = 0;
        List<Integer> routeList = new ArrayList<>();
        System.out.println("od " + sourceNode + " do " + destinationNode + " najkrótsza trasa ma: " +
                dijkstraImplementation(adjecencyList, sourceNode)[destinationNode]);
        int[] distances = dijkstraImplementation(adjecencyList, sourceNode);
        System.out.println("path: " + findShortestPath(adjecencyList, sourceNode, destinationNode, distances));

        System.out.println(Arrays.toString(dijkstraImplementation(adjecencyList, sourceNode)));

    }

    public static int[] dijkstraImplementation(List<List<Pair1>> adjList, int suorceNode) {
        int[] distanceAns = new int[7];
        Arrays.fill(distanceAns, Integer.MAX_VALUE);
        distanceAns[suorceNode] = 0;


        PriorityQueue<Pair1> minStorage = new PriorityQueue<>((x, y) -> x.getDistance() - y.getDistance());
        minStorage.add(new Pair1(suorceNode, 0));

        while (minStorage.size() != 0) {
            int node = minStorage.peek().getNode();
            int distance = minStorage.peek().getDistance();
            minStorage.poll();

            for (int i = 0; i < adjList.get(node).size(); i++) {
                int currentNode = adjList.get(node).get(i).getNode();
                int simpleDistance = adjList.get(node).get(i).getDistance();
                if (simpleDistance + distance < distanceAns[currentNode]) {
                    distanceAns[currentNode] = simpleDistance + distance;
                    minStorage.add(new Pair1(currentNode, distanceAns[currentNode]));


                }

            }
        }
        return distanceAns;
    }


    public static List<Integer> findShortestPath(List<List<Pair1>> adjList, int sourceNode,
                                                 int destinationNode, int[] distances) {
        List<Integer> path = new ArrayList<>();
        path.add(destinationNode);

        while (destinationNode != sourceNode) {
            for (Pair1 edge : adjList.get(destinationNode)) {
                int previousNode = edge.getNode();
                int distanceToPrevious = edge.getDistance();
                if (distances[destinationNode] == distances[previousNode] + distanceToPrevious) {
                    path.add(previousNode);
                    destinationNode = previousNode;
                    break;
                }
            }
        }

        Collections.reverse(path);
        return path;
    }
}
