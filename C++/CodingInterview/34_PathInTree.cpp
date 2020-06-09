///
///题目：二叉树中和为某一值的路劲
///     输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始王下一直到叶子节点所经过的节点形成一条路径。
///

///思路：通过递归的方式来访问树的节点，当访问到某个节点时，先判断它是否是叶子节点，如果叶子节点，判断所经历的节点之和是否等于给定的数，
/// 若等于，则打印出来；若不等于，就要回退到父节点。

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

//打印树中等于targetValue的路径
void printPathInTree(TreeNode *treeNode, int currentValue, int targetValue, stack<TreeNode *> data);

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

    stack<TreeNode *> data;
    printPathInTree(tree1, 0, 22, data);

    return 0;
}

//打印树中等于targetValue的路径
void printPathInTree(TreeNode *rootNode, int currentValue, int targetValue, stack<TreeNode *> data)
{

    data.push(rootNode);
    currentValue += rootNode->value;
    if (currentValue == targetValue && rootNode->leftchild == NULL && rootNode->rightChild == NULL)
    {
        stack<TreeNode *> tempStack;
        while (!data.empty())
        {
            tempStack.push(data.top());
            data.pop();
        }

        while (!tempStack.empty())
        {
            cout << tempStack.top()->value;

            data.push(tempStack.top());
            tempStack.pop();

            if (!tempStack.empty())
            {
                cout << ",";
            }
        }

        cout << endl;
    }

    if (rootNode->leftchild != NULL)
    {
        printPathInTree(rootNode->leftchild, currentValue, targetValue, data);
    }
    if (rootNode->rightChild != NULL)
    {
        printPathInTree(rootNode->rightChild, currentValue, targetValue, data);
    }

    //返回上一层，去掉加入的数据
    data.pop();
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