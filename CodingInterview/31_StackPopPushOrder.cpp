///
///题目:输入两个整数序列，第一个序列表示栈的压入序列，请判断第二个序列是否是改压入序列的弹出顺序。栈中的数据不重复
///

///思路：建立一个辅助栈，把输入的第一个序列总的数字依次压入该辅助栈，并按照第二个序列的顺序从该栈中弹出
///如果下一个弹出的数字刚好是辅助栈顶的数字，那么直接弹出；如果下一个弹出的数字不在辅助栈的栈顶，则把压栈序列中还没入栈的数字压入辅助栈，
///直到把下一个需要弹出的数字压入辅助栈顶为止；如果所有的数字都压入辅助栈后任然没有找到要弹出的数字，那么该序列不可能是一个弹出序列；

#include <iostream>
#include <stack>
using namespace std;

//判断是否是弹出序列
bool isPopOrder(int *pushOrder, int *popOrder, int length);

int main()
{

    int pushOrder[5] = {1, 2, 3, 4, 5};
    int popOrder[5] = {4, 5, 3, 1, 2};
    bool is = isPopOrder(pushOrder, popOrder, 5);
    if (is)
    {
        cout << "the pop order is right." << endl;
    }
    else
    {
        cout << "the pop order is not right." << endl;
    }
}

//判断是否是弹出序列
bool isPopOrder(int *pushOrder, int *popOrder, int length)
{

    if (pushOrder == NULL || popOrder == NULL || length <= 0)
    {
        return false;
    }

    stack<int> auxData;
    int *nextPush = pushOrder;
    int *nextPop = popOrder;
    while (nextPop - popOrder < length)
    {
        while (auxData.empty() || *nextPop != auxData.top())
        {
            if (nextPush - pushOrder == length)
            {
                return false;
            }

            auxData.push(*nextPush);
            nextPush++;
        }

        auxData.pop();
        nextPop++;
    }

    if (auxData.empty() && nextPop - popOrder == length)
    {
        return true;
    }

    return false;
}