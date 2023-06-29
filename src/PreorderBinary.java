import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class PreorderBinary {
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left= new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.left.right.left = new Node1(8);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);
        root.right.right.left = new Node1(9);
        root.right.right.right = new Node1(10);

        List<Integer>preOrderList = new ArrayList<>();
        preOrderList = preOrderTraversal(root);

        for(var el: preOrderList){
            System.out.print(el + " ");
        }
    }
    public static List<Integer> preOrderTraversal(Node1 currentNode1) {
        List<Integer> preOrder = new ArrayList<>();
        if (currentNode1 == null) return preOrder;
        Stack<Node1>stack = new Stack<>();
        stack.push(currentNode1);

        while(!stack.isEmpty()){
            Node1 topNode1 = stack.peek();
            preOrder.add(topNode1.data);
            stack.pop();
            if(topNode1.right != null) stack.push(topNode1.right);
            if(topNode1.left != null) stack.push(topNode1.left);
        }
        return preOrder;
    }

}
