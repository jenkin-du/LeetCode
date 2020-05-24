///
///题目：二叉树的镜像
///请完成一个函数，输入一个二叉树，该函数输出它的镜像
///

///思路：
///递归交换根节点的左右子树

#include <iostream>
#include <queue>
using namespace std;

typedef struct TreeNode
{
    int value;
    struct TreeNode *rightChild;
    struct TreeNode *leftchild;
} Tree, TreeNode;

//添加子节点
TreeNode *addChild(TreeNode *root, int value, int direction);

//层级便利二叉树
void printNodeInTreeHierachy(TreeNode *root);

//输出二叉树的镜像
void mirrorInTree(TreeNode *root);

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

    printNodeInTreeHierachy(tree1);

    //输出二叉树的镜像
    mirrorInTree(tree1);

    printNodeInTreeHierachy(tree1);
    return 0;
}

//输出二叉树的镜像
void mirrorInTree(TreeNode *root)
{

    if (root == NULL)
    {
        return;
    }

    TreeNode *tempNode = root->rightChild;
    root->rightChild = root->leftchild;
    root->leftchild = tempNode;

    if (root->leftchild != NULL)
    {
        mirrorInTree(root->leftchild);
    }

    if (root->rightChild != NULL)
    {
        mirrorInTree(root->rightChild);
    }
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

//层级遍历二叉树
void printNodeInTreeHierachy(TreeNode *root)
{
    if (root == NULL)
    {
        return;
    }

    queue<TreeNode *> q;
    q.push(root);

    while (!q.empty())
    {
        TreeNode *node = q.front();
        cout << node->value << ",";

        if (node->leftchild != NULL)
        {
            q.push(node->leftchild);
        }
        if (node->rightChild != NULL)
        {
            q.push(node->rightChild);
        }

        q.pop();
    }
    cout << endl;
}