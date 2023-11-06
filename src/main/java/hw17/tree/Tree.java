package hw17.tree;

import java.util.ArrayList;
import java.util.*;

public class Tree implements SearchTree<Node>{

    private Node root;
    private  Node foundElement;
    private final List<Node> sortedList = new ArrayList<>();

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null){
            root = newNode;
            sortedList.add(root);
        } else {
            Node currentNode = root;
            while (true) {
                if (currentNode.value == value) {
                    return;
                } else if (currentNode.value > value) { // go left
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        sortedList.add(currentNode.left);
                        return;
                    }
                    currentNode = currentNode.left;
                } else {                              // go right
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        sortedList.add(currentNode.right);
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private void findByVarRecursive(int number, Node element) {
        if (element != null) {
            if (element.value == number){
                foundElement = element;
                return;
            }
            findByVarRecursive(number, element.left);
            findByVarRecursive(number, element.right);
        }
    }

    public Node findByVal(int number) {
        foundElement = null;
        findByVarRecursive(number, root);
        return foundElement;
    }

    private void findRecursive(Node elementToFind, Node node) {
        if (node != null) {
            if (node.equals(elementToFind)){
                foundElement = node;
                return;
            }
            findRecursive(elementToFind, node.left);
            findRecursive(elementToFind, node.right);
        }
    }

    public Node find(Node element){
        foundElement = null;
        findRecursive(element, root);
        return foundElement;
    }

    public List<Node> getSortedList(){
        List<Integer> rawList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int middleInd = rawList.size() / 2;

        // создаем root элемент
        this.insertNode(rawList.get(middleInd));
//         добавляем все элементы
        for(Integer val : rawList) {
            this.insertNode(val);
        }
        return sortedList;
    }
}