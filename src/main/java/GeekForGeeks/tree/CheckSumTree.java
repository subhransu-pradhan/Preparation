package GeekForGeeks.tree;

/*
Check if a given Binary Tree is SumTree
Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.
          26
        /   \
      10     3
    /   \     \
  4      6     3
 */
class Node
{
    int data;
    Node left, right, nextRight;

    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
    }
}
public class CheckSumTree {

    static int a = 0;
    public static int sum(Node node) {
        a++;
        if(node == null){
            return 0;
        }
        int leftSum = (node.left==null ? 0 : node.left.data);
        if(node.left!= null && (!(node.left.left == null) || !(node.left.right == null)))
            leftSum = 2 * leftSum;
        int rightSum = (node.right==null ? 0 : node.right.data);
        if(node.left!= null && (!(node.left.left == null) || !(node.left.right == null)))
            rightSum = 2 * rightSum;
        return leftSum + rightSum;
    }

    public static boolean checkSumTree(Node node){

        if(node == null)
            return true;
        if(node.left == null && node.right == null){
            return true;
        }
        if(sum(node) == node.data)
            return checkSumTree(node.left) && checkSumTree(node.right);
        else
            return false;
    }

    public static void main (String args[]) {

        Node node = new Node(26);
        node.left = new Node(10);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right = new Node(3);
        node.right.right = new Node(3);

        System.out.print(checkSumTree(node));
        System.out.println(a);
    }
}
