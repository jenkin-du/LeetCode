///
///题目：找到单项环状链表中的环入口结点
///

///思路
///1.如何确定有环？
/// 可以定义两个一快一慢的指针，快指针一次走两个结点，慢指针一次走一个结点，当快指针遇到慢指针时，说明有环。
///
///2.如何找到环的入口结点？
/// 加入构成环的结点数目是N,定义两个指针，第一个指针先走N个结点，然后第一个指针和第二个指针同步向前走，
/// 当两个指针相遇时，相遇的结点就是环的入口结点。
///
///3.如何确定构成环的结点数目？
/// 根据思路1，当确定有环时，快慢指针相遇时指向的结点肯定在环中，从该结点出发，顺环遍历并计数，
/// 当再次访问到该结点时，就计算到了构成环的节点数

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

//找到环的入口结点
Node *findEntryInLoop(Node *pHead);

//通过一快一慢的指针找到环中相遇的结点
Node *findMeettingNode(Node *pHead);

int main()
{

    Node *pHead = new Node();
    pHead->value = 0;
    pHead->next = NULL;
    addNewNode(pHead, 1);
    addNewNode(pHead, 2);
    Node *node3 = addNewNode(pHead, 3);
    Node *node4 = addNewNode(pHead, 4);
    addNewNode(pHead, 5);
    addNewNode(pHead, 6);
    addNewNode(pHead, 7);
    Node *node8 = addNewNode(pHead, 8);

    //构成环
    node8->next = node4;

    Node *entryNode = findEntryInLoop(pHead);
    if (entryNode != NULL)
    {
        cout << "entry node value:" << entryNode->value << endl;
    }
    else
    {
        cout << "no entry node " << endl;
    }

    return 0;
}

//找到环的入口结点
Node *findEntryInLoop(Node *pHead)
{
    //通过一快一慢指针找到环中的某一个结点
    Node *meetingNode = findMeettingNode(pHead);

    //找到构成环的结点数
    int numOfNodes = 1;
    if (meetingNode == NULL)
    {
        return NULL;
    }
    else
    {
        Node *pNode = meetingNode;
        while (pNode != NULL && pNode->next != meetingNode)
        {
            numOfNodes++;
            pNode = pNode->next;
        }
    }

    //通过定义两个指针来找到环的入口结点
    Node *p1 = pHead, *p2 = pHead;
    //p2先走k（numOfNodes）步
    int i = 0;
    while (p2 != NULL && i < numOfNodes)
    {
        p2 = p2->next;
        i++;
    }

    while (p1 != p2)
    {
        p1 = p1->next;
        p2 = p2->next;
    }

    return p1;
}

//通过一快一慢的指针找到环中相遇的结点
Node *findMeettingNode(Node *pHead)
{
    Node *pSlowNode = pHead;
    Node *pFastNode = pHead;

    while (pSlowNode != NULL && pFastNode != NULL)
    {
        pSlowNode = pSlowNode->next;
        pFastNode = pFastNode->next;
        if (pFastNode != NULL)
        {
            pFastNode = pFastNode->next;
        }
        else
        {
            return NULL;
        }

        if (pSlowNode == pFastNode)
        {
            return pSlowNode;
        }
    }
    return NULL;
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