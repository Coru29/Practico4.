public class Tree<K, T> implements MyTree<K, T> {
    private Node<K, T> root;

    @Override
    public T find(K key) {
        return find(root, key);
    }

    private T find(Node<K, T> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node.data;
        }
        T left = find(node.leftChild, key);
        if (left != null) {
            return left;
        }
        return find(node.rightChild, key);
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        if (root == null) {
            if (parentKey != null) {
                throw new RuntimeException("Cannot insert a child node when root is null");
            }
            root = new Node<>(key, data);
        } else {
            Node<K, T> parentNode = findNode(root, parentKey);
            if (parentNode == null) {
                throw new RuntimeException("Parent node not found");
            }
            if (parentNode.leftChild == null) {
                parentNode.leftChild = new Node<>(key, data);
            } else if (parentNode.rightChild == null) {
                parentNode.rightChild = new Node<>(key, data);
            } else {
                throw new RuntimeException("Parent node has already two children");
            }
        }
    }



    private Node<K, T> findNode(Node<K, T> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        }
        Node<K, T> left = findNode(node.leftChild, key);
        if (left != null) {
            return left;
        }
        return findNode(node.rightChild, key);
    }

    @Override
    public void delete(K key) {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        if (root.key.equals(key)) {
            root = null;
        } else {
            delete(root, key);
        }
    }

    private void delete(Node<K, T> node, K key) {
        if (node == null) {
            return;
        }
        if (node.leftChild != null && node.leftChild.key.equals(key)) {
            node.leftChild = null;
        } else if (node.rightChild != null && node.rightChild.key.equals(key)) {
            node.rightChild = null;
        } else {
            delete(node.leftChild, key);
            delete(node.rightChild, key);
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<K, T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.leftChild) + size(node.rightChild);
    }

    @Override
    public int countLeaf() {
        return countLeaf(root);
    }

    private int countLeaf(Node<K, T> node) {
        if (node == null) {
            return 0;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 1;
        }
        return countLeaf(node.leftChild) + countLeaf(node.rightChild);
    }

    @Override
    public int countCompleteElements() {
        return countCompleteElements(root);
    }

    private int countCompleteElements(Node<K, T> node) {
        if (node == null) {
            return 0;
        }
        int count = (node.leftChild != null && node.rightChild != null) ? 1 : 0;
        return count + countCompleteElements(node.leftChild) + countCompleteElements(node.rightChild);
    }
}
