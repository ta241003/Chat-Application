#include <iostream>
using namespace std;

struct Node {
    string data;
    struct Node *left, *right;
};
 
Node* newNode(string data)
{
    Node* temp = new Node;
    temp->data = data;
    temp->left = temp->right = NULL;
    return temp;
}

void printPreorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    cout << node->data << " ";
 
    printPreorder(node->left);
 
    printPreorder(node->right);
}

void printInorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    printInorder(node->left);
 
    cout << node->data << " ";
 
    printInorder(node->right);
}

void printPostorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    printPostorder(node->left);
 
    printPostorder(node->right);
 
    cout << node->data << " ";
}

int main()
{
    struct Node* root = newNode("*");
    root->left = newNode("-");
    root->right = newNode("/");
    root->left->left = newNode("8");
    root->left->right = newNode("5");
    root->right->left = newNode("+");
    root->right->right = newNode("3");
    root->right->left->left = newNode("4");
    root->right->left->right = newNode("2");
    
    cout << "\nPreorder traversal of binary tree is \n";
    printPreorder(root);
    cout << "\nInorder traversal of binary tree is \n";
	printInorder(root);
	cout << "\nPostorder traversal of binary tree is \n";
	printPostorder(root);
	return 0;
}
