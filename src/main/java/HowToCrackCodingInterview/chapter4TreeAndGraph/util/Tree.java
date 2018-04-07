package HowToCrackCodingInterview.chapter4TreeAndGraph.util;

public class Tree {
    int data;
    Tree left;
    Tree right;
    boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Tree(int data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public static Tree createTree(){
        /*
                                                                        1
                                                                   *        *
                                                               *                *
                                                           *                        *
                                                       *                                *
                                                   *                                        *
                                               *                                                *
                                           *                                                        *
                                       11                                                               12
                                   *        *                                                       *        *
                               *                *                                               *                *
                           *                        *                                       *                        *
                       21                               22                              23                              24
                    *       *                       *       *                       *       *                       *       *
                31              32              33              34              35              36              37              38
            41      42      43      44      45      46      47      48      49      410     411     412     413     414     415     416




         */
        Tree tree = new Tree(1,
                new Tree(11,
                    new Tree(21,
                        new Tree(31,
                            new Tree(41, null, null),
                            new Tree(42, null, null)
                        ),
                        new Tree(32,
                            new Tree(43, null, null),
                            new Tree(44, null, null)
                        )
                    ),
                    new Tree(22,
                        new Tree(33,
                            new Tree(45, null, null),
                            new Tree(46, null, null)
                        ),
                        new Tree(34,
                            new Tree(47, null, null),
                            new Tree(48, null, null)
                        )
                    )
                ),
                new Tree(12,
                    new Tree(23,
                        new Tree(35,
                            new Tree(49, null, null),
                            new Tree(410, null, null)
                        ),
                        new Tree(36,
                            new Tree(411, null, null),
                            new Tree(412, null, null)
                        )
                    ),
                    new Tree(24,
                        new Tree(37,
                            new Tree(413, null, null),
                            new Tree(414, null, null)
                        ),
                        new Tree(38,
                            new Tree(415, null, null),
                            new Tree(416, null, null)
                        )
                    )
                )
        );
        return tree;
    }

    public static Tree createTreeNew(){
        /*
                                                                        1
                                                                   *        *
                                                               *                *
                                                           *                        *
                                                       *                                *
                                                   *                                        *
                                               *                                                *
                                           *                                                        *
                                       11                                                               12
                                   *        *                                                       *        *
                               *                *                                               *                *
                           *                        *                                       *                        *
                       21                               22                              23                              24
                    *       *                                                       *       *                       *       *
                31              32                                              35              36              37              38
            41      42      43      44                                      49      410     411     412     413     414     415     416




         */
        Tree tree = new Tree(1,
                new Tree(11,
                        new Tree(21,
                                new Tree(31,
                                        new Tree(41, null, null),
                                        new Tree(42, null, null)
                                ),
                                new Tree(32,
                                        new Tree(43, null, null),
                                        new Tree(44, null, null)
                                )
                        ),
                        new Tree(22,
                                null,
                                null
                        )
                ),
                new Tree(12,
                        new Tree(23,
                                new Tree(35,
                                        new Tree(49, null, null),
                                        new Tree(410, null, null)
                                ),
                                new Tree(36,
                                        new Tree(411, null, null),
                                        new Tree(412, null, null)
                                )
                        ),
                        new Tree(24,
                                new Tree(37,
                                        new Tree(413, null, null),
                                        new Tree(414, null, null)
                                ),
                                new Tree(38,
                                        new Tree(415, null, null),
                                        new Tree(416, null, null)
                                )
                        )
                )
        );
        return tree;
    }

    public static Tree createLevel3Tree(){
        /*
                                                                        1
                                                                   *        *
                                                               *                *
                                                           *                        *
                                                       *                                *
                                                   *                                        *
                                               *                                                *
                                           *                                                        *
                                       11                                                               12
                                   *        *                                                       *        *
                               *                *                                               *                *
                           *                        *                                       *                        *
                       21                               22                              23                              24
                    *       *                       *       *                       *       *                       *       *
                31              32              33              34              35              36              37              38




         */
        Tree tree = new Tree(1,
                new Tree(11,
                        new Tree(21,
                                new Tree(31,
                                        null, null
                                ),
                                new Tree(32,
                                        null, null
                                )
                        ),
                        new Tree(22,
                                new Tree(33,
                                        null, null
                                ),
                                new Tree(34,
                                        null, null
                                )
                        )
                ),
                new Tree(12,
                        new Tree(23,
                                new Tree(35,
                                        null, null
                                ),
                                new Tree(36,
                                        null, null
                                )
                        ),
                        new Tree(24,
                                new Tree(37,
                                        null, null
                                ),
                                new Tree(38,
                                        null, null
                                )
                        )
                )
        );
        return tree;
    }

    public static Tree createLevel1Tree(){
        /*
                                                                        1
                                                                   *        *
                                                               *                *
                                                           *                        *
                                                       *                                *
                                                   *                                        *
                                               *                                                *
                                           *                                                        *
                                       11                                                               12




         */
        Tree tree = new Tree(1,
                new Tree(11,
                        null, null
                ),
                new Tree(12,
                        null, null
                )
        );
        return tree;
    }
}
