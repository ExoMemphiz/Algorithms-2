package implementations;

import java.awt.Color;

public class RedBlackTree {
    public Node root;

    public Node insert(Node root, Node pt) {
        if (root == null)
            return pt;

        if (pt.data < root.data) {
            root.left = insert(root.left, pt);
            root.left.parent = root;
        } else if (pt.data > root.data) {
            root.right = insert(root.right, pt);
            root.right.parent = root;
        }

        return root;
    }

    public void rotateLeft(Node root, Node pt) {
        Node rightNode = pt.right;

        pt.right = rightNode.left;

        if (pt.right != null)
            pt.right.parent = pt;

        rightNode.parent = pt.parent;

        if (pt.parent == null)
            root = rightNode;

        else if (pt == pt.parent.left)
            pt.parent.left = rightNode;

        else
            pt.parent.right = rightNode;

        rightNode.left = pt;
        pt.parent = rightNode;
    }

    void rotateRight(Node root, Node pt) {
        Node leftNode = pt.left;

        pt.left = leftNode.right;

        if (pt.left != null)
            pt.left.parent = pt;

        leftNode.parent = pt.parent;

        if (pt.parent == null)
            root = leftNode;

        else if (pt == pt.parent.left)
            pt.parent.left = leftNode;

        else
            pt.parent.right = leftNode;

        leftNode.right = pt;
        pt.parent = leftNode;
    }


    public void balance(Node root, Node pt) {
        Node parent = null;
        Node grandParent = null;

        while ((pt != root) && (pt.color != Color.BLACK) && (pt.parent.color == Color.RED)) {
            parent = pt.parent;
            grandParent = pt.parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                if (uncle != null && uncle.color == Color.RED) {
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    pt = grandParent;
                } else {
                    if (pt == parent.right) {
                        rotateLeft(root, parent);
                        pt = parent;
                        parent = pt.parent;
                    }

                    rotateRight(root, grandParent);
                    Color tmpColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tmpColor;
                    pt = parent;
                }
            } else {
                Node uncle = grandParent.left;

                if ((uncle != null) && (uncle.color == Color.RED)) {
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    pt = grandParent;
                } else {
                    if (pt == parent.left) {
                        rotateRight(root, parent);
                        pt = parent;
                        parent = pt.parent;
                    }
                    rotateLeft(root, grandParent);
                    Color tmpColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tmpColor;
                    pt = parent;
                }
            }
        }

        root.color = Color.BLACK;
    }

    public void insert(int data) {
        Node pt = new Node(data);
        root = insert(root, pt);
        fixViolation(root, pt);
    }

    private class Node {
        public int data;
        public Color color;
        public Node left, right, parent;

        public Node(int data) {
            this.data = data;
        }
    };
};
