///
///题目：按层次从根节点打印二叉树，每一层分行打印
///

///思路：用一个队列来辅助，打印某层时，把下一层的子节点加入到队列中，按照FIFO的原则，可以实现层次打印
///要实现分行打印，用两个变量来记住本层的节点数和下一层的节点数

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

//层级按行二叉树
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

//层级按行二叉树
void printNodeInTreeHierachyInZStyle(TreeNode *root)
{
    if (root == NULL)
        return;

    queue<TreeNode *> auxQueue;
    int currentCount = 1;
    int nextLevelCount = 0;

    auxQueue.push(root);
    while (!auxQueue.empty())
    {
        TreeNode *node = auxQueue.front();
        cout << node->value;

        if (node->leftchild != NULL)
        {
            nextLevelCount++;
            auxQueue.push(node->leftchild);
        }
        if (node->rightChild != NULL)
        {
            nextLevelCount++;
            auxQueue.push(node->rightChild);
        }

        auxQueue.pop();
        currentCount--;
        if (currentCount == 0)
        {
            cout << endl;
            currentCount = nextLevelCount;
            nextLevelCount = 0;
        }
        else
        {
            cout << ",";
        }
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