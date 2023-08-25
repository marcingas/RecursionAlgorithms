package binarytraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversalWays {
    //all ways of traversal Binary Tree: inOrder, preOrder, postOrder, levelOrder
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> list = new LinkedList<>();
        //      inOrder(root,list);
        //     preOrder(root,list);
//       postOrder(root,list);
        System.out.println(levelOrder(root));
        for (var el : list) {
            System.out.println(el);
        }
    }

    private static void inOrder(Node current, List<Integer> list) {
        if (current == null) return;

        inOrder(current.left, list);
        list.add(current.data);
        inOrder(current.right, list);
    }

    private static void preOrder(Node current, List<Integer> list) {
        if (current == null) return;

        list.add(current.data);
        preOrder(current.left, list);
        preOrder(current.right, list);
    }

    private static void postOrder(Node current, List<Integer> list) {
        if (current == null) return;
        postOrder(current.left, list);
        postOrder(current.right, list);
        list.add(current.data);
    }

    private static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            Integer initialSize = queue.size();
            for (int i = 0; i < initialSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);

                subList.add(currentNode.data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
