///
///题目：对称二叉树
/// 请判断一个函数，用来判断一颗二叉树是不是对称的。如果一棵二叉树和它的镜像是一样的，那么它是对称的。
///

///思路：
///自定义一种对称前序遍历：先遍历根节点，在遍历右子节点，最后遍历左子节点
///如果前序遍历和对称前序遍历结果一样，那么这颗二叉树是对称的
///注意：要考虑子节点是空指针的情况，因为空指针会导致遍历时跳过而出现问题

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

//是否是对称二叉树
bool isSymmetrical(Tree *root);

//各子节点是否是对称二叉树
bool isSymmetricalCore(TreeNode *node1, TreeNode *node2);

int main()
{
    Tree *tree1 = new Tree();
    tree1->value = 8;
    tree1->leftchild = tree1->rightChild = NULL;

    TreeNode *sn1 = addChild(tree1, 7, -1);
    TreeNode *sn2 = addChild(tree1, 7, 1);
    TreeNode *tn1 = addChild(sn1, 9, -1);
    TreeNode *tn2 = addChild(sn1, 2, 1);
    TreeNode *fn1 = addChild(sn2, 2, -1);
    TreeNode *fn2 = addChild(sn2, 9, 1);

    bool isSymm = isSymmetrical(tree1);

    if (isSymm)
    {
        cout << "The tree is symmetrical" << endl;
    }
    else
    {
        cout << "The tree is not  symmetrical" << endl;
    }

    return 0;
}

//是否是对称二叉树
bool isSymmetrical(Tree *root)
{
    return isSymmetricalCore(root->leftchild, root->rightChild);
}

//各子节点是否是对称二叉树
bool isSymmetricalCore(TreeNode *node1, TreeNode *node2)
{

    if (node1 == NULL && node2 == NULL)
    {
        return true;
    }

    if (node1 == NULL || node2 == NULL)
    {
        return false;
    }

    if (node1->value != node2->value)
    {
        return false;
    }

    return isSymmetricalCore(node1->leftchild, node2->rightChild) && isSymmetricalCore(node1->rightChild, node2->leftchild);
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