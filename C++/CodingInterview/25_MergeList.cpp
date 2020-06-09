///
///题目:融合两个有序（递增）链表，使之融合后仍然有序
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

//递归式的融合链表
Node *mergeNodeListRecursive(Node *pHead1, Node *pHead2);

//非递归式地融合链表
Node *mergeNodeList(Node *pHead1, Node *pHead2);

int main()
{
    Node *pHead1 = new Node();
    pHead1->value = 0;
    pHead1->next = NULL;
    addNewNode(pHead1, 1);
    addNewNode(pHead1, 3);
    addNewNode(pHead1, 5);
    addNewNode(pHead1, 7);
    addNewNode(pHead1, 9);

    Node *pHead2 = new Node();
    pHead2->value = 0;
    pHead2->next = NULL;
    addNewNode(pHead2, 2);
    addNewNode(pHead2, 4);
    addNewNode(pHead2, 6);
    addNewNode(pHead2, 8);
    addNewNode(pHead2, 10);

    Node *mergeHead = mergeNodeList(pHead1, pHead2);
    printNodeList(mergeHead);
    return 0;
}

//递归式的融合链表
Node *mergeNodeListRecursive(Node *pHead1, Node *pHead2)
{
    if (pHead1 == NULL)
    {
        return pHead2;
    }
    else if (pHead2 == NULL)
    {
        return pHead1;
    }

    Node *pMergeHead = NULL;
    if (pHead1->value > pHead2->value)
    {
        pMergeHead = pHead2;
        pMergeHead->next = mergeNodeListRecursive(pHead1, pHead2->next);
    }
    else
    {
        pMergeHead = pHead1;
        pMergeHead->next = mergeNodeListRecursive(pHead2, pHead1->next);
    }

    return pMergeHead;
}

//非递归式地融合链表
Node *mergeNodeList(Node *pHead1, Node *pHead2)
{

    if (pHead1 == NULL)
    {
        return pHead2;
    }
    else if (pHead2 == NULL)
    {
        return pHead1;
    }

    Node *pMergeHead = NULL, *pNode = NULL;
    Node *p1 = pHead1, *p2 = pHead2;

    if (p1->value > p2->value)
    {
        pMergeHead = p2;
        pNode = p2;

        p2 = p2->next;
    }
    else
    {
        pMergeHead = p1;
        pNode = p1;
        p1 = p1->next;
    }

    while (p1 != NULL || p2 != NULL)
    {
        if (p1 != NULL && p2 != NULL)
        {
            if (p1->value > p2->value)
            {
                pNode->next = p2;
                pNode = p2;
                p2 = p2->next;
            }
            else
            {
                pNode->next = p1;
                pNode = p1;
                p1 = p1->next;
            }
            continue;
        }

        if (p1 == NULL)
        {
            pNode->next = p2;
            break;
        }

        if (p2 == NULL)
        {
            pNode->next = p1;
            break;
        }
    }

    return pMergeHead;
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