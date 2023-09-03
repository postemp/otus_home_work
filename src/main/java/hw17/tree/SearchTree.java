package hw17.tree;

import java.util.List;

public interface SearchTree<Node>{
    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    Node find(Node element);

    List<Node> getSortedList();
}
