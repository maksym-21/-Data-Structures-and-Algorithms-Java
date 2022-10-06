package data_structures.tree.dfs;

import data_structures.tree.BinarySearchTree;
import data_structures.tree.Node;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DFS<T> {
    /**
     * DFS is used for :
     * - determining whether a path exists between 2 nodes
     * - if solutions are rare, but located in the tree
     * - if the tree is rare
     * */
    private final BinarySearchTree<T> tree;

    public List<T> dfs(SearchType type) {
        ArrayList<T> objects = new ArrayList<>();
        if (type == SearchType.IN_ORDER) return dfsInOrder(tree.getRoot(), objects);
        if (type == SearchType.POST_ORDER) return dfsPostOrder(tree.getRoot(), objects);
        if (type == SearchType.PRE_ORDER) return dfsPreOrder(tree.getRoot(), objects);
        throw new UnsupportedOperationException("Unsupported search type");
    }

    private List<T> dfsInOrder(Node<T> node, List<T> list) {
        if (node.getLeft() != null) {
            dfsInOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            dfsInOrder(node.getRight(), list);
        }
        return list;
    }

    private List<T> dfsPostOrder(Node<T> node, List<T> list) {
        if (node.getLeft() != null) {
            dfsPostOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            dfsPostOrder(node.getRight(), list);
        }
        list.add(node.getValue());
        return list;
    }

    private List<T> dfsPreOrder(Node<T> node, List<T> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) {
            dfsPreOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            dfsPreOrder(node.getRight(), list);
        }
        return list;
    }
}
