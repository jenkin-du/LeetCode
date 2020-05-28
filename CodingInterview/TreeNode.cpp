
#include <iostream>
#include <stack>
#include <queue>
using namespace std;

typedef struct TreeNode
{
    int value;
    struct TreeNode *rightChild;
    struct TreeNode *leftchild;
} TreeNode, Node;

//添加子节点
TreeNode *addChild(TreeNode *root, int value, int direction);

int main()
{
    TreeNode *tree1 = new TreeNode();
    tree1->value = 10;
    tree1->leftchild = tree1->rightChild = NULL;

    TreeNode *sn1 = addChild(tree1, 5, -1);
    TreeNode *sn2 = addChild(tree1, 12, 1);
    TreeNode *tn1 = addChild(sn1, 4, -1);
    TreeNode *tn2 = addChild(sn1, 7, 1);

    return 0;
}

//添加子节点
TreeNode *addChild(TreeNode *root, int value, int direction)
{
    TreeNode *node = new TreeNode();
    node->value = value;
    node->leftchild = node->rightChild = NULL;

    if (direction == 1)
    {
        root->rightChild = node;
    }
    if (direction == -1)
    {
        root->leftchild = node;
    }

    return node;
}