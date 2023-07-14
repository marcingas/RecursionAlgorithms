package binarytraversal;

import java.util.ArrayList;
import java.util.List;

class Node3 {
    int data;
    Node3 left;
    Node3 right;

    public Node3(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class NodePathInBinary {
    //we are given a binary tree T and  a node V.
    // We need to print path from root to a given node to a binary tree
    public static void main(String[] args) {
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);
        root.left.right.left = new Node3(6);
        root.left.right.right = new Node3(7);
        root.right = new Node3(3);

        ArrayList< Integer > list = new ArrayList < > ();

        boolean res;
        res = getPath(root, list, 7);

        System.out.print("The path is ");
        for (int it: list) {
            System.out.print(it + " ");
    }}
    public static boolean getPath(Node3 root, List<Integer> list, int x) {
        if (root == null) return false;
        list.add(root.data);

        if(root.data==x) return true;

        if(getPath(root.left,list,x) || getPath(root.right,list,x)){
            return true;
        }
        list.remove(list.size()-1);
        return  false;
    }
}
