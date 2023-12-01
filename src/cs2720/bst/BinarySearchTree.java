package cs2720.bst;

public class BinarySearchTree <T extends Comparable <T>> {
    public NodeType<T> root;

    public BinarySearchTree() {
        root = null;
    }//constructor

    public void insert(T key) {
        root = insertHelper(this.root, key);
    }

    public NodeType<T> insertHelper(NodeType<T> n, T key) {
        if(n == null) {
            NodeType<T> node = new NodeType<T>();
            node.info = key;
            n = node;
            return n;
        }// insertion spot / if tree is empty
        else if (key.compareTo(n.info) == 0) {
            return n;
        }
        else if (key.compareTo(n.info) < 0) {
           n.left = insertHelper(n.left, key);
        }//if key is less, go left
        else {// go right otherwise
           n.right = insertHelper(n.right, key);
        }
        return n;
    }

    public void delete (T key) {
        if(retrieve(key)) {
            root = deleteHelper(this.root, key);
        }
        else
            System.out.println("this item is not in the tree");;
    }

    public NodeType<T> deleteHelper(NodeType<T> n, T key) {
        if (isEmpty()) {
            return n;
        }
        if(key.compareTo(n.info) < 0) {
             n.left = deleteHelper(n.left, key);
        }//if less than parent go left
        else if (key.compareTo(n.info) > 0) {
            n.right = deleteHelper(n.right, key);
        } // if greater than parent go right
        else {
            if(n.right == null && n.left == null) {//leaf node
                n = null;
                return n;
            }
            else if(n.left == null && n.right != null) {//one child l
                n = n.right;
                return n;
            }
            else if (n.right == null && n.left != null) {//one child r
                n = n.left;
                return n;
            }
            else if (n.right != null && n.left != null){ //two children
                NodeType<T> temp = new NodeType<T>();
                temp = findPred(n.left);
                n = temp;
                temp = deleteHelper(temp, temp.info);
            }
        }
        return n;
    }

    public NodeType<T> findPred(NodeType<T> n) { //helper method to find logical predecessor
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    public boolean retrieve(T item) {
        return retrieveHelper(root, item);
    }

    public boolean retrieveHelper(NodeType<T> n, T item) {
         if(n == null) {
            return false;
        }
        else if(item.compareTo(n.info) == 0) {
            return true;
        }
        else if(item.compareTo(n.info) < 0) {
            return retrieveHelper(n.left, item);
        }
        else if( item.compareTo(n.info) > 0) {
            return retrieveHelper(n.right, item);
        }
        else return false;
    }

    public void inOrder() {
        inOrderTraversal(root);
    }
    public void inOrderTraversal(NodeType<T> n) {
        if(n != null) {
            inOrderTraversal(n.left);
            System.out.print(n.info + "  ");
            inOrderTraversal(n.right);
        }
    }

    public boolean isEmpty() {
        return (root ==null);
    }

    public void getSingleParent(NodeType<T> n) {
        if(n != null) {
            if((n.left == null && n.right != null) ||(n.left != null && n.right == null)) {
                System.out.print(n.info + " ");
            }
            else {
                getSingleParent(n.left);
                getSingleParent(n.right);
            }
        }
    }

    public int getNumLeafNodes(NodeType<T> n) {
        //recursive case
        int num = 0;
        if(n.left != null && n.right != null) {
            return num + getNumLeafNodes(n.right) + getNumLeafNodes(n.left);
        }
        else if(n.left != null && n.right == null) {
            return num + getNumLeafNodes(n.left);
        }
        else if (n.left == null && n.right != null) {
            return num + getNumLeafNodes(n.right);
        }
        //base case
        else {
            return 1;
        }
    }

    public void getCousins(NodeType<T> n, T key) {
        if(key.compareTo(root.info) == 0) {
            System.out.print(" ");
            return;
        }
        else if(key.compareTo(root.right.info) == 0 || key.compareTo(root.left.info) ==0){
            System.out.print(" ");
            return;
        }
        if(n != null) {
            if(key.compareTo(n.info) < 0) {
                if(n.left != null && n.left.info.compareTo(getParent(root, key).info) == 0) {
                    getChildren(n.right);
                }
                else if(n.right != null && n.right.info.compareTo(getParent(root, key).info) == 0) {
                    getChildren(n.left);
                }
                else if((n.left != null && n.right != null) &&
                (n.left.info.compareTo(getParent(root, key).info) != 0 &&
                n.right.info.compareTo(getParent(root, key).info) != 0)) {
                    getCousins(n.left, key);
                    getCousins(n.right, key);
                }
            }
            else if(key.compareTo(n.info) > 0) {
                if(n.right != null && n.right.info.compareTo(getParent(root, key).info) == 0) {
                    getChildren(n.left);
                }
                else if(n.left != null && n.left.info.compareTo(getParent(root, key).info) == 0) {
                    getChildren(n.right);
                }
                else if((n.left != null && n.right != null) &&
                (n.left.info.compareTo(getParent(root, key).info) != 0 &&
                n.right.info.compareTo(getParent(root, key).info) != 0)) {
                    getCousins(n.left, key);
                    getCousins(n.right, key);
                }
            }
            else {
                getChildren(n);
            }
        }
    }

    public NodeType<T> getParent(NodeType<T> n, T key) {
        NodeType<T> parent = new NodeType<T>();
        if(key.compareTo(n.info) == 0) {
            return n;
        }

        if(n.left != null || n.right != null) {
            if(key.compareTo(n.info) < 0) {
                if(key.compareTo(n.left.info) == 0) {
                    return n;
                }
                else {
                    parent = getParent(n.left, key);
                }
            }
            else if(key.compareTo(n.info) > 0) {
                if(key.compareTo(n.right.info) == 0) {
                    return n;
                }
                else {
                    parent = getParent(n.right, key);
                }
            }
            else  {
                return n;
            }
        }
        return parent;

    }

    public void getChildren(NodeType<T> n) {
        if(n.left != null) {
            System.out.print(n.left.info + " ");
        }
        if(n.right != null) {
            System.out.print(n.right.info + " ");
        }
    }
    public void compTest(T item, T itemm) {
        System.out.print(item.compareTo(itemm));
    }
} //BinarySearchTree
