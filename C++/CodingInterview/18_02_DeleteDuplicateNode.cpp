///
///题目：删除有序单向链表中的重复的结点
///例如：删除前：1->2->3->3->4->4->5
///    ：删除后：1->2->5
///

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

//删除重复的结点
void deleteDuplicateNode(Node *pHead);

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
    addNewNode(pHead, 6);
    addNewNode(pHead, 7);
    addNewNode(pHead, 7);

    //打印删除后的链表
    printNodeList(pHead);

    //删除结点
    deleteDuplicateNode(pHead);

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

//删除重复的结点
void deleteDuplicateNode(Node *pHead)
{

    Node *node = pHead->next;
    Node *preNode = NULL;

    while (node != NULL)
    {
        Node *nextNode = node->next;
        bool toDelete = false;
        if (nextNode != NULL && node->value == nextNode->value)
        {
            toDelete = true;
        }

        if (toDelete)
        {
            int value = node->value;
            Node *delNode = node;
            while (delNode != NULL && delNode->value == value)
            {
                nextNode = delNode->next;
                delete delNode;
                delNode = NULL;

                delNode = nextNode;
            }
            if (preNode == NULL)
            {
                preNode = pHead;
            }
            preNode->next = nextNode;
            node = nextNode;
        }
        else
        {
            preNode = node;
            node = node->next;
        }
    }
}