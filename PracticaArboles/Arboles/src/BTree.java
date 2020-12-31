public class BTree {

    /* ********************************************** *
     * CLASS BNode * **********************************************
     */

    static class BNode {

        private Object info;
        private BNode left;
        private BNode right;

        BNode(Object info) {
            this(info, null, null);
        }

        BNode(Object info, BNode l, BNode r) {
            this.info = info;
            left = l;
            right = r;
        }

        Object getInfo() {
            return info;
        }

        BNode getLeft() {
            return left;
        }

        BNode getRight() {
            return right;
        }

        void setInfo(Object info) {
            this.info = info;
        }

        void setLeft(BNode left) {
            this.left = left;
        }

        void setRight(BNode right) {
            this.right = right;
        }

        void insert(BNode tree, int side) throws BTreeException {
            if (side == LEFT_SIDE) {
                if (left == null) {
                    left = tree;
                } else {
                    throw new BTreeException("A non-empty tree already exists");
                }
            } else if (side == RIGHT_SIDE) {
                if (right == null) {
                    right = tree;
                } else {
                    throw new BTreeException("A non-empty tree already exists");
                }
            } else {
                throw new BTreeException("Incorrect side");
            }
        }

        BNode extract(int side) throws BTreeException {
            BNode subtree;
            if (side == LEFT_SIDE) {
                subtree = left;
                left = null;
            } else if (side == RIGHT_SIDE) {
                subtree = right;
                right = null;
            } else {
                throw new BTreeException("Incorrect side");
            }
            return subtree;
        }

        int size() {
            int size = 1;
            if (left != null) {
                size += left.size();
            }
            if (right != null) {
                size += right.size();
            }
            return size;
        }

        int height() {
            int hl = -1;
            int hr = -1;
            if (left != null) {
                hl = left.height();
            }
            if (right != null) {
                hr = right.height();
            }
            return 1 + Math.max(hl, hr);
        }

        void preorder() {
            System.out.println(info);
            if (left != null) {
                left.preorder();
            }
            if (right != null) {
                right.preorder();
            }
        }

        void inorder() {
            if (left != null) {
                left.inorder();
            }
            System.out.println(info);
            if (right != null) {
                right.inorder();
            }
        }

        void postorder() {
            if (left != null) {
                left.postorder();
            }
            if (right != null) {
                right.postorder();
            }
            System.out.println(info);
        }
    }

    /* ********************************************** */

    public static final int LEFT_SIDE = 0;
    public static final int RIGHT_SIDE = 1;

    protected BNode root;

    public BTree() {
        root = null;
    }

    public BTree(Object info) {
        root = new BNode(info);
    }

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }

    public void insert(BTree tree, int side) throws BTreeException {
        root.insert(tree.getRoot(), side);
    }

    public int size() {
        int size = 0;
        if (root != null) {
            size = root.size();
        }
        return size;
    }

    public int height() {
        int h = -1;
        if (root != null) {
            h = root.height();
        }
        return h;
    }

    public void preorder() {
        if (root != null) {
            root.preorder();
        }
    }

    public void inorder() {
        if (root != null) {
            root.inorder();
        }
    }

    public void postorder() {
        if (root != null) {
            root.postorder();
        }
    }

}