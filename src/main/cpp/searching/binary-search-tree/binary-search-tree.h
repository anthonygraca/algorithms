#ifndef ALGORITHMS_PRINCETON_SEARCHING_BINARY_SEARCH_TREE_H_
#define ALGORITHMS_PRINCETON_SEARCHING_BINARY_SEARCH_TREE_H_

#include <string>

namespace algorithms {
class BinarySearchTree {
  public:
    ~BinarySearchTree() {
      postorder_delete(m_root);
    }
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
    bool is_empty() {
      return size() == 0;
    }
    char min() {
      if (is_empty()) return -1;
      Node* x = min(m_root);
      return x->m_key;
    }
  private:
    struct Node {
      char m_key;
      int m_val;
      Node* m_left = nullptr;
      Node* m_right = nullptr;
      int m_nodes_in_subtree;
      Node(char key, int val, int n) : m_key(key), m_val(val), m_nodes_in_subtree(n) {};
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
    void postorder_delete(Node* x) {
      if (x != nullptr) {
        postorder_delete(x->m_left);
        postorder_delete(x->m_right);
        delete x;
      }
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
    Node* m_root = nullptr;
};
} // namespace algorithms
#endif
