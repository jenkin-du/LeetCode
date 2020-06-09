///
///题目：给定两个二叉树，问第二课二叉树是不是第一颗二叉树的子树
///

///思路：
///1.先用递归的方式判断第一颗二叉树中存不存在第二颗二叉树根节点一样的值的结点，如果不存在，则不存在该子结构；
///2.在第一颗二叉树中找到了第二棵树根结点一样的值的结点后，通过递归的方式判断是否存在子结构

#include <iostream>
using namespace std;

typedef struct TreeNode
{
    int value;
    struct TreeNode *rightChild;
    struct TreeNode *leftchild;
} Tree, TreeNode;

//第一颗二叉树是否存在第二棵树根结点的值
bool hasNodeInTree1(TreeNode *root1, TreeNode *root2);

//第一颗树中是否包含了第二棵树的子结构
bool hasTree2ContainsTree1(TreeNode *root1, TreeNode *root2);

//添加子节点
TreeNode *addChild(TreeNode *root, int value, int direction);

int main()
{
    Tree *tree1 = new Tree();
    tree1->value = 8;
    tree1->leftchild = tree1->rightChild = NULL;

    TreeNode *sn1 = addChild(tree1, 8, -1);
    TreeNode *sn2 = addChild(tree1, 7, 1);
    TreeNode *tn1 = addChild(sn1, 9, -1);
    TreeNode *tn2 = addChild(sn1, 2, 1);
    TreeNode *fn1 = addChild(tn2, 4, -1);
    TreeNode *fn2 = addChild(tn2, 7, 1);

    Tree *tree2 = new Tree();
    tree2->value = 8;
    tree2->leftchild = tree2->rightChild = NULL;
    addChild(tree2, 9, -1);
    addChild(tree2, 2, 1);

    bool result = hasNodeInTree1(tree1, tree2);
    if (result)
    {
        cout << "has the sub structure" << endl;
    }
    else
    {
        cout << "has not the sub structure" << endl;
    }
    return 0;
}

//第一颗二叉树是否存在第二棵树根结点的值
bool hasNodeInTree1(TreeNode *root1, TreeNode *root2)
{
    bool result = false;
    if (root1 == NULL || root2 == NULL)
    {
        return false;
    }

    if (root1->value == root2->value)
    {
        result = hasTree2ContainsTree1(root1, root2);
    }

    if (!result)
    {
        result = hasNodeInTree1(root1->leftchild, root2);
    }

    if (!result)
    {
        result = hasNodeInTree1(root1->rightChild, root2);
    }

    return result;
}

//第一颗树中是否包含了第二棵树的子结构
bool hasTree2ContainsTree1(TreeNode *root1, TreeNode *root2)
{
    bool result = false;
    if (root2 == NULL)
    {
        return true;
    }

    if (root1 == NULL)
    {
        return false;
    }

    if (root1->value == root2->value)
    {
        result = hasTree2ContainsTree1(root1->leftchild, root2->leftchild) && hasTree2ContainsTree1(root1->leftchild, root2->leftchild);
    }

    return result;
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