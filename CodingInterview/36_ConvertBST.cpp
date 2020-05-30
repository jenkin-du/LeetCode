///
///面试题36：转换二叉搜索树为排序双向链表
///

///思路：
///1、二叉排序树的特点：左子树的所有节点的值都比根节点的值大，右子树的所有节点的值都比根节点的值小；
///2、根据这些特点，中序遍历二叉树就能得到有序的结果，所以通过中序遍历来转换这些结果；

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

//转换二叉搜索树为排序双向链表
TreeNode *convertBST(TreeNode *rootNode);

void convertBSTCore(TreeNode *rootNode, TreeNode **pHead);

//非递归方式转换
void *convertBSTCore2(TreeNode *rootNode, TreeNode **pLastNode);

void printTreeNodeInList(TreeNode *rootNode);

int main()
{
    TreeNode *tree1 = new TreeNode();
    tree1->value = 10;
    tree1->leftchild = tree1->rightChild = NULL;

    TreeNode *sn1 = addChild(tree1, 6, -1);
    TreeNode *sn2 = addChild(tree1, 14, 1);
    TreeNode *tn1 = addChild(sn1, 4, -1);
    TreeNode *tn2 = addChild(sn1, 8, 1);
    TreeNode *tn3 = addChild(sn2, 12, -1);
    TreeNode *tn4 = addChild(sn2, 16, 1);

    TreeNode *pHead = convertBST(tree1);
    printTreeNodeInList(pHead);
    return 0;
}

//转换二叉搜索树为排序双向链表
TreeNode *convertBST(TreeNode *rootNode)
{
    if (rootNode == NULL)
    {
        return NULL;
    }

    TreeNode *pLastNode = NULL;

    convertBSTCore2(rootNode, &pLastNode);

    while (pLastNode != NULL && pLastNode->leftchild != NULL)
    {
        pLastNode = (pLastNode)->leftchild;
    }

    return pLastNode;
}

void convertBSTCore(TreeNode *rootNode, TreeNode **pLastNode)
{
    if (rootNode == NULL)
    {
        return;
    }

    if (rootNode->leftchild != NULL)
    {
        convertBSTCore(rootNode->leftchild, pLastNode);
    }

    //convert
    rootNode->leftchild = *pLastNode;
    if (*pLastNode != NULL)
    {
        (*pLastNode)->rightChild = rootNode;
    }
    *pLastNode = rootNode;

    if (rootNode->rightChild != NULL)
    {
        convertBSTCore(rootNode->rightChild, pLastNode);
    }
}

//非递归方式转换
void *convertBSTCore2(TreeNode *rootNode, TreeNode **pLastNode)
{
    if (rootNode == NULL)
    {
        return NULL;
    }
    *pLastNode = NULL;
    stack<TreeNode *> dataStack;
    dataStack.push(rootNode);

    while (!dataStack.empty())
    {
        TreeNode *currentNode = dataStack.top();
        if (currentNode->leftchild != NULL)
        {
            dataStack.push(currentNode->leftchild);
            //防止再次入栈
            currentNode->leftchild = NULL;
        }
        else
        {
            //convert
            currentNode->leftchild = *pLastNode;
            if ((*pLastNode) != NULL)
            {
                (*pLastNode)->rightChild = currentNode;
            }
            *pLastNode = currentNode;
            dataStack.pop();

            if (currentNode->rightChild != NULL)
            {
                dataStack.push(currentNode->rightChild);
                //防止再次入栈
                currentNode->rightChild = NULL;
            }
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

void printTreeNodeInList(TreeNode *rootNode)
{
    TreeNode *pNode = rootNode;
    while (pNode != NULL)
    {
        cout << pNode->value;
        pNode = pNode->rightChild;

        if (pNode != NULL)
        {
            cout << ",";
        }
    }
    cout << endl;
}