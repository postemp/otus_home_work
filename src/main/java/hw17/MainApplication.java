package hw17;

import hw17.tree.Node;
import hw17.tree.Tree;

public class MainApplication {
    public static void main(String[] args) {
        Tree bt = new Tree();
        for (Node node : bt.getSortedList()) {
            System.out.println("node "+ node.getValue() + " left:" + node.getLeftNodeValue() + " right:"+ node.getRightNodeValue());
        }

        // ищем узел с определенным номером:
        Node nodeToFind = bt.findByVal(10);
        System.out.println("По номеру нашли узел : "+nodeToFind);
        // ищем узел по узлу
        System.out.println("Нашли узел по узлу :" + bt.find(nodeToFind));
    }
}
