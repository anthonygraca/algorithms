#ifndef ALGORITHMS_PRINCETON_SEARCHING_RED_BLACK_TREE_H_
#define ALGORITHMS_PRINCETON_SEARCHING_RED_BLACK_TREE_H_

#include <string>

namespace algorithms {
class RedBlackTree {
  public:
    RedBlackTree() = default;
    ~RedBlackTree() {
      postorder_delete(m_root);
    }
    RedBlackTree(RedBlackTree&&) = delete;
    RedBlackTree& operator=(RedBlackTree&&) = delete;
    RedBlackTree(const RedBlackTree&) = delete;
    RedBlackTree& operator=(const RedBlackTree&) = delete;
    void put(char key, int val) {
      m_root = put(m_root, key, val);
    }
    int get(char key) {
      return get(m_root, key);
    }
    std::string inorder() {
      return inorder(m_root);
    }
    int size() {
      return size(m_root);
    }
    bool isEmpty() {
      return size() == 0;
    }
    char min() {
      if (isEmpty()) return -1;
      Node* x = min(m_root);
      return x->m_key;
    }
    void deleteMin() {
      if (!isEmpty()) {
        m_root = deleteMin(m_root);
      }
    }
    void deleteNode(char key) {
      m_root = deleteNode(m_root, key);
    }
    char floor(char key) {
      Node* x = floor(m_root, key);
      if (x == nullptr) throw new std::runtime_error("No such element");
      return x->m_key;
    }
    char select(int k) {
      if (k < 0 || k >= size()) throw new std::invalid_argument("illegal argument");
      Node* x = select(m_root, k);
      return x->m_key;
    }
    int rank(char key) {
      return rank(key, m_root);
    }
  private:
    struct Node {
      char m_key;
      int m_val;
      Node* m_left = nullptr;
      Node* m_right = nullptr;
      int m_nodes_in_subtree;
      Node(char key, int val, int n) 
        : m_key(key), m_val(val), m_nodes_in_subtree(n) {};
    };
    /* Change key's value to val if key in subtree rooted at x.
     * Otherwise, add new node to subtree associating key with val. */
    Node* put(Node* x, char key, int val) {
      if (x == nullptr) return new Node(key, val, 1);
      if (key < x->m_key) {
        x->m_left = put(x->m_left, key, val);
      }
      else if (key > x->m_key) {
        x->m_right = put(x->m_right, key, val);
      }
      else {
        x->m_val = val;
      }
      x->m_nodes_in_subtree = size(x->m_left) + size(x->m_right) + 1;
      return x;
    }
    /* Return value associated with key in the subtree rooted at x
     * Return -1 if key not present in subtree rooted at x. */
    int get(Node* x, int key) {
      if (x != nullptr) {
        if (key < x->m_key) {
          return get(x->m_left, key);
        }
        else if (key > x->m_key) {
          return get(x->m_right, key);
        }
        else {
          return x->m_val;
        }
      }
      return -1;
    }
    int size(Node* x) {
      if (x == nullptr) return 0;
      return x->m_nodes_in_subtree;
    }
    Node* min(Node* x) {
      if (x->m_left == nullptr) return x;
      return min(x->m_left);
    }
    Node* deleteMin(Node* x) {
      if (x->m_left == nullptr) {
        Node* save_right_child = x->m_right;
        delete x;
        return save_right_child;
      }
      x->m_left = deleteMin(x->m_left);
      x->m_nodes_in_subtree = size(x->m_left) + size(x->m_right) + 1;
      return x;
    }
    /*
     * 1.) Save a link to the node to be deleted in, t, tree
     * 2.) Set node to be deleted, x, to point to its successor min(t->m_right)
     * 3.) Set the right link of x (which contains all keys larger than 
     *     x->m_key) to detachMin(t->m_right), the link to the BST containing
     *     all the keys that are larger than x->m_key after the deletion.
     * 4.) Set the left link of x (which was null) to t->m_left (all the keys
     *     that are less than both the deleted key and its successor)
     */
    Node* deleteNode(Node* x, char key) {
      if (x == nullptr) return nullptr; 
      if (key < x->m_key) x->m_left = deleteNode(x->m_left, key);
      else if (key > x->m_key) x->m_right = deleteNode(x->m_right, key);
      else {
        if (x->m_right == nullptr) return x->m_left;
        if (x->m_left == nullptr) return x->m_right;
        Node* t = x;
        x = min(t->m_right);
        x->m_right = detachMin(t->m_right);
        x->m_left = t->m_left;
        delete t;
      }
      x->m_nodes_in_subtree = size(x->m_left) + size(x->m_right) + 1;
      return x;
    }
    std::string inorder(Node* x) {
      std::string visited{""};
      if (x != nullptr) {
        visited += inorder(x->m_left);
        visited += x->m_key;
        visited += inorder(x->m_right);
      }
      return visited;
    }
    void postorder_delete(Node* x) {
      if (x != nullptr) {
        postorder_delete(x->m_left);
        postorder_delete(x->m_right);
        delete x;
      }
    }
    Node* detachMin(Node* x) {
      if (x->m_left == nullptr) {
        return x->m_right;
      }
      x->m_left = detachMin(x->m_left);
      x->m_nodes_in_subtree = size(x->m_left) + size(x->m_right) + 1;
      return x;
    }
    Node* floor(Node* x, char key) {
      if (x == nullptr) return nullptr;
      if (key == x->m_key) return x;
      if (key < x->m_key) return floor(x->m_left, key);
      Node* t = floor(x->m_right, key);
      if (t != nullptr) return t;
      else return x;
    }
    Node* select(Node* x, int k) {
      // Return Node* containing key of rank k
      if (x == nullptr) return nullptr;
      int t = size(x->m_left);
      if (t > k) return select(x->m_left, k);
      else if (t < k) return select(x->m_right, k-t-1);
      else return x;
    }
    int rank(char key, Node* x) {
      // Return number of keys less than ke in the subtree rooted at x
      if (x == nullptr) return 0;
      if (key < x->m_key) return rank(key, x->m_left);
      if (key > x->m_key) return 1 + size(x->m_left) + rank(key, x->m_left);
      else return size(x->m_left);
    }
    Node* m_root = nullptr;
};
} // namespace algorithms

#endif
