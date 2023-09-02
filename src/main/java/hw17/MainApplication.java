package hw17;

import hw17.tree.Node;
import hw17.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApplication {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setValue(1);
        Node node2 = new Node();
        node2.setValue(2);
        node1.setRightChild(node2);
        System.out.println(node1.getRightChild());

        Tree tree = new Tree();
        // вставляем узлы в дерево:
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(5);
//        tree.insertNode(8);
        tree.insertNode(2);
//        tree.insertNode(9);
//        tree.insertNode(7);
        tree.insertNode(4);
//        tree.insertNode(10);
        tree.insertNode(3);
        tree.insertNode(1);
        // отображение дерева:
        tree.printTree();
    }


}
