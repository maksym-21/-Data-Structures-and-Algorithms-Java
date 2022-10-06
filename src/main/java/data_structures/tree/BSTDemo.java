package data_structures.tree;

import data_structures.tree.bfs.BFS;
import data_structures.tree.dfs.DFS;
import data_structures.tree.dfs.SearchType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTDemo {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(12);
        bst.insert(20);
        bst.insert(5);
        bst.insert(6);

        System.out.println(bst);
        System.out.println(bst.lookup(20));

        bst.remove(12);

        System.out.println(bst);
        System.out.println(bst.lookup(-1));
        System.out.println(new BFS<>(bst).iterativeBFS());

        Queue<Node<Integer>> queue = new LinkedList<>();
        List<Integer> array = new ArrayList<>();
        queue.add(bst.getRoot());
        System.out.println(new BFS<>(bst).recursiveBFS(queue, array));

        DFS<Integer> dfs = new DFS<>(bst);
        System.out.println(dfs.dfs(SearchType.PRE_ORDER));
        System.out.println(dfs.dfs(SearchType.IN_ORDER));
        System.out.println(dfs.dfs(SearchType.POST_ORDER));
    }
}
