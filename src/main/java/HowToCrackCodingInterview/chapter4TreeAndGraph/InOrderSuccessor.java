package HowToCrackCodingInterview.chapter4TreeAndGraph;

class DualTree {
    int data;
    DualTree left;
    DualTree right;
    DualTree parent;
    
    boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public DualTree(int data, DualTree left, DualTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
        if(this.left != null)
        this.left.parent = this;
        if(this.right != null)
        this.right.parent = this;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DualTree getLeft() {
        return left;
    }

    public void setLeft(DualTree left) {
        this.left = left;

        if(this.left != null)
        this.left.parent = this;
    }

    public DualTree getRight() {
        return right;
    }

    public void setRight(DualTree right) {
        this.right = right;

        if(this.right != null)
        this.right.parent = this;
    }

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
    public static DualTree createLevel3Tree(){

        DualTree tree = new DualTree(1,
                new DualTree(11,
                        new DualTree(21,
                                new DualTree(31,
                                        null, null
                                ),
                                new DualTree(32,
                                        null, null
                                )
                        ),
                        new DualTree(22,
                                new DualTree(33,
                                        null, null
                                ),
                                new DualTree(34,
                                        null, null
                                )
                        )
                ),
                new DualTree(12,
                        new DualTree(23,
                                new DualTree(35,
                                        null, null
                                ),
                                new DualTree(36,
                                        null, null
                                )
                        ),
                        new DualTree(24,
                                new DualTree(37,
                                        null, null
                                ),
                                new DualTree(38,
                                        null, null
                                )
                        )
                )
        );
        return tree;
    }

}

class PreOrderSuccessor {
    
    public static DualTree returnNextNode(DualTree dualTree){
        if(dualTree.left != null){
            return dualTree.left;
        }
        if(dualTree.parent != null && dualTree.parent.left == dualTree){
            return dualTree.parent.right;
        }
        if(dualTree.right == null) {
            while (dualTree.parent != null && dualTree.parent.right == dualTree) {
                dualTree = dualTree.parent;
            }
            dualTree = dualTree.parent;
            if(dualTree == null){
                return null;
            }
        }
        if(dualTree.right != null){
            return dualTree.right;
        }
        return null;
    }

    public static void main (String[] args){
        DualTree dualTree = DualTree.createLevel3Tree();
        while(dualTree != null){
            System.out.print(dualTree.data + ", ");
            dualTree = returnNextNode(dualTree);
        }
    }
}

public class InOrderSuccessor {

    public static DualTree returnNextNode(DualTree dualTree){
        if(dualTree.right != null){
            dualTree = dualTree.right;
            while (dualTree.left != null){
                dualTree = dualTree.left;
            }
            return dualTree;
        }
        else if(dualTree.parent != null) {
            while (dualTree.parent != null && dualTree.parent.right == dualTree) {
                dualTree = dualTree.parent;
            }
            return dualTree.parent;
        }
        return null;
    }

    public static void main (String[] args){
        DualTree dualTree = DualTree.createLevel3Tree();
        while (dualTree.left != null){
            dualTree = dualTree.left;
        }
        while(dualTree != null){
            System.out.print(dualTree.data + ", ");
            dualTree = returnNextNode(dualTree);
        }
    }
}
