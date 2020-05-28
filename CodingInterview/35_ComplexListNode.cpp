///
///面试题35：复杂链表的复制
///题目：请实现一个函数，复制一个复杂链表。在复杂链表中，每一个节点除了有一个next指针指向下一个节点，
///     还有一个slbling指针指向链表中任意节点或者为空。
///

///思路：
///方式1:先复制每个节点，用next指针连接起来；然后对每个节点，再从头找它sibling 指针的指向；时间复杂度O(n^2);
///方式2：先复制每个节点，用next指针连接起来，并用哈希表存放原始复杂节点的sibling的指向；复制next完成以后，
///再用哈希链表来重建sibling重建复杂链表；时间复杂度O(n)，空间复杂度O(n)；

///以上两种方式都不是最佳，能否用时间复杂度为O(n)，空间复杂度为O(1)来完成？
///方式3：先在原链表中的没有节点后面复制当前节点；
///      然后从头开始在原始链表中新添加的节点连接sibling指针，由于在原链表中，新添加的节点是挨着的，及sibling指针指向的地方也是挨着的，
///      故可以在O(n)的时间复杂度中完成sibling指针的指向；
///      最后，将原链表断开，形成两个链表，即完成复杂链表的复制；

#include <iostream>
using namespace std;

typedef struct ComplexListNode
{
    int value;
    struct ComplexListNode *next;
    struct ComplexListNode *sibling;
} ComplexListNode;

//复制复杂链表
ComplexListNode *cloneComplexListNode(ComplexListNode *phead);

//在原来的链表中克隆添加节点
void cloneAndAddNode(ComplexListNode *pHead);

//对新添加的节点指定sibling的指向
void addNodeSiblingPtr(ComplexListNode *pHead);

//断开原来的链表，形成新的链表
ComplexListNode *reconstructList(ComplexListNode *pHead);

ComplexListNode *addNode(ComplexListNode *pHead, int newVaule);

void printNode(ComplexListNode *pHead);

int main()
{
    ComplexListNode *pHead = new ComplexListNode();
    pHead->value = 1;
    pHead->next = pHead->sibling = NULL;

    ComplexListNode *node2 = addNode(pHead, 2);
    ComplexListNode *node3 = addNode(pHead, 3);
    ComplexListNode *node4 = addNode(pHead, 4);
    ComplexListNode *node5 = addNode(pHead, 5);
    ComplexListNode *node6 = addNode(pHead, 6);
    ComplexListNode *node7 = addNode(pHead, 7);

    node2->sibling = node5;
    node4->sibling = node7;
    node6->sibling = node3;

    ComplexListNode *newHead = cloneComplexListNode(pHead);

    printNode(pHead);
    printNode(newHead);
    return 0;
}

//复制复杂链表
ComplexListNode *cloneComplexListNode(ComplexListNode *phead)
{
    //分三步完成
    cloneAndAddNode(phead);
    addNodeSiblingPtr(phead);
    return reconstructList(phead);
}

//在原来的链表中克隆添加节点
void cloneAndAddNode(ComplexListNode *pHead)
{

    if (pHead == NULL)
        return;

    ComplexListNode *pNode = pHead;
    while (pNode != NULL)
    {
        ComplexListNode *newNode = new ComplexListNode();
        newNode->value = pNode->value;
        newNode->sibling = NULL;

        newNode->next = pNode->next;
        pNode->next = newNode;

        pNode = newNode->next;
    }
}

//对新添加的节点指定sibling的指向
void addNodeSiblingPtr(ComplexListNode *pHead)
{
    if (pHead == NULL)
        return;

    ComplexListNode *pNode = pHead;
    ComplexListNode *pNewNode = pHead->next;
    while (pNode != NULL)
    {
        if (pNode->sibling != NULL)
            pNewNode->sibling = pNode->sibling->next;

        pNode = pNewNode->next;
        if (pNode != NULL)
            pNewNode = pNode->next;
    }
}

//断开原来的链表，形成新的链表
ComplexListNode *reconstructList(ComplexListNode *pHead)
{
    if (pHead == NULL)
        return NULL;

    ComplexListNode *pNode = pHead;
    ComplexListNode *pNewHead;
    ComplexListNode *pNewNode = pNewHead = pHead->next;

    while (pNode != NULL)
    {
        pNode->next = pNewNode->next;
        pNode = pNewNode->next;

        if (pNode != NULL)
        {
            pNewNode->next = pNode->next;
            pNewNode = pNode->next;
        }
    }

    return pNewHead;
}

ComplexListNode *addNode(ComplexListNode *pHead, int newVaule)
{
    ComplexListNode *newNode = new ComplexListNode();
    newNode->value = newVaule;
    newNode->next = newNode->sibling = NULL;

    ComplexListNode *pNode = pHead;
    while (pNode->next != NULL)
    {
        pNode = pNode->next;
    }
    pNode->next = newNode;
    return newNode;
}

void printNode(ComplexListNode *pHead)
{

    ComplexListNode *pNode = pHead;
    while (pNode != NULL)
    {
        cout << pNode->value;
        if (pNode->sibling != NULL)
        {
            cout << "(" << pNode->sibling->value << ")";
        }

        pNode = pNode->next;
        if (pNode != NULL)
        {
            cout << ",";
        }
    }
    cout << endl;
}
