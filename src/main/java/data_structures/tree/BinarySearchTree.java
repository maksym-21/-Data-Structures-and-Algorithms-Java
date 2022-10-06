package data_structures.tree;

import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@ToString
public class BinarySearchTree<T> {
    @Getter
    private Node<T> root;
    @ToString.Exclude
    private final Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T newValue) {
        if (root == null) {
            // if tree is empty, then we have new root
            root = new Node<>(newValue);
        } else {
            Node<T> tmpNode = root;
            while (true) {
                // if newValue is less than tmp node - we go left
                if (comparator.compare(newValue, tmpNode.getValue()) < 0) {
                    // if tmpNode's left child is null, we create him a child and stop
                    if (tmpNode.getLeft() == null) {
                        tmpNode.setLeft(new Node<>(newValue));
                        break;
                    }
                    tmpNode = tmpNode.getLeft();
                }
                // in other case(values r equal or newValue is bigger) - we go right
                else {
                    // same procedure as before
                    if (tmpNode.getRight() == null) {
                        tmpNode.setRight(new Node<>(newValue));
                        break;
                    }
                    tmpNode = tmpNode.getRight();
                }
            }
        }
    }

    public void remove(T value) {
        if (root == null) throw new RuntimeException("Tree is empty!");

        // start searching from root
        Node<T> nodeToBeRemoved = root;
        Node<T> parentNode = null;
        // find value to be removed
        while (!nodeToBeRemoved.getValue().equals(value)) {
            parentNode = nodeToBeRemoved;
            if (comparator.compare(value, nodeToBeRemoved.getValue()) < 0) {
                nodeToBeRemoved = nodeToBeRemoved.getLeft();
            } else if (comparator.compare(value, nodeToBeRemoved.getValue()) > 0) {
                nodeToBeRemoved = nodeToBeRemoved.getRight();
            }
            if (nodeToBeRemoved == null) {
                throw new RuntimeException("No element was found with value " + value + "!");
            }
        }

        Node<T> replacement = null;
        // if we have a right child
        if (nodeToBeRemoved.getRight() != null) {
            replacement = nodeToBeRemoved.getRight();
            if (replacement.getLeft() == null) {
                replacement.setLeft(nodeToBeRemoved.getLeft());
            } else {
                // finding a left most node
                Node<T> parentReplacement = nodeToBeRemoved;
                while (replacement.getLeft() != null) {
                    parentReplacement = replacement;
                    replacement = replacement.getLeft();
                }
                parentReplacement.setLeft(null);
                replacement.setLeft(nodeToBeRemoved.getLeft());
                replacement.setRight(nodeToBeRemoved.getRight());
            }
        }
        // we only have a left node
        else if (nodeToBeRemoved.getLeft() != null) {
            replacement = nodeToBeRemoved.getLeft();
        }

        // we are a root
        if (parentNode == null) {
            root = replacement;
        }
        // we are a left child
        else if (parentNode.getLeft() == nodeToBeRemoved) {
            parentNode.setLeft(replacement);
        }
        // we are a right child
        else {
            parentNode.setRight(replacement);
        }
    }

    public boolean lookup(T value) {
        // if tree's empty - no sense to find smth
        if (root == null) throw new RuntimeException("Tree is empty!");
        Node<T> tmpNode = root;
        while (true) {
            // if we have no more elements to see - false
            if (tmpNode == null) return false;
            // if we found it - ok
            if (tmpNode.getValue().equals(value)) return true;
            else {
                // comparing value of search node with tmp node
                // bigger - go right, other case - left
                if (comparator.compare(value, tmpNode.getValue()) < 0) {
                    tmpNode = tmpNode.getLeft();
                } else {
                    tmpNode = tmpNode.getRight();
                }
            }
        }
    }
}
