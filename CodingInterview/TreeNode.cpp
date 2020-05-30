
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

//非递归前序遍历：根-》左-》右
void traverseNodeInTreePreOrderNonRecrusive(TreeNode *root);

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

//非递归前序遍历：根-》左-》右,要点：用栈，先打印栈顶元素，出栈，先右进，再左进
void traverseNodeInTreePreOrderNonRecrusive(TreeNode *root)
{
    if (root == NULL)
        return;

    stack<TreeNode *> dataStack;
    dataStack.push(root);

    while (!dataStack.empty())
    {
        TreeNode *topNode = dataStack.top();
        cout << topNode->value << ",";
        dataStack.pop();

        if (topNode->rightChild != NULL)
        {
            dataStack.push(topNode->rightChild);
        }
        if (topNode->leftchild != NULL)
        {
            dataStack.push(topNode->leftchild);
        }
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