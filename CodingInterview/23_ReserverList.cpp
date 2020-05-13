///
///题目：输入一个链表，反转链表，并输出
///

///思路：
///定义三个指针，分别指向当前结点，前一个结点和后一个结点，遍历原来的链表，对每一个结点进行链表反转操作。
///注意：
///当链表为空或者只有一个结点的时候的处理

#include <iostream>
using namespace std;

typedef struct Node
{
    int value;
    struct Node *next;
} Node;

//新增结点
Node *addNewNode(Node *pHead, int newValue);

//打印链表
void printNodeList(Node *pHead);

//反转链表
Node *reserveNodeList(Node *pHead);

int main()
{
    Node *pHead = new Node();
    pHead->value = 0;
    pHead->next = NULL;

    addNewNode(pHead, 1);
    addNewNode(pHead, 2);
    addNewNode(pHead, 3);
    addNewNode(pHead, 4);
    addNewNode(pHead, 5);
    addNewNode(pHead, 6);
    addNewNode(pHead, 7);
    addNewNode(pHead, 8);

    cout << "before:" << endl;
    printNodeList(pHead);

    Node *pNewNode = reserveNodeList(pHead);

    cout << "after:" << endl;
    printNodeList(pNewNode);

    return 0;
}

//反转链表
Node *reserveNodeList(Node *pHead)
{
    if (pHead == NULL)
    {
        return NULL;
    }

    Node *pNewHead = NULL;
    Node *pNode = pHead;
    Node *pPrev = NULL;

    while (pNode != NULL)
    {
        Node *pNext = pNode->next;
        if (pNext == NULL)
        {
            pNewHead = pNode;
        }

        pNode->next = pPrev;

        pPrev = pNode;
        pNode = pNext;
    }

    return pNewHead;
}

//新增结点
Node *addNewNode(Node *pHead, int newValue)
{

    Node *node = pHead;
    while (node->next != NULL)
    {
        node = node->next;
    }

    Node *newNode = new Node();
    newNode->value = newValue;
    newNode->next = NULL;

    node->next = newNode;
    node = NULL;
    return newNode;
}

//打印链表
void printNodeList(Node *pHead)
{

    Node *node = pHead;
    while (node != NULL)
    {
        cout << node->value << ",";
        node = node->next;
    }
    cout << endl;
}