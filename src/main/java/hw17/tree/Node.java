package hw17.tree;

public class Node {
    int value;
    Node left;
    Node right;

    public int getValue(){
        return this.value;
    }

    public String getLeftNodeValue(){
        if (this.left == null) {
            return "null";
        }
        return this.left.toString();
    }

    public String getRightNodeValue(){
        if (this.right == null) {
            return "null";
        }
        return this.right.toString();
    }
    Node(){
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                " left child=" + left +
                " right child=" + right +
                "}";
    }
}
