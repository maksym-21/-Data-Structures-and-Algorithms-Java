package data_structures.tree.dfs;

public enum SearchType{
    IN_ORDER, //  leftSubTree-> root-> rightSubTree
    POST_ORDER, // leftSubTree -> rightSubTree -> root
    PRE_ORDER // root-> leftSubTree-> rightSubTree
}
