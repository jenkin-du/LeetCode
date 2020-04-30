///
///题目：删除单向链表中的某个结点，时间复杂度要求为O(1)
///

//思路：将删除结点的下一个结点的值复制到该结点，然后删除下一个结点，即可在O(1)的时间复杂度内完成
//注意：若删除结点下一个结点为空，则需从头结点开始找到删除结点的前一个结点
//      头结点不包含数据，只做一个标记

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

//删除某个结点
void deleteNode(Node *pHead, Node *toDelNode);

int main()
{

    Node *pHead = new Node();
    pHead->value = -1;
    pHead->next = NULL;
    addNewNode(pHead, 1);
    addNewNode(pHead, 2);
    addNewNode(pHead, 3);
    addNewNode(pHead, 3);
    addNewNode(pHead, 4);
    Node *node6 = addNewNode(pHead, 4);
    addNewNode(pHead, 5);
    Node *node8 = addNewNode(pHead, 6);

    //打印删除后的链表
    printNodeList(pHead);

    //删除结点
    deleteNode(pHead, node8);

    //打印删除后的链表
    printNodeList(pHead);
    return 0;
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

    Node *node = pHead->next;
    while (node != NULL)
    {
        cout << node->value << ",";
        node = node->next;
    }
    cout << endl;
}

//删除某个结点
void deleteNode(Node *pHead, Node *toDelNode)
{

    if (pHead == NULL || toDelNode == NULL)
        return;

    if (toDelNode->next != NULL)
    {
        Node *nextNode = toDelNode->next;
        toDelNode->value = nextNode->value;
        toDelNode->next = nextNode->next;

        delete nextNode;
        nextNode = NULL;
    }
    else
    {
        Node *node = pHead;
        while (node->next != toDelNode)
        {
            node = node->next;
        }
        node->next = NULL;
        delete toDelNode;
        toDelNode = NULL;
    }
}