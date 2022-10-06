package data_structures.tree.bfs;

import data_structures.tree.BinarySearchTree;
import data_structures.tree.Node;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
public class BFS<T> {
    /**
     * BFS is used for:
     * - finding the shortest path
     * - if we know that a solution is near root
     * - if tree is very deep and solutions are rare
     */
    private final BinarySearchTree<T> tree;

    public List<T> iterativeBFS() {
        Node<T> currentNode = tree.getRoot();
        List<T> output = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            output.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return output;
    }

    public List<T> recursiveBFS(Queue<Node<T>> queue, List<T> valuesList) {
        if (queue.size() == 0) {
            return valuesList;
        }
        Node<T> remove = queue.remove();
        valuesList.add(remove.getValue());
        if (remove.getLeft() != null) {
            queue.add(remove.getLeft());
        }
        if (remove.getRight() != null) {
            queue.add(remove.getRight());
        }
        return recursiveBFS(queue, valuesList);
    }
}
