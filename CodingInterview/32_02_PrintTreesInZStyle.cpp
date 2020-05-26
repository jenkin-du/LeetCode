///
///题目：按层次从根节点打印二叉树，按照z字型的方式打印，第一层正序打印，第二层逆序打印，第三层正序打印…………
///

///思路：用两个栈实现

#include <iostream>
#include <stack>
using namespace std;

typedef struct TreeNode
{
    int value;
    struct TreeNode *rightChild;
    struct TreeNode *leftchild;
} Tree, TreeNode;

//添加子节点
TreeNode *addChild(TreeNode *root, int value, int direction);

//z字型打印二叉树
void printNodeInTreeHierachyInZStyle(TreeNode *root);

int main()
{
    Tree *tree1 = new Tree();
    tree1->value = 8;
    tree1->leftchild = tree1->rightChild = NULL;

    TreeNode *sn1 = addChild(tree1, 8, -1);
    TreeNode *sn2 = addChild(tree1, 7, 1);
    TreeNode *tn1 = addChild(sn1, 9, -1);
    TreeNode *tn2 = addChild(sn1, 2, 1);
    TreeNode *fn1 = addChild(sn2, 4, -1);
    TreeNode *fn2 = addChild(sn2, 7, 1);

    printNodeInTreeHierachyInZStyle(tree1);

    return 0;
}

//z字型打印二叉树
void printNodeInTreeHierachyInZStyle(TreeNode *root)
{

    if (root == NULL)
        return;

    stack<TreeNode *> stack1;
    stack<TreeNode *> stack2;

    stack1.push(root);
    while (!stack1.empty() || !stack2.empty())
    {

        while (!stack1.empty())
        {
            TreeNode *node = stack1.top();
            cout << node->value;

            if (node->leftchild != NULL)
            {
                stack2.push(node->leftchild);
            }
            if (node->rightChild != NULL)
            {
                stack2.push(node->rightChild);
            }
            stack1.pop();

            if (!stack1.empty())
                cout << ",";
        }
        if (!stack2.empty())
            cout << endl;

        while (!stack2.empty())
        {
            TreeNode *node = stack2.top();
            cout << node->value;

            if (node->rightChild != NULL)
            {
                stack1.push(node->rightChild);
            }
            if (node->leftchild != NULL)
            {
                stack1.push(node->leftchild);
            }
            stack2.pop();
            if (!stack2.empty())
                cout << ",";
        }
        if (!stack1.empty())
            cout << endl;
    }
    cout << endl;
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