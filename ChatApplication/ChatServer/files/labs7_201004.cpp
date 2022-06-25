#include <bits/stdc++.h>
using namespace std;
struct node {
    int data;
    node* left;
    node* right;
};

struct node * MakeNode(int value)
{
    node * temp = new node;
    temp->data = value;
    temp->left = temp->right=NULL;
    return temp;
};

struct max_heap {
    node* root;
};

void createHeap(max_heap &mheap){
    mheap.root = NULL;
}

int insert(node* &root, node* value){
    if (root == NULL)
    {
        root = value;
    }else{
        if (root->data > value->data)
        {
            if (root->right) {
                insert(root->right, value);
                return 0;
            }
            if (root->left) insert (root->left, value);
        }else{
            node* temp = root;
            root= value;
            value = temp;
            insert(value, root);           
        }
    }
    
    return 0;
}

void printHeap(node* root){
    if (root)
    {
        cout<< root->data<<"  ";
        printHeap(root->left);
        printHeap(root->right);
    }
    
}

int main(){
    int arr[8]= { 36, 45,  54, 27, 63, 72, 61, 18};
    max_heap mheap;
    for (int i = 0; i < 8; i++)
    {
        node* temp = new node;
        temp = MakeNode(arr[i]);
        insert(mheap.root, temp);
        cout<<mheap.root->data;
        
    }
    printHeap(mheap.root);
    
}