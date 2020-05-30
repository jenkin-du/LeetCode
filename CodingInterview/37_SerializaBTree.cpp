///
///面试题37：序列化和反序列化二叉树
///

///思路：通过前序遍历的结构序列化二叉树，对于NULL指针，输出一个特殊符号
///     反序列化时，同样采用前序遍历的结构反序列化，对于特殊符号，则表示是空指针

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

typedef struct TreeNode
{
    int value;
    struct TreeNode *rightChild;
    struct TreeNode *leftchild;
} TreeNode, Node;

//序列化
void serializeBTree(TreeNode *root, vector<int> &data);

//反序列化
void unSerializeBTree(vector<int> data, TreeNode **root);

//非递归后序遍历：左-》右-》根
void traverseNodeInTreePostOrderNonRecrusive(TreeNode *root);

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

    vector<int> data;
    serializeBTree(tree1, data);
    for (int i = 0; i < data.size(); i++)
    {
        cout << data.at(i) << ",";
    }
    cout << endl;

    TreeNode *pHead;
    unSerializeBTree(data, &pHead);

    traverseNodeInTreePostOrderNonRecrusive(tree1);
    return 0;
}

//序列化
void serializeBTree(TreeNode *root, vector<int> &data)
{
    if (root == NULL)
    {
        data.push_back(-10000);
    }
    else
    {
        data.push_back(root->value);
        serializeBTree(root->leftchild, data);
        serializeBTree(root->rightChild, data);
    }
}

//反序列化
void unSerializeBTree(vector<int> data, TreeNode **root)
{
    if (data.at(data.size() - 1) != -10000)
    {
        TreeNode *node = new TreeNode();
        node->value = data.at(data.size() - 1);
        node->leftchild = node->rightChild = NULL;
        *root = node;
        data.pop_back();

        unSerializeBTree(data, &((*root)->leftchild));
        unSerializeBTree(data, &((*root)->rightChild));
    }
    data.pop_back();
}

//非递归后序遍历：左-》右-》根
void traverseNodeInTreePostOrderNonRecrusive(TreeNode *root)
{

    if (root == NULL)
        return;

    stack<TreeNode *> dataStack;
    dataStack.push(root);

    TreeNode *pLastNode = root;
    while (!dataStack.empty())
    {
        TreeNode *topNode = dataStack.top();
        if ((topNode->leftchild == pLastNode || topNode->rightChild == pLastNode) || (topNode->leftchild == NULL && topNode->rightChild == NULL))
        {
            cout << topNode->value << ",";
            dataStack.pop();

            pLastNode = topNode;
            continue;
        }

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